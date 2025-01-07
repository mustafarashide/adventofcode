//kth smallest where k goes from 1 to 1000
// 1) read input, create two lists & 2) use quickselect on each list from 1 to 1000
// for part two
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day01{
    //part one
     public static int output(List<Integer> left,List<Integer> right){
         int output=0;
         for (int k=1;k<=1000;k++){
             if(quickSelect(right, k)>=quickSelect(left, k)){output+=(quickSelect(right, k))-(quickSelect(left, k));}
             else{output+=(quickSelect(left, k)-(quickSelect(right, k)));}
         }
         return output;
     }
     public static int quickSelect(List<Integer> nums, int k){
         int n = nums.size();
         if(n==1){return nums.get(0);}
         int pivotIndex = new Random().nextInt(nums.size());
         int pivot = nums.get(pivotIndex);

         List<Integer> L = new ArrayList<>();
         List<Integer> E = new ArrayList<>();
         List<Integer> G = new ArrayList<>();

         for (int num:nums){
             if(num>pivot){G.add(num);}
             else if(num<pivot){L.add(num);}
             else {E.add(num);}
         }
         if(k<=L.size()){
             return quickSelect(L,k);
         }
         else if(k<=L.size()+E.size()){return pivot;}
         else{
             return quickSelect(G, k-L.size()-E.size());
         }
     }
    public static void main(String[] args){
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        String regex = "[\\s]";
        try {
            File myObj = new File("inputs/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                left.add(Integer.valueOf(data.split(regex)[0]));
                right.add(Integer.valueOf(data.split(regex)[3]));
            }
            myReader.close();
        }
        catch(FileNotFoundException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
         System.out.println(output(left,right));
    }
}