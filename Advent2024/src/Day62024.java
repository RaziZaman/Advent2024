import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Day62024 {
    public static void main(String[] args) {
        int condition = 0;
        ArrayList<String> fileData = getFileData("src/day6input.txt");
        System.out.println(fileData);
        while (condition == 0) {
            condition = move(fileData);
        }
        System.out.println(condition);
    }
    public static int move(ArrayList<String> fileData) {
        int x = 0;
        int y = 0;
        int count = 0;
        ArrayList<String> newArray = fileData;
        String position = "up";
        for (int i = 0; i < fileData.size(); i++) {
            for (int j = 0; j < fileData.get(i).length(); j++) {
                if (fileData.get(i).substring(j, j + 1).equals("^")) {
                    y = i;
                    x = j;
                }
            }
        }
        while (x != 999999999) {
            System.out.println(x + ", " + y);
            if (position.equals("up")) {
                if (y - 1 < 0) {
                    return count;
                }
                if (fileData.get(y - 1).substring(x, x + 1).equals("#")) {
                    position = "right";
                } else {
                    newArray.set(y, newArray.get(y));
                    y--;
                    count++;
                }
            } else if (position.equals("right")) {
                if (x + 2 > fileData.get(y).length()) {
                    return count;
                }
                if (fileData.get(y).substring(x + 1, x + 2).equals("#")) {
                    position = "down";
                } else {
                    x++;
                    count++;
                }
            } else if (position.equals("left")) {
                if (x - 1 < 0) {
                    return count;
                }
                if (fileData.get(y).substring(x - 1, x).equals("#")) {
                    position = "up";
                } else {
                    x--;
                    count++;
                }
            } else if (position.equals("down")) {
                if (y + 1 > fileData.size()) {
                    return count;
                }
                if (fileData.get(y + 1).substring(x, x + 1).equals("#")) {
                    position = "left";
                } else {
                    y++;
                    count++;
                }
            }
        }
        System.out.println(x);
        System.out.println(y);
        return count;
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