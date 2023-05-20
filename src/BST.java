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
    public void put(K key, V value){
        root = putNode(root, key, value);
    }
    private Node putNode(Node node, K key, V value) {
        if (node == null) {
            return new Node(key, value);
        }

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

    public V get(K key){
        Node node = getNode(root, key);
        return node != null ? node.value : null;
    }
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = comparator.compare(key, node.key);
        if (cmp < 0) {
            return getNode(node.left, key);
        } else if (cmp > 0) {
            return getNode(node.right, key);
        } else {
            return node;
        }
    }
    public void delete (K key){}
    private Node deleteNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        int cmp = comparator.compare(key, node.key);
        if (cmp < 0) {
            node.left = deleteNode(node.left, key);
        } else if (cmp > 0) {
            node.right = deleteNode(node.right, key);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                Node successor = findSuccessor(node.right);
                node.key = successor.key;
                node.value = successor.value;
                node.right = deleteNode(node.right, successor.key);
            }
        }
        return node;
    }
    private Node findSuccessor(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    public Iterable<K> iterator(){
        List<K> keys = new ArrayList<>();
        inorderTraversal(root, keys);
        return keys;
    }
    private void inorderTraversal(Node node, List<K> keys) {
        if (node != null) {
            inorderTraversal(node.left, keys);
            keys.add(node.key);
            inorderTraversal(node.right, keys);
        }
    }

}
