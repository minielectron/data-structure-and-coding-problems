package recursions;

public class HeadTailRecursion {
    public void head(int n){
        System.out.println("Calling head function");
        if (n == 0){
            return ;
        }

        head(n - 1);
        System.out.println(n);
    }

    public void tail(int n){
        System.out.println("Calling call function");
        if (n == 0){
            return ;
        }

        System.out.println(n);
        tail(n - 1);
    }

    public static void main(String[] args) {
        HeadTailRecursion ht = new HeadTailRecursion();
        ht.head(5);
        ht.tail(5);
    }
}

