import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        BST <Integer, String> bst = new BST<>(new IntegerComparator());
        bst.put(1, "A");
        bst.put(3, "D");
        bst.put(5, "X");
        bst.put(9, "Z");
        bst.put(2, "C");
        String letter = bst.get(2);
        System.out.println("Value associated with key 2: " + letter);
        String letter1 = bst.get(4);
        System.out.println("Value associated with key 4: " + letter1);
        Iterable<Integer> keys = bst.iterator();
        System.out.println("Keys in the BST:");
        for (Integer key : keys) {
            System.out.println(key);
        }
        bst.delete(2);
        Iterable<Integer> keys1 = bst.iterator();
        System.out.println("Keys in the BST:");
        for (Integer key : keys1) {
            System.out.println(key);
        }

    }
}