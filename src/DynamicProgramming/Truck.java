package DynamicProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Truck {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("truck.dat"));

        int tc = s.nextInt();
        for(int h = 0; h<tc; h++){
            int cap = s.nextInt();
            int pairs = s.nextInt();
            int[] weights = new int[pairs];
            int[] values = new int[pairs];

            for(int i = 0; i<pairs; i++){
                weights[i] = s.nextInt();
                values[i] = s.nextInt();
            }

            System.out.println(getMax(cap, pairs, weights, values));
        }
    }

    private static int getMax(int cap, int pairs, int[] weights, int[] values) {
        int[][] dp = new int[pairs+1][cap+1];
        for(int[] array: dp){
            Arrays.fill(array, -1);
            array[0] = 0;
        }
        Arrays.fill(dp[0], 0);

        return recursive(dp, weights, values, dp[0].length-1, dp.length-1);
        //return dynamic(dp, weights, values);
    }

    private static int dynamic(int[][] dp, int[] weights, int[] values){
        for(int y = 1; y<dp.length; y++){
            for(int x = 1; x<dp[0].length; x++){
                if(x < weights[y-1]){
                    dp[y][x] = Math.max(0, dp[y-1][x]);
                }else{
                    int ly = y-1;
                    int choice1 = dp[y][x-weights[ly]]+values[ly];
                    int choice2 = dp[ly][x];
                    dp[y][x] = Math.max(choice1, choice2);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    private static int recursive(int[][] dp, int[] weights, int[] values, int i, int w){
        if(w < 1){
            return 0;
        }
        if(dp[w][i] == -1){
            if(i < weights[w-1]){
                dp[w][i] = Math.max(0, recursive(dp, weights, values, i, w-1));
            }else{
                int lw = w-1;
                int choice1 = recursive(dp, weights, values, i-weights[lw], w)+values[lw];
                int choice2 = recursive(dp, weights, values, i, lw);
                dp[w][i] = Math.max(choice1, choice2);
            }
        }
        return dp[w][i];
    }
}
