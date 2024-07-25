package designpatterns.singletonpattern;

public class Database {

    private static Database INSTANCE;

    private Database(){
        // Restrict object creation using new keyword
    }

    public static Database getInstance(){
        if (INSTANCE == null){
            synchronized (Database.class){ // To avoid multiple object creation when using multithreading.
                INSTANCE = new Database();
            }
        }
        return INSTANCE;
    }

    public void connect(){
        System.out.println("Connecting ...");
    }
}
