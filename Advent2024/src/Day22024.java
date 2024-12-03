import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day22024 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("C:\\Users\\BT_4N2_02\\Downloads\\Advent2024-main\\Advent2024-main\\Advent2024\\src\\day2input.txt");
        System.out.println(fileData);
        int count = 0;
        boolean check1 = true;
        boolean check2 = true;
        for (int i = 0; i < fileData.size(); i++) {
            String[] newArray = fileData.get(i).split(" ");
            for (int j = 1; j < newArray.length; j++) {
                System.out.println(Integer.parseInt(newArray[j]));
                if (Integer.parseInt(newArray[0]) < Integer.parseInt(newArray[1])) {
                    if (!(Integer.parseInt(newArray[j]) > Integer.parseInt(newArray[j - 1]))) {
                        check1 = false;
                    }
                    if (!(Math.abs(Integer.parseInt(newArray[j]) - Integer.parseInt(newArray[j - 1])) <= 3)) {
                        check2 = false;
                    }
                } else {
                    if (!(Integer.parseInt(newArray[j]) < Integer.parseInt(newArray[j - 1]))) {
                        check1 = false;
                    }
                    if (!(Math.abs(Integer.parseInt(newArray[j]) - Integer.parseInt(newArray[j - 1])) <= 3)) {
                        check2 = false;
                    }
                }
            }
            if (check1 && check2) {
                count++;
            }
            check1 = true;
            check2 = true;
        }
        System.out.println(count);
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