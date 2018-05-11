package DynamicProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class editDistance {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("edit.dat"));

        int tc = s.nextInt();
        s.nextLine();
        for(int i = 0; i<tc; i++){
            String[] exec = (" "+s.nextLine()).split("");
            String[] inte = (" "+s.nextLine()).split("");

            int[][] dp = new int[exec.length][inte.length];

            for (int y = 0; y<dp.length; y++){
                for (int x = 0; x<dp[0].length; x++){
                    if (y == 0) {
                        dp[y][x] = x;
                    }else if (x == 0){
                        dp[y][x] = y;
                    }else{
                        int choice1 = Math.min(dp[y-1][x], dp[y][x-1]);
                        int choice = Math.min(choice1, dp[y-1][x-1]);
                        dp[y][x] = choice;
                        if (!exec[y].equals(inte[x])){
                            dp[y][x]++;
                        }
                    }
                }
            }
            System.out.println(dp[exec.length-1][inte.length-1]);
        }
    }

}
