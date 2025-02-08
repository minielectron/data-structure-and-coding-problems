package designpatterns.builderpattern;

public class App {
    public static void main(String[] args) {
        Student student = new Student.Builder()
                .setName("Prakash sharma")
                .setAge(20)
                .build();

        System.out.println(student);
    }
}
