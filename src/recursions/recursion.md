# Online algorithms

- Online selection algorithms are methods that can process the input in serial manner without having the entire input 
- Available from the start
- So we don't know the whole input
- Problem: We don't know the values in advance
- We cannot find the best solution, but we can have an educated guess. we may find the item with high probablity
- this is so call `secretary problem`

# Quick select algorithms
Steps
1. Choose a pivot item at random
2. Partition the array 
3. instead of recursion on both side we take one side