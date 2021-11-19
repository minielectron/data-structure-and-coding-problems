package datastructure.searching;

/*
* Compute The Integer Square Root
Given an integer n, compute the square root of n, rounded down to the nearest integer.

Example #1:
Input: 25
Output: 5
Explanation: The square root of 25 is 5.*/

public class FindSquareRoot {
    public int squareRoot(int n) {

        /* We want to find the largest integer x such that x^2 <= n. */
        /* To do so, we can binary search the interval [1, n]. */
        int lo = 1, hi = n;
        int ans = 1;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2; /* Prevent integer overflow. */
            if (mid * mid <= (long)n) {
                /* Store our best answer so far. */
                ans = (int)mid;
                lo = (int)mid + 1;
            } else {
                /* mid^2 > n, so we need to look at smaller numbers. */
                hi = (int)mid - 1;
            }
        }

        return ans;
    }
}


/*Solution:
*
* Rephrasing the stated problem, we wish to find the largest integer x such that x²
* is less than or equal to n. In order to find x, we can apply a binary search to the
* interval [0, n], where n is the provided integer. We can eliminate the right half of the
* interval being considered if the square of the number we are currently looking at is
* greater than n. Conversely, we can update our answer variable and eliminate the left
* half of our interval if the square of the number we are currently
* looking at is less than or equal to n. The runtime of this solution is O(log(n)).*/
