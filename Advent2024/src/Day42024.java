import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day42024 {
    public static void main(String[] args) {
        int count = 0;
        ArrayList<String> fileData = getFileData("src/day4input.txt");
        System.out.println(fileData);
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length() - 3; j++) {
                if (fileData.get(i).substring(j, j + 4).equals("XMAS") || fileData.get(i).substring(j, j + 4).equals("SAMX")) {
                    count++;
                }
            }
        }
        for (int i = 0; i < fileData.size() - 3; i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                if (fileData.get(i).substring(j, j + 1).equals("X") && fileData.get(i + 1).substring(j, j + 1).equals("M") && fileData.get(i + 2).substring(j, j + 1).equals("A") && fileData.get(i + 3).substring(j, j + 1).equals("S")) {
                    count++;
                }
                if (fileData.get(i).substring(j, j + 1).equals("S") && fileData.get(i + 1).substring(j, j + 1).equals("A") && fileData.get(i + 2).substring(j, j + 1).equals("M") && fileData.get(i + 3).substring(j, j + 1).equals("X")) {
                    count++;
                }
            }
        }
        for (int i = 0; i < fileData.size() - 3; i++) {
            for (int j = 0; j < fileData.get(i).length() - 3; j++) {
                if (fileData.get(i).substring(j, j + 1).equals("X") && fileData.get(i + 1).substring(j + 1, j + 2).equals("M") && fileData.get(i + 2).substring(j + 2, j + 3).equals("A") && fileData.get(i + 3).substring(j + 3, j + 4).equals("S")) {
                    count++;
                }
            }
            for (int j = 0; j < fileData.get(i).length() - 3; j++) {
                if (fileData.get(i).substring(j, j + 1).equals("S") && fileData.get(i + 1).substring(j + 1, j + 2).equals("A") && fileData.get(i + 2).substring(j + 2, j + 3).equals("M") && fileData.get(i + 3).substring(j + 3, j + 4).equals("X")) {
                    count++;
                }
            }
        }
        for (int i = 0; i < fileData.size() - 3; i++) {
            for (int j = 3; j < fileData.get(i).length(); j++) {
                if (fileData.get(i).substring(j, j + 1).equals("X") && fileData.get(i + 1).substring(j - 1, j).equals("M") && fileData.get(i + 2).substring(j - 2, j - 1).equals("A") && fileData.get(i + 3).substring(j - 3, j - 2).equals("S")) {
                    count++;
                }
                if (fileData.get(i).substring(j, j + 1).equals("S") && fileData.get(i + 1).substring(j - 1, j).equals("A") && fileData.get(i + 2).substring(j - 2, j - 1).equals("M") && fileData.get(i + 3).substring(j - 3, j - 2).equals("X")) {
                    count++;
                }
            }
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