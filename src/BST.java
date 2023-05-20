import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BST <K, V>{
    private Node root;
    private Comparator<K> comparator;
    private class Node{
        private K key;
        private V value;
        private Node left, right;
        private Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    public BST(Comparator<K> comparator) {
        this.comparator = comparator;
    }
    public void put(K key, V value){//Inserts a key-value pair into the BST.
        root = putNode(root, key, value);
    }
    private Node putNode(Node node, K key, V value) {
        // If node is null, create a new node and return
        if (node == null) {
            return new Node(key, value);
        }
        // Compare the keys and traverse the BST accordingly
        int cmp = comparator.compare(key, node.key);
        if (cmp < 0) {
            node.left = putNode(node.left, key, value);
        } else if (cmp > 0) {
            node.right = putNode(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    public V get(K key){//Retrieves the value associated with a given key from the BST.
        Node node = getNode(root, key);
        return node != null ? node.value : null;
    }
    private Node getNode(Node node, K key) {
        // If node is null or key matches, return the node
        if (node == null) {
            return null;
        }

        int cmp = comparator.compare(key, node.key);
        if (cmp < 0) { // Compare the keys and traverse the BST accordingly
            return getNode(node.left, key);
        } else if (cmp > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }
    public void delete (K key){//Deletes a node with the given key from the BST.
        root = deleteNode(root, key);
    }
    private Node deleteNode(Node node, K key) {
        // If node is null, return null
        if (node == null) {
            return null;
        }
        // Compare the keys and traverse the BST accordingly
        int cmp = comparator.compare(key, node.key);
        if (cmp < 0) {
            node.left = deleteNode(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteNode(node.right, key);
        } else {
            // Node found, perform deletion based on different cases

            // Case 1: Node has no left child
            if (node.left == null) {
                return node.right;
            }
            // Case 2: Node has no right child
            else if (node.right == null) {
                return node.left;
            }
            // Case 3: Node has both left and right children
            else {
                // Find the successor node (smallest key in the right subtree)
                Node successor = findSuccessor(node.right);
                node.key = successor.key;
                node.value = successor.value;
                node.right = deleteNode(node.right, successor.key);
            }
        }
        return node;
    }
    private Node findSuccessor(Node node) {//Finds the successor node of a given node in the BST.
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public Iterable<K> iterator(){//Returns an iterable of keys in ascending order from the BST.
        List<K> keys = new ArrayList<>();
        inorderTraversal(root, keys);
        return keys;
    }
    private void inorderTraversal(Node node, List<K> keys) {//Performs an inorder traversal of the BST and adds keys to the list in ascending order.
        if (node != null) {
            inorderTraversal(node.left, keys);
            keys.add(node.key);
            inorderTraversal(node.right, keys);
        }
    }

}
class IntegerComparator implements Comparator<Integer> {//A custom comparator for comparing Integer keys in the BST.
    @Override
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}
