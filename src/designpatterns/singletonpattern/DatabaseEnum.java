package designpatterns.singletonpattern;

public enum DatabaseEnum {
    // by default thread safe on compile time
    INSTANCE;

    void someXWork(){
        System.out.println("Doing some X work");
    }

    void someYWork(){
        System.out.println("Doing some Y work");
    }
}
