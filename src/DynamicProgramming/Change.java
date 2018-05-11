package DynamicProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Change {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("change.dat"));

        int tc = s.nextInt();
        for(int x = 0; x<tc; x++){
            int change = s.nextInt();
            int numberOfCoins = s.nextInt();

            int[] coins = new int[numberOfCoins];

            for(int y = 0; y<x; y++){
                coins[y] = s.nextInt();
            }

            System.out.println(getChange(change, coins));
        }
    }

    private static int getChange(int change, int[] coins) {
        int[][] dp = new int[coins.length][change];
        for(int[] array: dp){
            Arrays.fill(array, Integer.MAX_VALUE);
        }
        return dynamic(dp, coins);
    }

    private static int dynamic(int[][] dp, int[] coins) {
        for(int y = 0; y<dp.length; y++){
            for(int x = 0; x<dp[0].length; x++){

            }
        }
        return 0;
    }
}
