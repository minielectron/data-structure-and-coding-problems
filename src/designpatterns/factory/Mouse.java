package designpatterns.factory;

public class Mouse implements Animal{
    @Override
    public void eat() {
        System.out.println("Mouse is eating");
    }
}
