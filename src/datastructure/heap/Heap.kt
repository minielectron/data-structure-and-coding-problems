package datastructure.heap

class Heap {

    private val heap = arrayListOf<Int>()

    fun getHeap(): List<Int> {
        return heap.toList()
    }

    fun getLeftChild(index: Int): Int {
        return 2 * index + 1
    }

    fun getRightChild(index: Int): Int {
        return 2 * index + 2
    }

    private fun getParentIndex(index: Int): Int {
        return (index - 1) / 2
    }

    fun insert(item: Int) {
        heap.add(item)
        heapifyUp()
    }

    private fun heapifyUp() { // For max heap
        var index = heap.size - 1  // Start at the last element
        while (hasParent(index) && parent(index) < heap[index]) {  // While we have a parent and it's greater than the current node
            // Swap the current node with its parent
            swap(getParentIndex(index), index)
            // Move up the tree
            index = getParentIndex(index)
        }
    }

    private fun heapifyDown() { // for min heap
        var index = heap.size - 1  // Start at the last element
        while (hasParent(index) && parent(index) > heap[index]) {  // While we have a parent and it's greater than the current node
            // Swap the current node with its parent
            swap(getParentIndex(index), index)
            // Move up the tree
            index = getParentIndex(index)
        }
    }

    fun remove() : Int? {
        if (heap.isEmpty()) return null

        if (heap.size ==  1){
            return heap.removeAt(0)
        }

        val maxValue = heap[0]
        heap[0] = heap.removeAt(heap.size -1)
        sinkDown(0)
        return maxValue
    }

    fun findKthSmallest(nums: IntArray, k: Int): Int? {
        val heap = Heap()

        if (nums.isEmpty()) return null
        if (k < 0 || k> nums.size) return null
        if (nums.size == 1) return heap.remove()

        for (i in nums.indices) {
            heap.insert(nums[i])
        }

        val size = nums.size
        var actaulK = size - k
        var ans = -1
        while (actaulK >= 0) {
            ans = heap.remove()!!
            actaulK--
        }
        return ans
    }
    private fun sinkDown(index: Int) {
        var index = index
        var maxIndex = index
        while (true) {
            val leftIndex: Int = getLeftChild(index)
            val rightIndex: Int = getRightChild(index)
            if (leftIndex < heap.size && heap[leftIndex] > heap[maxIndex]) {
                maxIndex = leftIndex
            }
            if (rightIndex < heap.size && heap[rightIndex] > heap[maxIndex]) {
                maxIndex = rightIndex
            }
            index = if (maxIndex != index) {
                swap(index, maxIndex)
                maxIndex
            } else {
                return
            }
        }
    }

    private fun hasParent(index: Int) = getParentIndex(index) >= 0

    private fun parent(index: Int) = heap[getParentIndex(index)]
    private fun swap(i: Int, j: Int) {
        val temp = heap[i]
        heap[i] = heap[j]
        heap[j] = temp
    }

    override fun toString(): String {
        return "$heap"
    }

}

fun main() {
    val heap = Heap()
    // Test case 1
    // Test case 1
    val nums1 = intArrayOf(7, 10, 4, 3, 20, 15)
    val k1 = 3
    println("Test case 1:")
    println("Expected output: 7")
    System.out.println("Actual output: " + heap.findKthSmallest(nums1, k1))
    println()

    // Test case 2

    // Test case 2
    val nums2 = intArrayOf(2, 1, 3, 5, 6, 4)
    val k2 = 2
    println("Test case 2:")
    println("Expected output: 2")
    System.out.println("Actual output: " + heap.findKthSmallest(nums2, k2))
    println()

    // Test case 3

    // Test case 3
    val nums3 = intArrayOf(9, 3, 2, 11, 7, 10, 4, 5)
    val k3 = 5
    println("Test case 3:")
    println("Expected output: 7")
    System.out.println("Actual output: " + heap.findKthSmallest(nums3, k3))
    println()

}