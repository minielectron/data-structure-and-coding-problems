package udemyds.queue;

public class App {
    public static void main(String[] args) {
        Queue<String> names = new Queue<>();
        names.enqueue("foo");
        names.enqueue("bar");
        names.enqueue("baz");
        names.traverse();

        System.out.println("---------------------");

        names.dequeue();
        names.dequeue();
        names.dequeue();
        names.traverse();
        System.out.println(names.size());
        System.out.println(names.isEmpty());

    }
}
