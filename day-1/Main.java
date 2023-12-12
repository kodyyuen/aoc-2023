import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(getTotal());
    }

    public static int getTotal() {
        List<String> words = fileToList("input.txt");
        int total = 0;

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            int len = word.length();
            char first = '\0', second = '\0';
            for (int j = 0; j < len; j++) {
                if (first == '\0' && Character.isDigit(word.charAt(j))) {
                    first = word.charAt(j);
                }
                if (second == '\0' && Character.isDigit(word.charAt(len - j - 1))) {
                    second = word.charAt(len - j - 1);
                }
                if (first != '\0' && second != '\0') {
                    total += Integer.parseInt("" + first + second);
                    break;
                }
            }
        }
        return total;
    }

    public static List<String> fileToList(String filename) {
        List<String> words = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {
                words.add(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return words;
    }
}
