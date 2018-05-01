package DynamicProgramming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CasinoRoyal {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("house.dat"));

        int tc = s.nextInt();
        for(int x = 0; x<tc; x++){
            int lines = s.nextInt();
            s.nextLine();
            PachinkoTree pt = new PachinkoTree(lines);
            for(int y = 1; y<=lines; y++){
                String[] vals = s.nextLine().trim().split(" ");
                for(String str: vals){
                    pt.insert(Integer.parseInt(str));
                }
            }

            System.out.println(getPath(pt));

        }
    }

    public static int getPath(PachinkoTree pt){
        int[][] dp = new int[pt.getDepth()][pt.getDepth()];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return recursive(pt, 0,0, dp);
        //return dynamic(pt, dp);
    }

    private static int recursive(PachinkoTree pt, int row, int index, int[][] dp){
        if(pt.isLeaf(row)){
            dp[row][index] = pt.getValue(row,index);
            return dp[row][index];
        }else{
            if(dp[row][index] == -1){
                int val = pt.getValue(row, index);
                dp[row][index] = Math.max(recursive(pt, row+1, index, dp), recursive(pt, row+1, index+1, dp))+val;
            }
            return dp[row][index];
        }
    }

    private static int dynamic(PachinkoTree pt, int[][] dp){
        for(int i = 0; i<dp.length; i++){
            dp[dp.length-1][i] = pt.getValue(dp.length-1, i);
        }
        for(int y = dp.length-2; y > -1; y--){
            for(int x = 0; x < y+1; x++){
                int val = pt.getValue(y, x);
                dp[y][x] = Math.max(dp[y+1][x], dp[y+1][x+1])+val;
            }
        }
        return dp[0][0];
    }

}

class PachinkoTree{

    private int[][] tree;

    public PachinkoTree(int depth){
        tree = new int[depth][depth];

        for(int i = 0; i<tree.length; i++){
            Arrays.fill(tree[i], -1);
        }
    }

    public void insert(int value){
        int k = 1;
        outer:
        for(int y = 0; y<tree.length; y++){
            for(int x = 0; x<k; x++){
                if(tree[y][x] == -1){
                    tree[y][x] = value;
                    break outer;
                }
            }
            k++;
        }
    }

    public int getValue(int row, int index){
        if(row > tree.length || index > tree.length){
            return -1;
        }
        return tree[row][index];
    }

    public int getDepth(){
        return tree.length;
    }

    public boolean isLeaf(int row){
        return row >= tree.length-1;
    }

}