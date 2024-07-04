# Array
- RAM - random access memory based
- Main advantage is we have index of items
- memory address = `array base address` + `index` * `data_size`
- There are n dimension arrays possible
- The main problem with arrays is that we have to know the numbers in advance
- Size is fixed

# Linked lists
- Easy data structure to implement
- item are not in contigous memory, no random accessing
- First item operation is O(1)
- Arbitrary item operations is O(N)


## Application of Linked list
- Low level memory management
  - Heap memory are represented as doubly linked list.
- Application in windows
  - Photoviewer doubly linked list-
- Blockchains

# Stack application [LIFO]
- Browser navigation
- Stack manager in programs memory
- undo redo application

# Binary search tree
- Every node in the tree can have at most 2 children
- left child is smaller than the parent
- right child is always greater than the parent

# Disjoint sets
- Disjoint set data structure is used in krusskal algorithm implementation
- we have to check whether adding a given edge to the mst would form a cycle or not
- union-find ds is extremely hlepful because of the union() and find() functions
- we can check whether a cycle is present in a G(V,E) graph in 0(1) constant running time complexity.[path compression]





