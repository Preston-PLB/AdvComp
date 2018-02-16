package Compressor;

import LinkedLists.LinkedListStack;

public class BinarySearchTree {


    private Node root;
    private int size;
    private LinkedListStack tree;


    public BinarySearchTree(){
        root = new Node();
        size = 1;
    }

    public BinarySearchTree(CodeChar cc){
        root = new Node(cc);
        size = 1;
    }

    public Node root(){
        return root;
    }

    public void insert(Compressor.CodeChar cc){
        Node parent = findParent(cc, root);
        if(cc.getFreq() <= parent.value.getFreq()){
            if(parent.left == null){
                parent.left = new Node(cc);
            }
        }else{
            if(parent.right == null){
                parent.right = new Node(cc);
            }
        }
        size++;
    }

    private Node findParent(Compressor.CodeChar cc, Node node){
        if(cc.getFreq() <= node.value.getFreq() && node.left == null){
            return node;
        }else if(cc.getFreq() > node.value.getFreq() && node.right == null){
            return node;
        }else{
            if(cc.getFreq() <= node.value.getFreq()){
                return findParent(cc, node.left);
            }else{
                return findParent(cc, node.right);
            }
        }
    }

    private int getSize(){
        return size;
    }

    private String prettyPrint(){
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
        return prettyPrint();
    }

    //
    // NODE
    //

    private class Node{
        CodeChar value;
        Node left, right;

        public Node(){
            value = new CodeChar();
        }

        public Node(CodeChar value){
            this.value = value;
        }
    }

}
