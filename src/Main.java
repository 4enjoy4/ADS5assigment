import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        BST <Integer, String> bst = new BST<>(new IntegerComparator());
        bst.put(1, "A");
        bst.put(3, "D");
        bst.put(5, "X");
        bst.put(9, "Z");
        bst.put(2, "C");
        Iterable<Integer> keys = bst.iterator();
        System.out.println(keys);
        bst.Height();



    }
}