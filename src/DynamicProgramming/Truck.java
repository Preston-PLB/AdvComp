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
            int[] space = new int[pairs];
            int[] cost = new int[pairs];

            for(int i = 0; i<pairs; i++){
                space[i] = s.nextInt();
                cost[i] = s.nextInt();
            }

            System.out.println(getMax(cap, pairs, space, cost));
        }
    }

    private static int getMax(int cap, int pairs, int[] space, int[] cost) {
        int[][] dp = new int[pairs+1][cap+1];
        for(int[] array: dp){
            Arrays.fill(array, 0);
        }
        return dynamic(dp, space, cost);
    }

    private static int dynamic(int[][] dp, int[] weights, int[] value){
        for(int y = 1; y<dp.length; y++){
            for(int x = 1; x<dp[0].length; x++){
                if(x < weights[y-1]){
                    dp[y][x] = Math.max(0, dp[y-1][x]);
                }else{
                    int ly = y-1;
                    int choice1 = dp[y][x-weights[ly]]+value[ly];
                    int choice2 = dp[ly][x];
                    dp[y][x] = Math.max(choice1, choice2);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    private static void printArray(int[][] array){
        for(int[] a: array){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
    }
}
