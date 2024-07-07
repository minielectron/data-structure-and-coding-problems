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

# AVL trees
- The height of two child subtrees of any node differ by at most one.
- AVL are faster than red black trees because they are more rigidly balanced but needs more work.
- operating system relies heavily on these data structures.
- AVL is faster but red black is easier to construct.
- Height diff between left and right should not be more than 1.
- balance factor -> | height-left - height-right | > 1 --> Imbalanced

# Red black trees
- Time complexity O(logN) in all cases
- Properties
  - Each node is red or black
  - Root node is always black
  - all lead nodes(NULL pointers) are black
  - Every red node has two black children and no other children and it must have black parent.
  - Every path from a given node to any of its descendants null nodes contains the same number of black nodes.
- Rotations when properties are violated -> O(1)
  - Left --for right heavy
  - Right -- For left heavy





