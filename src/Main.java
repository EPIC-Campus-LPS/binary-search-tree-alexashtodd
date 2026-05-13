public class Main {
    public static void main(String[] args){
        System.out.println("Hello world!");
        // Create a BST that stores Integers
        BST<Integer> tree = new BST<>();

        // Add some values
        tree.add(10);
        tree.add(5);
        tree.add(15);

        // Call getHeight()
        System.out.println(tree.getHeight());


    }
}