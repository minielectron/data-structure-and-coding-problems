# Sorting algorithms

- Comparison based vs Non-comparison
- All the well known are comparison based like merge sor, bubble, insertion sort etc.. 
- NlogN is lower bound for comparison of n elements.

- Inplace algorithms: Not needed any extra space -- these are memory efficient.
- Recursive sorting
- Stable sorting - A stable algorithm maintains the relative order of elements with equal values(keys)
  - Insertion sort, merge sort are stable but quicksort and other hand is unstable
  - It is crucial to use stable sorting if we sort by multiple columns in a dataset(database)
- Adaptive algorithms
  - Change their behaviours based on information available at run-time
  - Take advantage of local order
  - Even O(N) time complexity can be achieved
  - heap and quick sort doesn't take advantage of adaptive
  - insertion and shell sort are adaptive algorithms

# Bogo sorting or shotgun sort/permutation sort

- O(N!) because n! permutations for n elements
- It is indeed inefficient for classical computers
- If we try to solve the same with quantum computers then it is the fastest approach possible with O(1) running time.
- because of quantum entanglement we can search for every possible permutations simultaneously.

# Bubble sort
- O(N^2) for best and worst case
- not efficient 
- In computer graphics bubble sort is popular for its capability to detect a very small error in almost sorted arrays and fix it.
- Stable sorting
- Used in polygon filling algorithm

# Selection sort
- Important when we need the least number of write(swap) operation like in flash memory.

# Insertion sort
- O(N^2) 
- For large array its inefficient
- It is an adaptive algorithm
- Stable algorithm
- In place
- Variant of insertion sort is shell sort
- It is faster for small arrays and that why it is being used in many other sorting algorithms such as quick sort.
- It is an online algorithm - It can sort an array as it receives the require shifting large sections of the sorted portion ot the array.
- It writes O(N^2), and selection sort only O(N)

# Shell sort
- Variant of insertion sort
- inplace
- adaptive
- uses insertion sort sub-procedure