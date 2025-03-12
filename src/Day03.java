import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.*;

public class Day03 {

    public static String reader() throws FileNotFoundException {
        StringBuilder input = new StringBuilder();
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
    public static int partOne(String input) throws FileNotFoundException {
        int result = 0;
        Pattern multiplications = Pattern.compile("mul\\(\\d*,\\d*\\)");
        Matcher matcher = multiplications.matcher(input);
        while (matcher.find()) {
            Integer i = Integer.valueOf(matcher.group().split(",")[0].replaceAll("[^0-9]", ""));
            Integer j = Integer.valueOf(matcher.group().split(",")[1].replaceAll("[^0-9]", ""));//i know i may not need this but just in case
            result += i * j;
        }
        return result;
    }
    public static int partTwo(String input) throws FileNotFoundException {
        int total= 0;
        boolean isActive=true;
        Pattern illegalMultiplications = Pattern.compile("mul\\(\\d*,\\d*\\)|don't\\(\\)|do\\(\\)");
        Matcher illegalMatcher = illegalMultiplications.matcher(input);
        while (illegalMatcher.find()) {
            if(illegalMatcher.group().equals("don't()")) {isActive=false;}
            if(illegalMatcher.group().equals("do()")) {isActive=true;}
            System.out.println(illegalMatcher.group());
            if(!illegalMatcher.group().equals("don't()")&&!illegalMatcher.group().equals("do()")){
                Integer i = Integer.valueOf(illegalMatcher.group().split(",")[0].replaceAll("[^0-9]", ""));
                Integer j = Integer.valueOf(illegalMatcher.group().split(",")[1].replaceAll("[^0-9]", ""));
                if (isActive) {
                    total += i * j;
                }
            }
        }
        return total;
    }
    public static void main(String[] args) throws FileNotFoundException {
        int b= partTwo(reader());
        System.out.println(b);
    }
}
