package datastructure

import java.util.*

class Tree {

    var head: Node? = null
    private var temp: Node? = null

    data class Node(val data: Int, var left: Node? = null, var right: Node? = null)

    /**
     * This method will fill the tree at level order, one by one.
     * */
    fun insertNode(data: Int) {
        if (head == null) {
            head = Node(data, null, null)
            temp = head
        } else {
            val q: Queue<Node?> = LinkedList<Node?>()
            q.add(head)
            while (!q.isEmpty()) {
                temp = q.remove()
                if (temp?.left == null) {
                    temp!!.left = Node(data)
                    break
                } else {
                    q.add(temp?.left)
                }

                if (temp?.right == null) {
                    temp!!.right = Node(data)
                    break
                } else {
                    q.add(temp?.right)
                }
            }
        }
    }

    fun printInorder(root: Node?) {
        if (root == null) return
        printInorder(root.left)
        print("${root.data} ")
        printInorder(root.right)
    }

    fun printPreOrder(root: Node?) {
        if (root == null) return
        print("${root.data} ")
        printInorder(root.left)
        printInorder(root.right)
    }

    fun printPostOrder(root: Node?) {
        if (root == null) return
        printInorder(root.left)
        printInorder(root.right)
        print("${root.data} ")
    }

    /**
     * Search's the key in the tree whose root is provided as argument.
     * It has time complexity of O(n) and can be improved using binary search tree implementation.
     * */
    fun search(root: Node?, key: Int): Boolean {
        if (root != null) {
            if (root.data == key) return true
            search(root.left, key)
            search(root.right, key)
        }
        return false
    }

    /**
    * Root To Leaf Path Sum
    * Give a binary tree and a target sum sum, determine if
    * there is a path from the root to a leaf that sums to the target sum sum.
    * */
//    fun hasPathSum(node: Node, targetSum: Int): Boolean {
//        return false
//    }


    fun sumLeft(node: Node) : Int {
        return if (node.left != null) {
            node.data + sumLeft(node.left!!)
        }else{
            node.data
        }
    }
}

fun main() {

    val t = Tree()
    t.insertNode(10)
    t.insertNode(20)
    t.insertNode(30)
    t.insertNode(40)
    t.insertNode(50)
    t.insertNode(60)
    t.insertNode(70)
    t.insertNode(80)
    t.printInorder(t.head)
    println()
    t.printPreOrder(t.head)
    println()
    t.printPostOrder(t.head)
    println(t.sumLeft(t.head!!))
    println(t.search(t.head, 22))
}