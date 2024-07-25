package designpatterns.inversionofcontrol;

public class App {
    public static void main(String[] args) {
        Database database = new MySqlDatabase();
        DatabaseController controller = new DatabaseController(database);
        controller.connect();
    }
}
