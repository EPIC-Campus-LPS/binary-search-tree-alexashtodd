import com.sun.source.tree.Tree;

public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void add(E value){
        if(root == null){
            root = new TreeNode<>(value, null, null);
        }else{
            TreeNode<E> temp = GreaterlessChoser(root, new TreeNode<>(value, null, null));
            while(!testForLeafNode()){
                temp = GreaterlessChoser(temp,new TreeNode<>(value, null, null));
            }
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

    boolean testForLeafNode(){
        TreeNode<E> temp = root;
        TreeNode<E> A = root.getLeftChild();
        TreeNode<E> B = root.getRightChild();
        if(A == null && B == null){
            return true;
        }else{
            return false;
        }
    }
    TreeNode<E> GreaterlessChoser(TreeNode<E> Ancor,TreeNode<E> Value){
        int root1 = Ancor.compareTo(Value);
        TreeNode<E> temp = null;
        if(root1<0){
             temp = root.getLeftChild();
        } else if (root1>0) {
             temp = root.getRightChild();
        }
        return temp;
    }


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
