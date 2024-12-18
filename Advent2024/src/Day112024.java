import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day112024 {
    public static void main(String[] args) {

        ArrayList<Integer> fileData = new ArrayList<>();
        fileData.add(8435);
        fileData.add(234);
        fileData.add(928434);
        fileData.add(14);
        fileData.add(0);
        fileData.add(7);
        fileData.add(92446);
        fileData.add(8992692);
        System.out.println(fileData);
        for (int j = 0; j < 25; j++) {
            for (int i = 0; i < fileData.size(); i++) {
                if (fileData.get(i) == 0) {
                    fileData.set(i, 1);
                } else if (String.valueOf(fileData.get(i)).length() % 2 == 0) {
                    fileData.set(i, Integer.valueOf(String.valueOf(fileData.get(i)).substring(0,String.valueOf(fileData.get(i)).length() / 2)));
                    fileData.add( i + 1,Integer.valueOf(String.valueOf(fileData.get(i)).substring(String.valueOf(fileData.get(i)).length() / 2)));
                } else {
                    fileData.set(i, (int) ((double) fileData.get(i) * 2024));
                }
            }
            System.out.println(fileData);
        }
        System.out.println(fileData.size());
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