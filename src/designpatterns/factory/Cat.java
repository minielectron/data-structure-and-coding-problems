package designpatterns.factory;

public class Cat implements Animal{
    @Override
    public void eat() {
        System.out.println("Cat is eating");
    }
}
