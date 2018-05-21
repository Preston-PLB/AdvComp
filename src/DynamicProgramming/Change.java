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

            for(int y = 0; y<numberOfCoins; y++){
                coins[y] = s.nextInt();
            }

            System.out.println(getChange(change, coins));
        }
    }

    private static int getChange(int change, int[] coins) {
        int[][] dp = new int[coins.length+1][change];
        for(int[] array: dp){
            Arrays.fill(array, Integer.MAX_VALUE);
        }
        return dynamic(dp, coins);
    }

    private static int dynamic(int[][] dp, int[] coins) {

        for(int i = 0; i<dp[0].length; i++){
            dp[1][i] = i % coins[0] == 0 ? i / coins[0] : Integer.MAX_VALUE;
        }

        for(int y = 2; y<dp.length; y++){
            for(int x = 0; x<dp[0].length; x++){
                if(x < coins[y-1]){
                    dp[y][x] = dp[y-1][x];
                }else{
                    int choice1 = dp[y][x-coins[y-1]]+1;
                    int choice2 = dp[y-1][x];
                    dp[y][x] = Math.min(choice1, choice2);
                }
            }
        }
        printarray(dp);
        return dp[dp.length-1][dp[0].length-1];
    }

    static int[] trace(int y, int x, int[] coins, int[][] dp){
        if(y == 1 && dp[y][x] != 0){
            coins[y] =
        }
    }

    static void printarray(int[][] arr){
        for(int[] a: arr){
            System.out.println(Arrays.toString(a));
        }
    }

}
