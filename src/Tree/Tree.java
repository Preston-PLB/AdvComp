package Tree;

import java.util.HashMap;

public class Tree {

    private int index, farLeft, farRight;
    private int[] weights;
    private HashMap<Integer, Integer> columns;

    public Tree(int[] weights){
        this.weights = weights;
        index = 0;
        columns = new HashMap<>();
        farLeft = Integer.MAX_VALUE;
        farRight = Integer.MIN_VALUE;
    }

    public void fill(){
        Node root = new Node(0, weights[0]);
        visit(root);
    }

    private void visit(Node node) {
        int temp = 0;
        if(columns.containsKey(node.pos)){
            temp = columns.get(node.pos);
        }
        columns.put(node.pos, temp + weights[index]);
        leftNode(node);
        rightNode(node);
    }

    private void rightNode(Node node) {
        index++;
        if(weights[index] == -1){
            return;
        }
        farRight = farRight < node.pos+1 ? node.pos+1 : farRight;
        node.right = new Node(node.pos+1, weights[index]);
        visit(node.right);
    }

    private void leftNode(Node node) {
        index++;
        if(weights[index] == -1){
            return;
        }
        farLeft = farLeft > node.pos-1 ? node.pos-1 : farLeft;
        node.left = new Node(node.pos-1, weights[index]);
        visit(node.left);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = farLeft; i<=farRight; i++){
            if(columns.get(i) != null){
                sb.append(columns.get(i));
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    private class Node{
        int pos;
        int value;
        Node left, right;

        public Node(int pos, int value){
            this.pos = pos;
            this.value = value;

            left = right = null;
        }
    }
}

