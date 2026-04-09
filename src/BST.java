import com.sun.source.tree.Tree;

public class BST<E extends Comparable<E>> {
    private TreeNode<E> root;

    public void add(E value){
        TreeNode<E> newNode = new TreeNode<>(value, null, null);
        if(root == null){
            root = newNode;
        }else{
            TreeNode<E> temp = GreaterlessChoserORequal(root, newNode);
            while(!testForLeafNode()){
                temp = GreaterlessChoserORequal(temp,newNode);
            }
            if(GreaterOrLessForNew(temp,newNode).equals("right")){
                temp.setLeftChild(newNode);
            }else{
                temp.setRightChild(newNode);
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

    TreeNode<E> GreaterlessChoserORequal(TreeNode<E> Ancor,TreeNode<E> Value){
        int root1 = Ancor.compareTo(Value);
        TreeNode<E> temp = null;
        if(root1<0){
             temp = root.getLeftChild();
        } else if (root1>0) {
             temp = root.getRightChild();
        } else{
            temp = root.getLeftChild();
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

    String GreaterOrLessForNew(TreeNode<E> Ancor,TreeNode<E> Value){
        int root1 = Ancor.compareTo(Value);
        String temp = "";
        if(root1<0){
            temp = "left";
        } else if (root1>0) {
            temp = "right";
        }
        return temp;
    }
}
