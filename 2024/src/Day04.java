import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day04 {
    //we define a method to create a two-dimensional array to store the input
    public static char[][] readingInput(String filename) {
        char[][] map = new char[10][10];
        try {
            File myObj = new File("inputs/" + filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                    //we need to create some looping structure to fill up our map
                    //it should be like 0,0;0,1;0,2;0,3;0,4;0,5;0,6;0,7;0,8;0,9
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 10; j++) {
                            System.out.println("i=" + i + " j=" + j);
                        }
                    }
                }
        }
       catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }
        return map;
    }
    public static void main(String[] args) {
        char[][] map = readingInput("testday04.txt");
        //System.out.println(Arrays.deepToString(map).replace("], ", "]\n"));
    }
}
