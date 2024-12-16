import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day92024 {
    public static void main(String[] args) {

        String fileData = String.valueOf(getFileData("src/day9input.txt")).substring(1, String.valueOf(getFileData("src/day9input.txt")).length() - 1);
        System.out.println(fileData);
        int current = 0;
        boolean toggle = true;
        ArrayList<String> step1 = new ArrayList<>();
        ArrayList<String> step2 = new ArrayList<>();
        ArrayList<String> newFileData = new ArrayList<>();
        for (int i = 0; i < fileData.length(); i++) {
            newFileData.add(fileData.substring(i, i + 1));
        }
        System.out.println(newFileData);
        for (int i = 0; i < newFileData.size(); i++) {
            for (int j = 0; j < Integer.parseInt(newFileData.get(i)); j++) {
                if (toggle) {
                    step1.add(String.valueOf(current));
                } else {
                    step1.add(".");
                }
            }
            if (toggle) {
                current++;
                toggle = false;
            } else {
                toggle = true;
            }
        }
        System.out.println(step1);
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