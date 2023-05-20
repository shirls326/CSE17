import java.util.Comparator;
import java.util.ArrayList;

public class TreeMap<K, V extends Comparable<K>> {

    private TreeNode root;
    private int size;
    private Comparator<K> comp; // order the trees based on keys
    public static int iterations;

    private class TreeNode {

        HashMapEntry<K, V> value;
        // data member: reference to the left child node
        TreeNode left;
        // data member: reference to the right child node
        TreeNode right;

        /**
         * Constructor to initialize the value of the tree node
         * sets the left and right child to null
         */
        TreeNode(K key, V val) {
            value = new HashMapEntry<>(key, val);
            left = right = null;
        }
    }

    /**
     * Default constructor to create an empty BST
     * Time complexity: O(1)
     */

    TreeMap(Comparator<K> c) {
        comp = c;
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public boolean containsKey(K key) {
        // Returns the value of the map
        // entry with key if it is found, null otherwise
        TreeNode node = root;

        while (node != null) {
            if (comp.compare(key, node.value.getKey()) < 0) {
                node = node.left;

            } else if(comp.compare(key, node.value.getKey()) > 0){
                node = node.right;
            }
            else return true;
        }
        return false;

    }

    
    /***
     * Get method
     * @param key
     * @return the value of the map entry with key if it is found, null otherwise
     * 
     */
    public V get(K key) {
        iterations = 0;

        TreeNode node = root;

        while (node != null) {
            iterations++;
            if (comp.compare(key, node.value.getKey()) < 0) {
                node = node.left;

            } else if(comp.compare(key, node.value.getKey()) > 0){
                node = node.right;
            }
            else return node.value.getValue();
        }

        return null;

    }

    /***
     * Add method for TreeMap
     * @param key
     * @param value
     * @return whether the new node was added or not
     * Add a new node to the tree with its value equal to (key, val). If key exists in the tree, change its value to val
     */
    public boolean add(K key, V value) {

        if (root == null) // the first node to be inserted
            root = new TreeNode(key,value);
        else {
            TreeNode parent, node;
            parent = null;
            node = root;
            while (node != null) { // Looking for a leaf node
                parent = node;
                if (comp.compare(key, node.value.getKey()) < 0) {
                    node = node.left;
                } else if (comp.compare(key, node.value.getKey()) > 0) {
                    node = node.right;
                } else
                    return false; // duplicates are not allowed
            }
            if (comp.compare(key, parent.value.getKey()) < 0)
                parent.left = new TreeNode(key,value);
            else
                parent.right = new TreeNode(key,value);
        }
        size++;
        return true;

    }

    public boolean remove(K key) {


        TreeNode parent, node;
        parent = null; node = root;
        // Find value first
        while (node != null) {
            if (comp.compare(key, node.value.getKey()) < 0) {
                parent = node;
                node = node.left;// go left
            }
            else if (comp.compare(key, node.value.getKey()) > 0) {
                parent = node;
                node = node.right;//go right
            }
            else
                break; // value found
        }
        if (node == null) // value not in the tree
            return false;
        // Case 1: node has no children
        if(node.left == null && node.right == null){
            if(parent == null) // delete root
                root = null;
            else
                changeChild(parent, node, null);
        }
        else if(node.left == null){ 
            //case 2: node has one right child
            if (parent == null) // delete root
                root = node.right;
            else
                changeChild(parent, node, node.right);
        }
        else if(node.right == null){ 
            //case 2: node has one left child
            if (parent == null) // delete root
                root = node.left;
            else
                changeChild(parent, node, node.left);
        } 
        else { 
            // case 3: node has two children
            TreeNode rightMostParent = node;
            TreeNode rightMost = node.left;
            // go right on the left subtree
            while (rightMost.right != null) {
                rightMostParent = rightMost;
                rightMost = rightMost.right;
            }
            // copy the value of rigthMost to node
            node.value = rightMost.value;
            //delete rigthMost
            changeChild(rightMostParent,rightMost,
                        rightMost.left);
        }
        size--;
        return true;

        
    }

     /** 
        Helper method to change the links between the nodes
        @param parent has node as a child
        @param node to be removed
        @param newChild will replace node as the child of parent
        Time complexity: O(1)
    */
    private void changeChild(TreeNode parent,
                             TreeNode node, 
                             TreeNode newChild){
        if(parent.left == node)
            parent.left = newChild;
        else
            parent.right = newChild;
    }

    /**
        Method to traverse the BST using inorder traversal
        Time complexity: O(n)
    */
    public void inorder() {
        inorder(root);

    }

    /**
        Recursive Helper Method to traverse the BST starting from node
        @param node root of the subtree being traversed
        Time complexity: O(n)
    */
    private void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.value + " ");
            inorder(node.right);
        }
    }

    /**
        Method to traverse the BST using preorder traversal
        Time complexity: O(n)
    */
    public void preorder() {
        preorder(root);

    }

    /**
        Recursive Helper Method to traverse the BST starting from node
        @param node root of the subtree being traversed
        Time complexity: O(n)
    */
    private void preorder(TreeNode node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }


    /**
        Method to traverse the BST using postorder traversal
        Time complexity: O(n)
    */
    public void postorder() {
        postorder(root);
    }

        /**
        Recursive Helper Method to traverse the BST starting from node
        @param node root of the subtree being traversed
        Time complexity: O(n)
    */
    private void postorder(TreeNode node)  {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.value + " "); 
        }
    }

    /***
     * Recursive method that returns an array list of the tree nodes sorted by key 
     * (Hint: note that the method inorder() prints the nodes sorted by key)
     * Add the time complexity of the method as a comment before the method header
     * @return
     */
    public ArrayList<HashMapEntry<K, V>> sortedKeys() {
        iterations = 0;
        ArrayList<HashMapEntry<K,V>> keys = new ArrayList<>();
        inorder(root, keys);
        return keys;

    }


    /***
     * Recursive Helper Method to traverse the BST starting from node
        @param node root of the subtree being traversed
        @param keys
        Time complexity: O(n)
     */
    private void inorder(TreeNode node, ArrayList<HashMapEntry<K,V>> keys){
        iterations++;
        if (node == null) {
            return;
        }
        inorder(node.left, keys);
        keys.add(node.value);
        inorder(node.right, keys);


    }


}