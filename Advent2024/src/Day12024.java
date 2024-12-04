//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Day12024 {
    public static void main(String[] args) {
        int total = 0;
        int similarity = 0;
        ArrayList<String> fileData = getFileData("src/day1input.txt");
        System.out.println(fileData);
        int[] list1 = new int[fileData.size()];
        int[] list2 = new int[fileData.size()];
        for (int i = 0; i < fileData.size(); i++) {
            String[] newArray = fileData.get(i).split("   ");
            System.out.println(Integer.parseInt(newArray[0]));
            list1[i] = Integer.parseInt(newArray[0]);
            System.out.println(Integer.parseInt(newArray[1]));
            list2[i] = Integer.parseInt(newArray[1]);
        }
        Arrays.sort(list1);
        Arrays.sort(list2);
        int score = 0;
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.size(); j++) {
                if (list1[i] == list2[j]) {
                    score++;
                }
            }
            similarity += (list1[i] * score);
            score = 0;
        }
        for (int i = 0; i < fileData.size(); i++) {
            total += Math.abs(list1[i] - list2[i]);
        }
        System.out.println(Arrays.toString(list1));
        System.out.println(Arrays.toString(list2));
        System.out.println(total);
        System.out.println(similarity);
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
