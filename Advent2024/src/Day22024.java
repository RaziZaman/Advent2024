import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day22024 {
    public static void main(String[] args) {
        ArrayList<String> fileData = getFileData("src/day2input.txt");
        System.out.println(fileData);
        int count = 0;
        int safeCount = 0;
        for (int i = 0; i < fileData.size(); i++) {
            String[] newArray = fileData.get(i).split(" ");
            for (int j = 1; j < newArray.length; j++) {
                System.out.println(Integer.parseInt(newArray[j]));
                if (Integer.parseInt(newArray[0]) < Integer.parseInt(newArray[1])) {
                    if (!(Integer.parseInt(newArray[j]) > Integer.parseInt(newArray[j - 1]))) {
                        if (j - 2 == -1) {
                            if (!(Integer.parseInt(newArray[j + 1]) > Integer.parseInt(newArray[j - 1]))) {
                                safeCount++;
                            }
                        } else if (!(Integer.parseInt(newArray[j]) > Integer.parseInt(newArray[j - 2]))) {
                            safeCount++;
                        }
                        safeCount++;
                    } else if (!(Math.abs(Integer.parseInt(newArray[j]) - Integer.parseInt(newArray[j - 1])) <= 3) && (!(Math.abs(Integer.parseInt(newArray[j]) - Integer.parseInt(newArray[j - 1])) >= 1))) {
                        if (j - 2 == -1) {
                            if (!(Math.abs(Integer.parseInt(newArray[j + 1]) - Integer.parseInt(newArray[j - 1])) <= 3) || !(Math.abs(Integer.parseInt(newArray[j + 1]) - Integer.parseInt(newArray[j - 1])) >= 1)) {
                                safeCount++;
                            }
                        } else if (!(Math.abs(Integer.parseInt(newArray[j]) - Integer.parseInt(newArray[j - 2])) <= 3) || !(Math.abs(Integer.parseInt(newArray[j]) - Integer.parseInt(newArray[j - 2])) >= 1)) {
                            safeCount++;
                        }
                        safeCount++;
                    }
                } else {
                    if (!(Integer.parseInt(newArray[j]) < Integer.parseInt(newArray[j - 1]))) {
                        if (j - 2 == -1) {
                            if (!(Integer.parseInt(newArray[j + 1]) < Integer.parseInt(newArray[j - 1]))) {
                                safeCount++;
                            }
                        } else if (!(Integer.parseInt(newArray[j]) < Integer.parseInt(newArray[j - 2]))) {
                            safeCount++;
                        }
                        safeCount++;
                    } else if (!(Math.abs(Integer.parseInt(newArray[j]) - Integer.parseInt(newArray[j - 1])) <= 3) && (!(Math.abs(Integer.parseInt(newArray[j]) - Integer.parseInt(newArray[j - 1])) >= 1))) {
                        if (j - 2 == -1) {
                            if (!(Math.abs(Integer.parseInt(newArray[j + 1]) - Integer.parseInt(newArray[j - 1])) <= 3) || !(Math.abs(Integer.parseInt(newArray[j + 1]) - Integer.parseInt(newArray[j - 1])) >= 1)) {
                                safeCount++;
                            }
                        } else if (!(Math.abs(Integer.parseInt(newArray[j]) - Integer.parseInt(newArray[j - 2])) <= 3) || !(Math.abs(Integer.parseInt(newArray[j]) - Integer.parseInt(newArray[j - 2])) >= 1)) {
                            safeCount++;
                        }
                        safeCount++;
                    }
                }
            }
            if (safeCount <= 1) {
                count++;
            }
            safeCount = 0;
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