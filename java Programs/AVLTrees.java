public class AVLTrees {
    /**
     * 
     * balance factor(bf) = height of left subtree(hl) - height of right subtree(hr)
     * bf = hl-hr {-1, 0, 1} ---> AVL Trees criteria height balancing tree
     * in other words for AVL trees, |bf| = |hl-hr| <= 1 
     * 
     * 
     * Rotations are performed in order to balance a tree
     * 
     * 
     * 
     * Rotation concepts in AVL trees in order to maintain the tree nature of the BST
     * This ensures the operations done on the BST are skewed towards O(logn) complexities
     * 
     *                                      y
     *                                     / \ 
     *                                    x   T3
     *                                   / \
     *                                  T1  T2
     *                                     ⇑
     *         left rotation of below tree ‖ Right rotation of above tree
     *                                     ⇓  
     *                                      x 
     *                                     / \
     *                                    T1  y
     *                                       / \
     *                                      T2  T3
     * 
     *@srcImage (https://api.codewithharry.com/media/videoSeriesFiles/courseFiles/data-structures-and-algorithms-in-hindi-82/Image_1.jpg)
     *  
     * 
     * 
     */

    static public class Node {
        int key;
        Node left;
        Node right;
        int height;

        public Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

        @Override
        public String toString() {
            return "Node [key=" + key + ", left=" + left + ", right=" + right + "]";
        }

        
    }

    // static int getHeight(Node n) {
    //     if (n == null)
    //         return 0;
    //     return n.height;
    // }

    static int nodeHeight(Node n) {
        int hl, hr;
        hl = ((n != null) && (n.left != null))? n.left.height : 0;
        hr = ((n != null) && (n.right != null))? n.right.height : 0;

        return hl>hr?hl+1:hr+1;
    }

    static int getBalanceFactor(Node n) {
        int hl, hr;
        hl = ((n != null) && (n.left != null))? n.left.height : 0;
        hr = ((n != null) && (n.right != null))? n.right.height : 0;

        return hl-hr;
    }

    static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;
        

        y.height = nodeHeight(y);
        x.height = nodeHeight(x);

        return x;
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        y.height = nodeHeight(y);
        x.height = nodeHeight(x);

        return y;
    }

    static Node insert(Node node, int key) {
        if (node == null)
            return new Node(key);
        
        if(key < node.key) {
            node.left = insert(node.left, key);
        }
        else if(key > node.key) {
            node.right = insert(node.right, key);
        }

        node.height = nodeHeight(node);
        int bf = getBalanceFactor(node);

        // left left imbalance case
        if(bf>1 && key<node.left.key) {
            return rightRotate(node);
        }
        // right right imbalance case
        if(bf<-1 && key>node.right.key) {
            return leftRotate(node);
        }
        // left right imbalance case
        if(bf>1 && key>node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // right left imbalance case
        if(bf<-1 && key<node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    public static void main(String[] args) {
        Node root = new Node(45);
        root = insert(root, 44);
        root = insert(root, 40);
        root = insert(root, 20);
        root = insert(root, 19);
        root = insert(root, 15);
        root = insert(root, 4);
        System.out.println(root);
    }







}