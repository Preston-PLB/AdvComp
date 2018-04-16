package DynamicProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Bottles {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("bottles.dat"));

        int tc = s.nextInt();

        for(int x = 0; x<tc; x++){
            int b = s.nextInt();
            int[] vol = new int[b];

            for(int i = 0; i<b; i++){
                vol[i] = s.nextInt();
            }

            System.out.println(maxVol(vol));
        }
    }

    private static int maxVol(int[] vol) {
        int[] dp = new int[vol.length];
        Arrays.fill(dp, -1);
        return othetrLoop(vol,dp);
    }

    private static int loop(int[] vol, int[] dp, int i) {
        if(i == 0){
            dp[0] = vol[0];
            return dp[0];
        }else if(i == 1){
            dp[1] = Math.max(vol[0], vol[1]);
            return dp[1];
        }else{
            if(dp[i] == -1){
                dp[i] = Math.max(loop(vol, dp, i-2)+vol[i], loop(vol, dp, i-1));
            }
            return dp[i];
        }
    }

    private static int othetrLoop(int[] vol, int[] dp){
        dp[0] = vol[0];
        dp[1] = Math.max(vol[0], vol[1]);
        for(int i = 2; i<vol.length; i++){
            dp[i] = Math.max(dp[i-2]+vol[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }

}
