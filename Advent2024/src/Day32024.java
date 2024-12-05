
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Day32024 {
    public static void main(String[] args) {
        ArrayList<String> matches = new ArrayList<String>();
        ArrayList<String> fileData = getFileData("src/day3input.txt");
        System.out.println(fileData);
        int total = 0;
        boolean status = true;
        String regex = "mul\\(([1-9]|[1-9][0-9]|[1-9][0-9][0-9]),([1-9]|[1-9][0-9]|[1-9][0-9][0-9])\\)";
        String regex2 = "don't()";
        String regex3 = "do()";
        Matcher match;
        Matcher current2;
        Matcher current3;
        for (int i = 0; i < fileData.size(); i++) {
                match = Pattern.compile(regex).matcher(fileData.get(i));
                current2 = Pattern.compile(regex2).matcher(fileData.get(i));
                current3 = Pattern.compile(regex3).matcher(fileData.get(i));
                while (match.find()) {
                    while (current2.find()) {
                        status = false;
                    }
                    while (current3.find()) {
                        status = true;
                    }
                    if (status) {
                        matches.add(match.group());
                    }
                }
        }

        System.out.println(matches);
        for (int i = 0; i < matches.size(); i++) {
            String[] value = matches.get(i).split(",");
            total += Integer.parseInt(value[0].substring(4)) * Integer.parseInt(value[1].substring(0,value[1].length() - 1));
        }
        System.out.println(total);
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