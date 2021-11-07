import java.time.Instant;

class Solution {
    public static void main(String[] args) {
        Instant initialTime = Instant.now();
        System.out.println(isPower(225));
        Instant finalTime = Instant.now();
        System.out.println(finalTime.minusMillis(initialTime.toEpochMilli()).getEpochSecond());
    }

    public static boolean isPower(int a) {
        if(a ==1) return true;
        for (int i = 2; i*i <= a; i++) {
            int p = a;
            while(p%i == 0){
                p/=i;
            }
            if(p == 1) return true;
        }
        return false;
    }
}
