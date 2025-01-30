import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.*;

public class Day03 {
    static StringBuilder input = new StringBuilder();
    public static String reader() throws FileNotFoundException {
        try {
            File myObj = new File("inputs/input03.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                input.append(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return input.toString();
    }
    public static int result() throws FileNotFoundException {
        String reader = reader();
        int result = 0;
        Pattern multiplications = Pattern.compile("mul\\(\\d*,\\d*\\)");
        Matcher matcher = multiplications.matcher(reader);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
        return result;
    }
    public static void main(String[] args) throws FileNotFoundException {
        result();
    }
}