package udemyds.linkedlist;

public class MiddleItem {

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.insert("A");
        names.insert("B");
        names.insert("C");
        names.insert("D");
        names.insert("E");
        names.insert("F");
        names.insert("G");
        names.insert("E");

        System.out.println(names.getMiddleNode());

    }
}
