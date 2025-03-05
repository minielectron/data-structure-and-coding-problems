package datastructure.array;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicatesInArray {

    public static List<Integer> findDuplicates(int[] arr){
        Map<Integer, Integer> map = new LinkedHashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i< arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            if(e.getValue() > 1 ){
                result.add(e.getKey());
            }
        }

        return result;

    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 2, 1, 4, 5, 4};
        List<Integer> duplicates = findDuplicates(nums);
        System.out.println(duplicates);

        /*
            EXPECTED OUTPUT:
            ----------------
			[1, 2, 4]

        */

    }

}
