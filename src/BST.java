import java.util.Comparator;
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

    public V get(K key){}
    public void delete (K key){}
    public Iterable<K> iterator(){}
}
