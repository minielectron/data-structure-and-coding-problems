package designpatterns.inversionofcontrol;

public class OracleDatabase  implements  Database{
    @Override
    public void connect(){
        System.out.println("Connecting to oracle database .....");
    }
    @Override
    public void disconnect(){
        System.out.println("Disconnecting from oracle database .....");
    }
}
