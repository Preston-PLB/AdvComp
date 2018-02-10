package Tree;

public class BinaryTree {

    private Node root;
    private int size;
    private String out;


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

    private void traverse(Node node){
        if(node == null){
            return;
        }
            out+=node.value+", ";
            traverse(node.left);
            traverse(node.right);
    }

    public String toString(){
        out = "";
        traverse(root);
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
