package designpatterns.inversionofcontrol;

public class MySqlDatabase implements Database {
    @Override
    public void connect(){
        System.out.println("Connecting to database .....");
    }

    @Override
    public void disconnect(){
        System.out.println("Disconnecting to database .....");
    }
}
