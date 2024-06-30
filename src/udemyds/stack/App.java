package udemyds.stack;

public class App {
    public static void main(String[] args) {
        Stack<String> names = new Stack<>();
        System.out.println(names.isEmpty());

//        names.push("A");
//        names.push("B");
//        names.push("C");
//        names.push("D");
//
//        while (!names.isEmpty()){
//            System.out.println(names.pop());
//        }

        MinAndMaxStack stack = new MinAndMaxStack();
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
        stack.push(10);
        stack.push(1);
        stack.push(12);
        stack.push(15);
        stack.push(6);
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
        stack.pop();
        stack.pop();
        System.out.println(stack.getMax());
        System.out.println(stack.getMin());
    }
}
