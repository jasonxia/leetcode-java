class BSTNode {
    int data;
    BSTNode left;
    BSTNode right;

    public BSTNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinarySearchTree {
    BSTNode root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int data) {
        BSTNode node = new BSTNode(data);
        if (root == null) {
            root = node;
            return;
        }
        BSTNode current = root;
        BSTNode parent = null;

        while(current != null) {
            parent = current;
            if (data < current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if(data < parent.data) {
            parent.left = node;
        } else {
            parent.right = node;
        }
    }

    public boolean find(int data) {
        BSTNode current = root;
        while(current !=null ) {
            if(current.data == data) {
                return true;
            } else if (current.data > data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public boolean delete(int data) {
        if (find(data)) {
            root = deleteNode(root, data);
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        displayTree(root);
    }

    private void displayTree(BSTNode node) {
        if (node == null) return;

        displayTree(node.left);
        System.out.println(" " + node.data);
        displayTree(node.right);
    }

    private BSTNode findMinimumNode(BSTNode root) {
        if(root.left == null) {
            return root;
        } else {
            return findMinimumNode(root.left);
        }
    }

    private BSTNode deleteNode(BSTNode root, int data) {
        if(root == null) {
            return null;
        }

        if(root.data == data) {
            if (root.left != null && root.right != null) { // if nodeToBeDeleted have both children
                BSTNode temp = root;
                // Finding minimum element from right
                BSTNode minNodeForRight = findMinimumNode(temp.right);
                // Replacing current node with minimum node from right subtree
                root.data = minNodeForRight.data;
                // Deleting minimum node from right now
                root.right = deleteNode(root.right, minNodeForRight.data);

            } else if (root.left != null) { // if nodeToBeDeleted has only left child
                root = root.left;
            } else if (root.right != null) { // if nodeToBeDeleted has only right child
                root = root.right;
            } else { // if nodeToBeDeleted do not have child (Leaf node)
                root = null;
            }
            return root;
        }

        if(root.data > data)  {
            root.left = deleteNode(root.left, data);
        } else if(root.data < data) {
            root.right = deleteNode(root.right, data);
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(40);
        bst.insert(20);
        bst.insert(60);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);
        bst.insert(50);
        bst.insert(55);
        bst.insert(70);
        bst.display();
        System.out.println("==========");
        bst.delete(40);
        bst.display();
        System.out.println("==========");
        bst.delete(50);
        bst.display();
        System.out.println("==========");
        bst.delete(60);
        bst.display();
        System.out.println("==========");
        bst.delete(55);
        bst.display();

    }
}
