public class BinarySearchTree {
    static Node PREV_NODE = null; // should be used exclusively for isBST function

    /**
     * some properties of Binary search tree are defined below:
     * 1. all the values of the left sub tree are leser
     * 2. all the values of the right sub tree are higher
     * 3. left and right sub tree are also BST
     * 4. There are no duplicate nodes
     * eg,
     *       9
     *      / \
     *     4  11
     *    / \   \
     *   2   7   15
     *           /
     *          14
     * 5. Inorder traversal of binary search tree gives an ascending sorted array
     * for above bst inorder traversal gives - [2, 4, 7, 9 11, 14, 15] which is an
     * sorted array in ascending order
     * 
     */

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    };

    static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    static void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    static void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    static boolean isBST(Node root) {
        if (root != null) {
            if (!isBST(root.left)) {
                return false;
            }
            if (BinarySearchTree.PREV_NODE != null && root.data <= BinarySearchTree.PREV_NODE.data) {
                return false;
            }
            BinarySearchTree.PREV_NODE = root;
            return isBST(root.right);
        } else {
            return true;
        }
    }

    static Node searchNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.data == key) {
            return root;
        }
        else if(root.data > key) {
            return searchNode(root.left, key);
        }
        else{
            return searchNode(root.right, key);
        }
    }

    static void insert(Node root, int key){
        Node prev = null;
        while(root!=null){
            prev = root;
            if(key==root.data){
                System.out.println("cannot insert key is already present in bst: "+ key);
                return;
            }
            else if(key<root.data){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
        Node newNode = new Node(key);
        if(key<prev.data){
            prev.left = newNode;
        }
        else{
            prev.right = newNode;
        }

    }
    public static void main(String[] args) {

        // Constructing the root node - Using Function (Recommended)
        Node p = new Node(5);
        Node p1 = new Node(3);
        Node p2 = new Node(6);
        Node p3 = new Node(1);
        Node p4 = new Node(4);
        // Finally The tree looks like this:
        // 5
        // / \
        // 3 6
        // / \
        // 1 4

        // Linking the root node with left and right children
        p.left = p1;
        p.right = p2;
        p1.left = p3;
        p1.right = p4;

        // preOrder(p);
        // printf("\n");
        // postOrder(p);
        // printf("\n");
        // if (isBST(p)) {
        //     Node result = BinarySearchTree.searchNode(p, 1);
        //     System.out.println(result == null ? "key not found" : result.data);
        // }


    }

}
