import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day112024 {
    public static void main(String[] args) {

        ArrayList<Long> fileData = new ArrayList<Long>();
        fileData.add(8435L);
        fileData.add(234L);
        fileData.add(928434L);
        fileData.add(14L);
        fileData.add(0L);
        fileData.add(7L);
        fileData.add(92446L);
        fileData.add(8992692L);
        System.out.println(fileData);
        int count = fileData.size();
        for (int j = 0; j < 75; j++) {
            for (int i = 0; i < count; i++) {
                if (fileData.get(i) == 0L) {
                    fileData.set(i, 1L);
                } else if (String.valueOf(fileData.get(i)).length() % 2 == 0) {
                    fileData.add(i + 1, Long.parseLong(String.valueOf(fileData.get(i)).substring(String.valueOf(fileData.get(i)).length() / 2)));
                    fileData.set(i, Long.parseLong(String.valueOf(fileData.get(i)).substring(0, String.valueOf(fileData.get(i)).length() / 2)));
                    i++;
                    count++;
                } else {
                    fileData.set(i, (fileData.get(i) * 2024));
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