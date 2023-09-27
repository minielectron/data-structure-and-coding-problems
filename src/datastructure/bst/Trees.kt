package datastructure.bst

import java.util.LinkedList

data class TreeNode(var data: Int, var left: TreeNode? = null, var right: TreeNode? = null)
class Trees {
    fun buildTree(arr: Array<Int?>): TreeNode? {
        if (arr.isEmpty() || arr[0] == null) return null

        val root = TreeNode(arr[0]!!)
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var i = 1

        while (i < arr.size) {
            val node = queue.poll()

            arr[i]?.let { data ->
                node.left = TreeNode(data).also {
                    queue.add(it)
                }
            }

            i++

            if (i < arr.size) {
                arr[i]?.let { data ->
                    node.right = TreeNode(data).also {
                        queue.add(it)
                    }
                }
            }

            i++
        }

        return root
    }

    fun printPreorder(root: TreeNode?) {
        if (root != null) {
            println(root.data)
            printPreorder(root.left)
            printPreorder(root.right)
        }
    }

    fun printInorder(root: TreeNode?) {
        if (root != null) {
            printInorder(root.left)
            println(root.data)
            printInorder(root.right)
        }
    }

    fun printPostorder(root: TreeNode?) {
        if (root != null) {
            printPostorder(root.left)
            printPostorder(root.right)
            println(root.data)
        }
    }

    fun levelOrderTraversal(root: TreeNode?) {
        if (root == null) return

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val curr = queue.poll()
            println(curr.data)
            curr.left?.let { queue.add(it) }
            curr.right?.let { queue.add(it) }
        }
    }

}

fun main() {
    val tree = Trees()
    val nodes = Array<Int?>(6) { i -> i + 1 }
    val root = tree.buildTree(nodes)
    println("Preorder")
    tree.printPreorder(root)
    println("Inorder")
    tree.printInorder(root)
    println("Postorder")
    tree.printPostorder(root)
    println("Level order")
    tree.levelOrderTraversal(root)
}