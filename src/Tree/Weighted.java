package Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 131111 on 1/25/2018.
 */
public class Weighted {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("righttree.dat"));

        int tc = s.nextInt();
        s.nextLine();

        for(int i = 1; i<=tc; i++){
            String raw = s.nextLine();
            char[] chars = raw.toCharArray();
            int[] weight = new int[chars.length];
            for(int x = 0; x<chars.length; x++){
                weight[x] = (int)chars[x]-48;
            }

            if(isRight(weight)){
                System.out.println("Tree "+ i +" is a right-tree.");
            }else{
                System.out.println("Tree "+ i +" is not a right-tree.");
            }
        }
    }

    private static boolean isRight(int[] nums){
        if(nums.length == 1){
            return true;
        }
        if(nums.length != Math.pow(2, Math.ceil(Math.log(nums.length)/Math.log(2)))-1){
            return false;
        }

        for(int i = nums.length-2; i > 0; i-=2){
            if(nums[i] > nums[i+1]){
                return false;
            }else{
                nums[(i-1)/2] += nums[i] + nums[i+1];
            }
        }

        return true;
    }
}
