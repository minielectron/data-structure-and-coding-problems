import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solve(int[] A, int B) {
        int [] output = new int[B+1];
        for(int i= 0; i <= B; i++){
            int sum = 0;
            //From front
            for(int j = 0; j < i; j++){
                sum += A[j];
            }
            //From back
            for(int k = A.length -1; k >= A.length - B + i ; k--){
                sum += A[k];
            }
            output[i] = sum;
        }

        int max = output[0];
        for(int i = 1; i < output.length;i++){
            if(output[i] > max) max = output[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] input = {-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35};
//        int[] input = {5,-2,4,2,1};
        System.out.println(s.solve(input, 48));
    }
}
