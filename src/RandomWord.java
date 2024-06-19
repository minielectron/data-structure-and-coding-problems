import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        String champion = "";
        int i = 0;
        do {
            String input = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / ++i)) {
                champion = input;
            }
        } while (!StdIn.isEmpty());
        StdOut.println(champion);
    }

    int randomNumberGenerator() {
        return StdRandom.uniform(10);
    }


}
