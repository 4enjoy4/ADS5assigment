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
    }

    public V get(K key){}
    public void delete (K key){}
    public Iterable<K> iterator(){}
}
