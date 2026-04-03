

public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void add(E value){
        if(root == null){
            root = new TreeNode<>(value, null, null);
        }else{
            if()
        }

    }
    boolean contains(E value){

    }
    int countNodes(){}
    int countLeafNodes(){}
    int getHeight(){}
    void printInorder(){}
    void printPreorder(){}
    void printPostorder(){}
    E delete(E value){}


    String IntOrString(E value){
        if (value instanceof Integer){
            return "Int";
        }
        if (value instanceof String){
            return "String";
        }
        return "null";
    }
}
