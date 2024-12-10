import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day52024Part2 {
    public static void main(String[] args) {

        ArrayList<String> fileData = getFileData("src/day5input.txt");
        System.out.println(fileData);
        ArrayList<String> lists = new ArrayList<>();
        ArrayList<String> rules = new ArrayList<>();
        for (int i = 1176; i < fileData.size(); i++) {
            lists.add(fileData.get(i));
        }
        for (int i = 0; i < 1176; i++) {
            rules.add(fileData.get(i));
        }
        System.out.println(lists);
        System.out.println(rules);
        int total = 0;
        for (int i = 0; i < lists.size(); i++) {
            total += checkList(lists.get(i), rules);
        }
        System.out.println(total);
    }
    public static int checkList(String list, ArrayList<String> rules) {
        boolean check = true;
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < rules.size(); i++) {
            if (list.contains(rules.get(i).substring(0,2)) && list.contains(rules.get(i).substring(3,5))) {
                if (list.indexOf(rules.get(i).substring(0,2)) > list.indexOf(rules.get(i).substring(3,5))) {
                    check = false;
                }
            }
        }
        if (check) {
            return Integer.parseInt(list.substring(list.length() / 2 - 1, list.length() / 2 + 1));
        } else {
            for (int i = 0; i < list.length() - 1; i += 3) {
                for (int j = 0; j < rules.size(); j++) {
                    if (list.contains(rules.get(i).substring(0,2)) && list.contains(rules.get(i).substring(3,5)) && rules.get(i).contains(list.substring(i, i + 2))) {
                        if (rules.get(i).substring(0,2).contains(list.substring(i, i + 2))) {
                            leftCount++;
                        }
                        if (rules.get(i).substring(3,5).contains(list.substring(i, i + 2))) {
                            rightCount++;
                        }
                    }
                }
                if (leftCount == rightCount) {
                    return Integer.parseInt(list.substring(i,i + 2));
                }
                leftCount = 0;
                rightCount = 0;
            }
        }
        return 999999999;
    }
    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}