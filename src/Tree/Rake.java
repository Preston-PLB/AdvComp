package Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 131111 on 1/31/2018.
 */
public class Rake {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("rake.dat"));

        while(s.hasNextLine()){
            String line = s.nextLine().trim();
            if(line.equals("-1")){
                break;
            }
            String[] nums = line.split(" ");

            int[] trees = new int[nums.length];

            for(int i = 0; i<nums.length; i++){
                trees[i] = Integer.parseInt(nums[i]);
            }

            Tree t = new Tree(trees);
            t.fill();

            System.out.println(t);
        }
    }

}
