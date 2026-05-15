public class Main {
    public static void main(String[] args) {
        System.out.println("--- Testing Binary Search Tree ---\n");

        // 1. Create a BST that stores Integers
        BST<Integer> tree = new BST<>();

        // Test empty tree states
        System.out.println("Empty Tree Verification:");
        System.out.println("Initial Height (expected -1): " + tree.getHeight());
        System.out.println("Initial Node Count (expected 0): " + tree.countNodes(tree.getRoot()));
        System.out.println();

        // 2. Add structural values
        //          10
        //         /  \
        //        5    15
        //       / \     \
        //      3   7     18
        System.out.println("Inserting elements: 10, 5, 15, 3, 7, 18");
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(3);
        tree.add(7);
        tree.add(18);
        System.out.println();

        // 3. Test Structural Information
        System.out.println("Tree Properties:");
        System.out.println("Tree Height (expected 2): " + tree.getHeight());
        System.out.println("Total Nodes (expected 6): " + tree.countNodes(tree.getRoot()));
        System.out.println("Leaf Nodes (expected 3: [3, 7, 18]): " + tree.countLeafNodes(tree.getRoot()));
        System.out.println();

        // 4. Test Traversal/Printing Output
        System.out.println("Traversals Output:");
        System.out.print("Inorder Traversal (expected: 3 5 7 10 15 18): ");
        tree.printInorder();

        System.out.print("Preorder Traversal (expected: 10 5 3 7 15 18): ");
        tree.printPreorder();

        System.out.print("Postorder Traversal (expected: 3 7 5 18 15 10): ");
        tree.printPostorder();
        System.out.println();

        // 5. Test Search Functionality (contains)
        System.out.println("Search Checks:");
        System.out.println("Contains 7? (expected true): " + tree.contains(7));
        System.out.println("Contains 15? (expected true): " + tree.contains(15));
        System.out.println("Contains 100? (expected false): " + tree.contains(100));
        System.out.println();

        // 6. Test Edge Cases
        System.out.println("Duplicate Insertion Check:");
        System.out.println("Adding existing value 5 again...");
        tree.add(5);
        System.out.println("Total Nodes after duplicate attempt (expected 6): " + tree.countNodes(tree.getRoot()));

        System.out.println("\nDelete Tests:");

// Delete leaf node
        tree.delete(3);
        System.out.print("After deleting leaf node 3: ");
        tree.printInorder();

// Delete node with one child
        tree.delete(15);
        System.out.print("After deleting node 15 (one child): ");
        tree.printInorder();

// Delete node with two children
        tree.delete(5);
        System.out.print("After deleting node 5 (two children): ");
        tree.printInorder();
    }}

