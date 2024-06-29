package udemyds.stack;

public class App {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        System.out.println(names.isEmpty());

        names.push("A");
        names.push("B");
        names.push("C");
        names.push("D");

        while (!names.isEmpty()){
            System.out.println(names.pop());
        }
    }
}
