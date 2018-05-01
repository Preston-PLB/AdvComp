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
            for(int y = 1; y<=lines; y++){
                String[] vals = s.nextLine().split(" ");
            }
        }
    }

}

class PachinkoTree{

    int[][] tree;

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

    public int getLeftChild(int row, int index){
        return tree[row+1][index];
    }

    public int getRightChild(int row, int index){
        return tree[row+1][index+1];
    }

}