package algoexpert;



import java.util.*;

public class MoveToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int insertPos = 0;

        // Shift non-toMove elements forward
        for (int num : array) {
            if (num != toMove) {
                array.set(insertPos++, num);
            }
        }

        // Fill remaining positions with toMove
        while (insertPos < array.size()) {
            array.set(insertPos++, toMove);
        }

        return array;
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array); // nlogn
        // Two sum O(n)
        Set<Integer[]> resultSet = new TreeSet<>((a, b) -> {
            if (!a[0].equals(b[0])) return a[0] - b[0];
            if (!a[1].equals(b[1])) return a[1] - b[1];
            return a[2] - b[2];
        });

        for (int i = 0; i < array.length; i++) {
            int target = targetSum - array[i];
            Map<Integer, Integer> map = new HashMap<>();

            // Perform two sum with this target
            for (int j = i + 1; j < array.length ; j++) {
                int complement = target - array[j];
                if (map.containsKey(complement)){
                    resultSet.add(new Integer[]{array[i],complement, array[j]});
                }
                map.put(array[j], j);
            }
        }

        return new ArrayList<>(resultSet);
    }

    public static List<List<Integer>> threeNumberSumWithPointer(int[] array, int targetSum) {
        Arrays.sort(array); // Sorting ensures ordered triplets
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < array.length - 2; i++) { // Fixing the first element
            int left = i + 1, right = array.length - 1;

            while (left < right) {
                int sum = array[i] + array[left] + array[right];

                if (sum == targetSum) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    right--;
                } else if (sum < targetSum) {
                    left++; // Need a larger sum
                } else {
                    right--; // Need a smaller sum
                }
            }
        }

        return result;
    }


    public static void swap(List<Integer> array, int i, int j){
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void main(String[] args) {
                MoveToEnd algo = new MoveToEnd();
        //        System.out.println(algo.moveElementToEnd(new ArrayList<>(), 2));
                List<Integer[]> triplets = algo.threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0);
                for (Integer[] triplet : triplets) {
                    System.out.println(Arrays.toString(triplet));
                }
        
    }
}
