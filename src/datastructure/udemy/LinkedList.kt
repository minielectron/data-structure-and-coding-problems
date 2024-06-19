package datastructure.udemy

class LinkedList(value: Int) {
    var head: Node?
        private set
    var tail: Node?
        private set
    var length: Int
        private set

    inner class Node(var value: Int) {
        var next: Node? = null
    }

    init {
        val newNode: Node = Node(value)
        head = newNode
        tail = newNode
        length = 1
    }

    fun printList() {
        var temp = head
        while (temp != null) {
            println(temp.value)
            temp = temp.next
        }
    }

    fun printAll() {
        if (length == 0) {
            println("Head: null")
            println("Tail: null")
        } else {
            println("Head: " + head!!.value)
            println("Tail: " + tail!!.value)
        }
        println("Length:$length")
        println("\nLinked List:")
        if (length == 0) {
            println("empty")
        } else {
            printList()
        }
    }

    fun makeEmpty() {
        head = null
        tail = null
        length = 0
    }

    fun append(value: Int) {
        val newNode: Node = Node(value)
        if (length == 0) {
            head = newNode
            tail = newNode
        } else {
            tail!!.next = newNode
            tail = newNode
        }
        length++
    }

    fun removeLast(): Node? {
        if (length == 0) return null
        var temp = head
        var pre = head
        while (temp!!.next != null) {
            pre = temp
            temp = temp.next
        }
        tail = pre
        tail!!.next = null
        length--
        if (length == 0) {
            head = null
            tail = null
        }
        return temp
    }

    fun prepend(value: Int) {
        val newNode: Node = Node(value)
        if (length == 0) {
            head = newNode
            tail = newNode
        } else {
            newNode.next = head
            head = newNode
        }
        length++
    }

    fun removeFirst(): Node? {
        if (length == 0) return null
        val temp = head
        head = head!!.next
        temp!!.next = null
        length--
        if (length == 0) {
            tail = null
        }
        return temp
    }

    fun get(index: Int): Node? {
        if (index < 0) return null
        if (index > length - 1) return null

        var temp = head
        var i = 0
        while (i != index) {
            temp = temp!!.next
            i++
        }
        return temp
    }
}

fun main() {
    val ll = LinkedList(10);
    ll.append(20)
    ll.append(30)
    ll.append(40)
    ll.append(50)
    println(ll.get(0)?.value)
    println(ll.get(1)?.value)
    println(ll.get(2)?.value)
    println(ll.get(3)?.value)
    println(ll.get(4)?.value)
    println(ll.get(5)?.value)
    println(ll.get(-1)?.value)
    ll.printList()
}

