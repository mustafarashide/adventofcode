import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Day02 {
    public static int reportsReader() {
        int safeReports = 0;
        ArrayList<ArrayList<Integer>> reports = new ArrayList<>();
        String regex = "[\\s]";
        try {
            File myObj = new File("inputs/input02.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                ArrayList<Integer> line = new ArrayList<>();
                String data = myReader.nextLine();
                for (String s : data.split(regex)) {
                    line.add(Integer.parseInt(s));
                }
                reports.add(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
            e.printStackTrace();
        }
        //stuck here, i do not know what the clever way of doing this is but i divided into two cases and i am trying to check if going from one integer in the report
        //to the next is legal in each case i.e. decreasing/increasing
        for (ArrayList<Integer> line : reports) {
            if (line.get(0) > line.get(1)) {//if it is decreasing
            } else if (line.get(0) < line.get(1)) {//if it is increasing
            }
        }
        return safeReports;
    }
    public static void main(String[] args) {
        System.out.println(reportsReader());
    }
}
