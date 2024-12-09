import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day42024Part2 {
    public static void main(String[] args) {
        int count = 0;
        ArrayList<String> fileData = getFileData("src/day4input.txt");
        System.out.println(fileData);
        String M = "M";
        String S = "S";
        for (int i = 0; i < fileData.size() - 2; i++) {
            for (int j = 0; j < fileData.get(i).length() - 2; j++) {
                if (fileData.get(i).substring(j,j + 1).equals(M) && fileData.get(i).substring(j + 2,j + 3).equals(S) && fileData.get(i + 2).substring(j,j + 1).equals(M) && fileData.get(i + 2).substring(j + 2,j + 3).equals(S) && fileData.get(i + 1).substring(j + 1,j + 2).equals("A")) {
                    count++;
                }
            }
            for (int j = 0; j < fileData.get(i).length() - 2; j++) {
                if (fileData.get(i).substring(j,j + 1).equals(M) && fileData.get(i).substring(j + 2,j + 3).equals(M) && fileData.get(i + 2).substring(j,j + 1).equals(S) && fileData.get(i + 2).substring(j + 2,j + 3).equals(S) && fileData.get(i + 1).substring(j + 1,j + 2).equals("A")) {
                    count++;
                }
            }
        }
        M = "S";
        S = "M";
        for (int i = 0; i < fileData.size() - 2; i++) {
            for (int j = 0; j < fileData.get(i).length() - 2; j++) {
                if (fileData.get(i).substring(j,j + 1).equals(M) && fileData.get(i).substring(j + 2,j + 3).equals(S) && fileData.get(i + 2).substring(j,j + 1).equals(M) && fileData.get(i + 2).substring(j + 2,j + 3).equals(S) && fileData.get(i + 1).substring(j + 1,j + 2).equals("A")) {
                    count++;
                }
            }
            for (int j = 0; j < fileData.get(i).length() - 2; j++) {
                if (fileData.get(i).substring(j,j + 1).equals(M) && fileData.get(i).substring(j + 2,j + 3).equals(M) && fileData.get(i + 2).substring(j,j + 1).equals(S) && fileData.get(i + 2).substring(j + 2,j + 3).equals(S) && fileData.get(i + 1).substring(j + 1,j + 2).equals("A")) {
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