package DynamicProgramming;

import java.io.File;
import java.io.FileNotFoundException;
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

    Node root;

    public PachinkoTree(String value){
        insert(value, root);
    }

    public void insert(String value, Node n){
        if(n == null) {
            n = new Node(value);
        }else{
            insert(value, n.left);
            insert(value, n.right);
        }
    }



    private class Node{
        int value;
        Node left, right;

        public Node(String value){
            this.value = Integer.parseInt(value);
        }

    }

}