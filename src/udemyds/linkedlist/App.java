package udemyds.linkedlist;

public class App {

    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.insert("Ana");
        names.insert("Adam");
        names.insert("Daniel");
        names.traverse();

        LinkedList<Person> employees = new LinkedList<Person>();
        employees.insert(new Person(20, "Heena"));
        employees.traverse();
    }
}
