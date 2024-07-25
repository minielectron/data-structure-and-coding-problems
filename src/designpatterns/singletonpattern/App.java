package designpatterns.singletonpattern;

public class App {

    public static void main(String[] args) {
        Database database = Database.getInstance();
        database.connect();
        DatabaseEnum o1 = DatabaseEnum.INSTANCE;
        o1.someXWork();
        o1.someYWork();
    }
}
