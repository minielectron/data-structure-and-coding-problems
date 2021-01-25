package day1;

interface I1{
    void m1();
}

interface I2{
    void m2();
}

class child implements I1,I2{
    protected final void show(){

    }

    public void m1() {
        System.out.println("m1");
    }

    public void m2() {
        System.out.println("m2");
    }
}

class Main{
    public static void main(String[] args) {
        child c = new child();
        c.m2();
    }
}
