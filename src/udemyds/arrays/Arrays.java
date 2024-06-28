package udemyds.arrays;

import java.util.ArrayList;
import java.util.List;

public class Arrays {
    public static void main(String[] args) {
        int[] nums = new int[10];

        for (int i = 0; i < nums.length ; i++){
            nums[i] =i;
        }

        nums[0] = 100;

//        for (int num : nums) {
//            System.out.println(num);
//        }

        // Array list uses standard array under the hood

        List<String> names = new ArrayList<>(); // default capacity 10, new capacity = old capacity + old capacity/2

        names.add("Kevin");
        names.add("Denial");
        names.add("Richard henricks");
        names.add("Dinesh");
        names.add("Gilfoyel");

        System.out.println(names.remove(0));

    }
}
