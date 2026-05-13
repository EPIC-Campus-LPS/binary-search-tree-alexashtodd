/**
 * Binary Search Tree implementation.
 * Stores elements in sorted order using TreeNodes.
 *
 * @param <E> the type of data stored in the tree
 */
public class BST<E extends Comparable<E>> {

    /**
     * The root node of the BST
     */
    private TreeNode<E> root;

    /**
     * Adds a value into the binary search tree.
     * Smaller values go left, larger values go right.
     *
     * @param value the value to add
     */
    public void add(E value) {

        // Create the new node that will be inserted
        TreeNode<E> newNode = new TreeNode<>(value, null, null);

        // If tree is empty, new node becomes root
        if (root == null) {
            root = newNode;
        } else if (root.getLeftChild() == null || root.getRightChild() == null) {
            if (root.compareTo(newNode) < 0) {
                root.setRightChild(newNode);
            } else if (root.compareTo(newNode) > 0) {
                root.setLeftChild(newNode);
            } else {
                root.setLeftChild(newNode);
            }
        }else {

        // Start traversal from the root
            TreeNode<E> temp = GreaterlessChoserORequal(root, newNode);

            // Continue moving through tree until a leaf node is found
            while (!testForLeafNode()) {
                temp = GreaterlessChoserORequal(temp, newNode);
            }

            // Decide whether to place node on left or right
            if (GreaterOrLessForNew(temp, newNode).equals("right")) {
                temp.setLeftChild(newNode);
            } else {
                temp.setRightChild(newNode);
            }
        }
    }

    /**
     * Checks whether a value exists inside the tree.
     *
     * @param value the value to search for
     * @return true if found, false otherwise
     */
    boolean contains(E value) {
        return containsHelper(root, value);
    }

    /**
     * Counts all nodes in the tree recursively.
     *
     * @param node current node being checked
     * @return total number of nodes
     */
    int countNodes(TreeNode<E> node) {

        // Base case: empty node
        if (node == null) return 0;

        // Count current node + left subtree + right subtree
        return 1 + countNodes(node.getLeftChild()) +
                countNodes(node.getRightChild());

    }

    /**
     * Counts the number of leaf nodes in the tree.
     * A leaf node has no children.
     *
     * @param node current node being checked
     * @return number of leaf nodes
     */
    int countLeafNodes(TreeNode<E> node) {

        // Base case: empty node
        if (node == null) return 0;

        // If node has no children, it is a leaf
        if (node.getLeftChild() == null &&
                node.getRightChild() == null) return 1;

        // Count leaves in left and right subtrees
        return countLeafNodes(node.getLeftChild()) +
                countLeafNodes(node.getRightChild());

    }


    /**
     * Returns the height of the tree.
     *
     * @return height of the BST
     */
    int getHeight() {
        return calculateHeightRecution(root);
    }

    /**
     * Prints the tree using inorder traversal.
     * Left -> Root -> Right
     */
    void printInorder() {
    }

    /**
     * Prints the tree using preorder traversal.
     * Root -> Left -> Right
     */
    void printPreorder() {
    }

    /**
     * Prints the tree using postorder traversal.
     * Left -> Right -> Root
     */
    void printPostorder() {
    }

    /**
     * Deletes a value from the BST.
     *
     * @param value value to delete
     * @return deleted value
     */
    E delete(E value) {
        return value;
    }

    /**
     * Tests whether the root node is a leaf node.
     *
     * @return true if root has no children
     */
    boolean testForLeafNode() {

        // Temporary references to child nodes
        TreeNode<E> temp = root;
        TreeNode<E> A = root.getLeftChild();
        TreeNode<E> B = root.getRightChild();

        // Root is leaf if both children are null
        if (A == null && B == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Chooses whether traversal should continue
     * left or right based on node comparison.
     *
     * @param Ancor current node
     * @param Value node being inserted
     * @return next node to visit
     */
    TreeNode<E> GreaterlessChoserORequal(TreeNode<E> Ancor, TreeNode<E> Value) {

        // Compare current node to inserted value
        int root1 = Ancor.compareTo(Value);

        TreeNode<E> temp = null;

        // Move left if smaller
        if (root1 < 0) {
            temp = root.getLeftChild();

            // Move right if larger
        } else if (root1 > 0) {
            temp = root.getRightChild();

            // Equal values also go left
        } else {
            temp = root.getLeftChild();
        }

        return temp;
    }

    /**
     * Determines whether the generic value
     * is an Integer or String.
     *
     * @param value value being checked
     * @return type as String
     */
    String IntOrString(E value) {

        if (value instanceof Integer) {
            return "Int";
        }

        if (value instanceof String) {
            return "String";
        }

        return "null";
    }

    /**
     * Determines whether a new node should
     * go left or right of the current node.
     *
     * @param Ancor current node
     * @param Value node being inserted
     * @return "left" or "right"
     */
    String GreaterOrLessForNew(TreeNode<E> Ancor, TreeNode<E> Value) {

        // Compare current node with inserted node
        int root1 = Ancor.compareTo(Value);

        String temp = "";

        // Smaller values go left
        if (root1 < 0) {
            temp = "left";

            // Larger values go right
        } else if (root1 > 0) {
            temp = "right";
        }

        return temp;
    }

    /**
     * Recursive helper method for contains().
     *
     * @param node  current node being checked
     * @param value value being searched for
     * @return true if value exists
     */
    private boolean containsHelper(TreeNode<E> node, E value) {

        // Base case: value not found
        if (node == null) return false;

        // Compare search value to current node value
        int cmp = value.compareTo(node.getValue());

        // Value found
        if (cmp == 0) return true;

        // Search left subtree if smaller,
        // otherwise search right subtree
        return cmp < 0 ?
                containsHelper(node.getLeftChild(), value) :
                containsHelper(node.getRightChild(), value);
    }

    private int calculateHeightRecution(TreeNode<E> node) {
        if (node == null) {
            return -1;
        }

        int left = calculateHeightRecution(node.getLeftChild());
        int right = calculateHeightRecution(node.getRightChild());

        if (left != 0) {
            return 1 + left;
        } else if (right != 0) {
            return 1 + right;
        }
        return 0;
    }
}

