import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Day02 {
    public static ArrayList<ArrayList<Integer>> reportsReader() {
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
        return reports;
    }

    public static boolean safeReports(ArrayList<Integer> report) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : report) {
            set.add(i);
        }
        if (set.size() - report.size() == -1) {
            //return false;//if there is a duplicate, then for sure this is not a safe report
            return false;
        }
        for (int i = 0; i < report.size() - 1; i++) {
            if (Math.abs(report.get(i) - report.get(i + 1)) != 1 && Math.abs(report.get(i) - report.get(i + 1)) != 2 && Math.abs(report.get(i) - report.get(i + 1)) != 3) {
                return false;
            }
        }
        //check if increasing/decreasing
        //if increasing check if sorted report is unequal to report
        //if decreasing check if reversed sorted report is unequal to report
        if (report.get(0) < report.get(1)) {
            ArrayList<Integer> sorted = new ArrayList<>(report);
            Collections.sort(sorted);
            if (!sorted.equals(report)) {
                return false;
            }
            ;
        }
        if (report.get(0) > report.get(1)) {
            ArrayList<Integer> reversedSorted = new ArrayList<>(report);
            Collections.sort(reversedSorted);
            Collections.reverse(reversedSorted);
            return reversedSorted.equals(report);
        }
        return true;
    }

    //part two, we are literally removing one level at a time :/
    public static boolean safeReportsDampener(ArrayList<Integer> report) {
        for (int i = 0; i < report.size(); i++) {
            ArrayList<Integer> levelRemoved = new ArrayList<>(report);
            levelRemoved.remove(i);
            if (safeReports(levelRemoved)) {
                return true;
            }
        }
        return false;
    }
}
