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
        int[][] dp = new int[pairs][cap];
        for(int[] array: dp){
            Arrays.fill(array, -1);
        }
        return recursive(cap, pairs, space, cost, dp, pairs-1, cap-1);
    }

    private static int recursive(int cap, int pairs, int[] space, int[] cost, int[][] dp, int row, int column) {


    }

    private static void printArray(int[][] array){
        for(int[] a: array){
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
    }

}
