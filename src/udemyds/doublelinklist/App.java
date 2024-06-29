package udemyds.doublelinklist;

public class App {
    public static void main(String[] args) {
        DoublyLinkedList<String> names = new DoublyLinkedList<>();
        names.insert("Manish");
        names.insert("Varun");
        names.insert("Anshul");
        names.traverseForward();
        names.traverseBackward();
    }
}
