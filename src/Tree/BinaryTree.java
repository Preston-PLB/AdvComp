package Tree;

public class BinaryTree {

    Node root;
    int size;

    public BinaryTree(){
        Node root = new Node();
        size = 1;
    }

    public BinaryTree(double value){
        Node root = new Node(value);
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
    }

    private Node findParent(double val, Node node){
        if(val <= node.value && node.left == null){
            return node;
        }else if(val > node.value && node.right == null){
            return node;
        }else{
            if(val <= node.value){
                findParent(val, node.left);
            }else{
                findParent(val, node.right);
            }
        }
        return new Node();
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
