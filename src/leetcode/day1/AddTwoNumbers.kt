package leetcode.day1

import datastructure.list.LinkedList
import datastructure.list.ListNode


/**
*
* You are given two non-empty linked lists representing two non-negative integers.
* The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
 */
class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode, l2: ListNode): ListNode? {

        var overflow = 0
        var output : ListNode? = null
        var outputHead = output
        var wp1: ListNode? = l1
        var wp2: ListNode? = l2
        var isLastOverflow = false

        while(wp1 != null && wp2 != null){
            var sum = wp1.data + wp2.data + overflow
            if (sum / 10 > 0){
                overflow = sum / 10
                sum %= 10
                if(wp1.next == null && wp2.next ==null){
                    isLastOverflow = true
                }
            }else{
                overflow = 0
            }
            val node = ListNode(sum, null)
            if(output == null){
                output = node
                outputHead = node
            }else{
                output.next = node
                output = node
            }
            wp1 = wp1.next
            wp2 = wp2.next
        }

        while (wp1 != null){
            var sum = wp1.data + overflow
            if (sum / 10 > 0){
                overflow = sum / 10
                sum %= 10
                if(wp1.next == null){
                    isLastOverflow = true
                }
            }else{
                overflow = 0
            }
            val node = ListNode(sum, null)
            if(output == null){
                output = node
            }else{
                output.next = node
                output = node
            }
            wp1 = wp1.next
        }

        while (wp2 != null){
            var sum = wp2.data + overflow
            if (sum / 10 > 0){
                overflow = sum / 10
                sum %= 10
                if(wp2.next ==null){
                    isLastOverflow = true
                }
            }else {
                overflow = 0
            }
            val node = ListNode(sum, null)
            if(output == null){
                output = node
            }else{
                output.next = node
                output = node
            }
            wp2 = wp2.next
        }

        if (isLastOverflow){
            output?.next = ListNode(overflow)
        }

        return outputHead
    }
}

fun main() {
    val num = AddTwoNumbers()
    val list1 = ListNode(9)
    list1.next = ListNode(9)
    list1.next.next = ListNode(9)
    list1.next.next.next = ListNode(9)
    list1.next.next.next.next = ListNode(9)
    list1.next.next.next.next.next = ListNode(9)
    list1.next.next.next.next.next.next = ListNode(9)

    val list2 = ListNode(9)
    list2.next = ListNode(9)
    list2.next.next = ListNode(9)
    list2.next.next.next = ListNode(9)

    var output = num.addTwoNumbers(list1, list2)

    while (output != null){
        print(output.data)
        output = output.next
    }
}