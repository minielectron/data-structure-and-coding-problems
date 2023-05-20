# Tips and tricks for coding
## Primitives module
- To find the power of 2 use << operator instead of maths fun or simple multiplication.
- To find MSB and LSB we can use shift operators 
  ```java
     public static int findMSBPosition(int num) {
        int position = -1; // Initialize position to -1 (indicating not found)

        // Iterate through the bits from left to right
        while (num != 0) {
            num >>= 1; // Right shift the number by 1 bit
            position++; // Increment position

            // Break the loop if the number becomes 0
            if (num == 0) {
                break;
            }
        }

        return position;
    }
      ```

- To find the current bit
    ```java
    int bit = n & 1;
    ```

## Some techniques to remember 

- **Sliding Window Technique:** This technique is used for efficiently processing arrays or lists by maintaining a "window" of elements. It involves maintaining two pointers (start and end) and sliding the window based on certain conditions. It is useful for solving problems that involve subarray or substring operations.

- **Two Pointers Technique:** This technique involves using two pointers that traverse the array or list simultaneously. It is commonly used for solving problems that require finding pairs or subarrays with specific properties, such as the two-sum problem or the three-sum problem.

- **Binary Search:** Binary search is an efficient search algorithm used for finding the position of a target element in a sorted array. It involves repeatedly dividing the search space in half until the target element is found. Binary search is particularly useful when the search space is large.

- **Dynamic Programming:** Dynamic programming is a technique used for solving optimization problems by breaking them into smaller overlapping subproblems. It involves solving each subproblem only once and storing the results to avoid redundant computations. Dynamic programming can be applied to a wide range of problems, such as knapsack problems, longest common subsequence, and matrix chain multiplication.

- **Greedy Algorithms:** Greedy algorithms make locally optimal choices at each step with the hope of finding a global optimum. They are useful for solving problems where making the best immediate choice leads to the best overall solution. Examples include the coin change problem, interval scheduling, and minimum spanning tree algorithms like Kruskal's and Prim's algorithms.

- **Graph Algorithms:** Familiarity with graph algorithms is crucial in competitive programming. Some important graph algorithms include breadth-first search (BFS), depth-first search (DFS), Dijkstra's algorithm for single-source shortest paths, Bellman-Ford algorithm for single-source shortest paths with negative weights, and Floyd-Warshall algorithm for all-pairs shortest paths.

- **Divide and Conquer:** The divide and conquer technique involves breaking a problem into smaller subproblems, solving them recursively, and then combining their solutions to solve the original problem. Examples of divide and conquer algorithms include merge sort, quicksort, and finding the maximum subarray sum.

- **Backtracking:** Backtracking is a technique for exhaustive searching through all possible solutions of a problem by incrementally building candidates and undoing choices when they lead to dead ends. It is commonly used in problems such as generating permutations, solving Sudoku, and solving the N-queens problem.

- **String Algorithms:** String manipulation is a common task in competitive programming. Important string algorithms and techniques include string matching algorithms like Knuth-Morris-Pratt (KMP) and Rabin-Karp, suffix arrays, and trie data structure.

- **Bit Manipulation:** Bit manipulation techniques are useful when dealing with problems that involve binary representations or operations on bits. Some common bit manipulation operations include bitwise AND, OR, XOR, left shift, right shift, and bit masking.


