package Tree;

public class PrettyPrint {

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        double[] da = {5,2,6,1,3,9};
        for(int i = 0; i<da.length; i++){
            if(i == 0){
                tree = new BinaryTree(da[0]);
            }else{
            tree.insert(da[i]);
            }
        }
        System.out.println(tree.prettyPrint());
        System.out.println(tree+" ");
    }

}
