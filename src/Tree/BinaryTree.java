package Tree;

import LinkedLists.LinkedListStack;

import java.util.ArrayList;

public class BinaryTree {

    private Node root;
    private int size;
    private String out;
    private LinkedListStack tree;


    public BinaryTree(){
        root = new Node();
        size = 1;
    }

    public BinaryTree(double value){
        root = new Node(value);
        size = 1;
    }

    public Node root(){
        return root;
    }

    public void insert(double val){
        Node parent = findParent(val, root);
        if(val <= parent.value){
            if(parent.left == null){
                parent.left = new Node(val);
            }
        }else{
            if(parent.right == null){
                parent.right = new Node(val);
            }
        }
        size++;
    }

    private Node findParent(double val, Node node){
        if(val <= node.value && node.left == null){
            return node;
        }else if(val > node.value && node.right == null){
            return node;
        }else{
            if(val <= node.value){
                return findParent(val, node.left);
            }else{
                return findParent(val, node.right);
            }
        }
    }

    private void inOrderTraverse(Node node){
        if(node == null){
            return;
        }
        inOrderTraverse(node.left);
        out+=node.value+", ";
        inOrderTraverse(node.right);
    }

    public String prettyPrint(){
        StringBuilder sb = new StringBuilder();
        tree = new LinkedListStack();
        inOrderTPrint(root, 0);
        final String nl = "\n";
        while(tree.size() > 0){
            sb.append((String)tree.pop());
            sb.append(nl);
        }
        return sb.toString();
    }

    private void inOrderTPrint(Node node, int level){
        if(node == null) {
            return;
        }
        inOrderTPrint(node.left, level + 1);
        tree.push(spaces(level)+node.value);
        inOrderTPrint(node.right, level + 1);
    }

    private String spaces(int spaces){
        String s = "    ";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<spaces; i++){
            sb.append(s);
        }
        return sb.toString();
    }

    public String toString(){
        out = "";
        inOrderTraverse(root);
        return out;
    }

    //
    // NODE
    //

    private class Node{
        double value;
        Node left, right;

        public Node(){
            value = 0;
        }

        public Node(double value){
            this.value = value;
        }
    }
}
