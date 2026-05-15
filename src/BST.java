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

        TreeNode<E> newNode = new TreeNode<>(value, null, null);

        // Empty tree
        if (root == null) {
            root = newNode;
            return;
        }

        TreeNode<E> current = root;

        while (true) {

            int cmp = value.compareTo(current.getValue());

            // Go left
            if (cmp < 0) {

                if (current.getLeftChild() == null) {
                    current.setLeftChild(newNode);
                    return;
                }

                current = current.getLeftChild();
            }

            // Go right
            else if (cmp > 0) {

                if (current.getRightChild() == null) {
                    current.setRightChild(newNode);
                    return;
                }

                current = current.getRightChild();
            }

            // Duplicate value → do nothing
            else {
                return;
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
        printInorder(root);
        System.out.println();
    }

    private void printInorder(TreeNode<E> node) {

        if (node == null) {
            return;
        }

        printInorder(node.getLeftChild());

        System.out.print(node.getValue() + " ");

        printInorder(node.getRightChild());
    }

    /**
     * Prints the tree using preorder traversal.
     * Root -> Left -> Right
     */
    void printPreorder() {
        printPreorder(root);
        System.out.println();
    }

    private void printPreorder(TreeNode<E> node) {

        if (node == null) {
            return;
        }

        System.out.print(node.getValue() + " ");

        printPreorder(node.getLeftChild());

        printPreorder(node.getRightChild());
    }

    /**
     * Prints the tree using postorder traversal.
     * Left -> Right -> Root
     */
    void printPostorder() {
        printPostorder(root);
        System.out.println();
    }

    private void printPostorder(TreeNode<E> node) {

        if (node == null) {
            return;
        }

        printPostorder(node.getLeftChild());

        printPostorder(node.getRightChild());

        System.out.print(node.getValue() + " ");
    }

    /**
     * Deletes a value from the BST.
     *
     * @param value value to delete
     * @return deleted value
     */
    /**
     * Deletes a value from the BST.
     *
     * @param value value to delete
     * @return deleted value if found, otherwise null
     */
    E delete(E value) {

        TreeNode<E> current = root;
        TreeNode<E> parent = null;

        // Find node to delete
        while (current != null &&
                !current.getValue().equals(value)) {

            parent = current;

            if (value.compareTo(current.getValue()) < 0) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
        }

        // Value not found
        if (current == null) {
            return null;
        }

        E deletedValue = current.getValue();

        // =========================
        // CASE 1: LEAF NODE
        // =========================
        if (current.getLeftChild() == null &&
                current.getRightChild() == null) {

            // deleting root
            if (current == root) {
                root = null;
            }

            // remove left reference
            else if (parent.getLeftChild() == current) {
                parent.setLeftChild(null);
            }

            // remove right reference
            else {
                parent.setRightChild(null);
            }
        }

        // =========================
        // CASE 2: ONE CHILD
        // =========================
        else if (current.getLeftChild() == null ||
                current.getRightChild() == null) {

            TreeNode<E> child;

            // choose existing child
            if (current.getLeftChild() != null) {
                child = current.getLeftChild();
            } else {
                child = current.getRightChild();
            }

            // deleting root
            if (current == root) {
                root = child;
            }

            // replace parent's left
            else if (parent.getLeftChild() == current) {
                parent.setLeftChild(child);
            }

            // replace parent's right
            else {
                parent.setRightChild(child);
            }
        }

        // =========================
        // CASE 3: TWO CHILDREN
        // =========================
        else {

            TreeNode<E> leftSubtree = current.getLeftChild();
            TreeNode<E> rightSubtree = current.getRightChild();

            // Replace node with left subtree
            if (current == root) {
                root = leftSubtree;
            }
            else if (parent.getLeftChild() == current) {
                parent.setLeftChild(leftSubtree);
            }
            else {
                parent.setRightChild(leftSubtree);
            }

            // Reinsert right subtree
            reinsertSubtree(rightSubtree);
        }

        return deletedValue;
    }

    /**
     * Reinserts an entire subtree back into the BST.
     *
     * @param node subtree root
     */
    private void reinsertSubtree(TreeNode<E> node) {

        if (node == null) {
            return;
        }

        add(node.getValue());

        reinsertSubtree(node.getLeftChild());

        reinsertSubtree(node.getRightChild());
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

    /**
     * Calculates the height of a node in a binary tree using recursion.
     * The height is defined as the number of edges on the longest path from the node to a leaf.
     *
     * @param node The current tree node being evaluated.
     * @return The height of the node, where a leaf node has a height of 0, and a null node returns -1.
     */
    private int calculateHeightRecution(TreeNode<E> node) {
        // Base case: An empty node has a height of -1 to correctly offset the +1 added by its parent
        if (node == null) {
            return -1;
        }

        // Recursively find the maximum height of the left subtree
        int left = calculateHeightRecution(node.getLeftChild());

        // Recursively find the maximum height of the right subtree
        int right = calculateHeightRecution(node.getRightChild());

        // Take the longer path between left and right subtrees, then add 1 for the current node's edge
        return 1 + Math.max(left, right);
    }
    /**
     * Returns the root node of the tree.
     *
     * @return root node
     */
    public TreeNode<E> getRoot() {
        return root;
    }

    /**
     * Counts the number of leaf nodes in the tree.
     *
     * @param node current node
     * @return number of leaf nodes
     */
    int countLeafNodes(TreeNode<E> node) {

        if (node == null) {
            return 0;
        }

        // Leaf node
        if (node.getLeftChild() == null &&
                node.getRightChild() == null) {
            return 1;
        }

        return countLeafNodes(node.getLeftChild()) +
                countLeafNodes(node.getRightChild());
    }
}

