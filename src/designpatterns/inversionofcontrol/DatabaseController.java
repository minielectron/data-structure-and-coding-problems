package designpatterns.inversionofcontrol;

// The high level module
public class DatabaseController {

    private final Database database;

    public DatabaseController(Database database) {
        this.database = database;
    }

    public void connect(){
        database.connect();
    }

    public void disconnect(){
        database.disconnect();
    }
}
