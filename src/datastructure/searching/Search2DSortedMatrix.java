package datastructure.searching;

/*Search A 2D Sorted Matrix
Given a 2D matrix (which is m x n) find the given element with value value.
 If the matrix contains the value return true, otherwise return false.

Note:
In this variant:
Each row is sorted
Each column is sorted
There is no guarantee that the last element in row i is <= the first element in row i+1

Example:
Input:
value = 20
[
  [1, 4, 7, 11]
  [8, 9, 10, 20]
  [11, 12, 17, 30]
]

Output: true*/

public class Search2DSortedMatrix {

    public static void main(String[] args) {
        Search2DSortedMatrix s = new Search2DSortedMatrix();
        int[][] input = {{1, 4, 7, 11}, {8, 9, 10, 20}, {11, 12, 17, 30}};
        System.out.println(s.search(input, 20));
    }

    public boolean search(int[][] matrix, int target) {

        for (int[] ints : matrix) {
            if (binarySearch(ints, target)) return true;
        }

        return false;
    }

    public boolean binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) return true;
            else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return false;
    }
}
