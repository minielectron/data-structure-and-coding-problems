package designpatterns.factory;

public class AnimalFactory {

    public static Animal getAnimal(AnimalType type){
        switch (type){
            case DOG: return new Dog();
            case CAT: return new Cat();
            case MOUSE: return new Mouse();
            case ELEPHANT: return new Elephant();
        }

        return null;
    }
}
