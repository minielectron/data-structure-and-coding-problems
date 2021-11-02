class Solution {
    public static void main(String[] args) {
        B b = new B();
        b.run(10);
    }
}

class A {
    void run(){

    }
}

class B extends A  {

    boolean run(int a){
        return true;
    }
}