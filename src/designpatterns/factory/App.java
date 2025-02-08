package designpatterns.factory;

public class App {
    public static void main(String[] args) {
        Animal animal = AnimalFactory.getAnimal(AnimalType.MOUSE);
        assert animal != null;
        animal.eat();
    }
}
