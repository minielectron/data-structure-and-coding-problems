package datastructure.sorting;

import java.util.List;

class ListNode{
    ListNode next;
    int val;

    ListNode(int val){
        this.val = val;
        next = null;
    }
}
class MergeSort {
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // Obtain the pointer to mid
        ListNode mid = getMiddleAndSplitInHalf(head);

        // Recursively call the left and right linked list
        ListNode leftHalf = mergeSort(head);
        ListNode rightHalf = mergeSort(mid);

        return merge(leftHalf, rightHalf);
    }

    // Helper function to merge 2 sorted linked list
    private ListNode merge(ListNode l1Pointer, ListNode l2Pointer) {
        ListNode dummyHead = new ListNode(0);
        ListNode endOfSortedList = dummyHead;

        // We keep on adding elements in the temp linked list
        // In ascending order
        while (l1Pointer != null && l2Pointer != null) {
            if (l1Pointer.val < l2Pointer.val) {
                endOfSortedList.next = l1Pointer;
                l1Pointer = l1Pointer.next;
            } else {
                endOfSortedList.next = l2Pointer;
                l2Pointer = l2Pointer.next;
            }

            endOfSortedList = endOfSortedList.next;
        }

        // Only one of this if will be true
        // It is condition for processing the remainin elements
        if (l1Pointer != null) {
            endOfSortedList.next = l1Pointer;
        }

        if (l2Pointer != null) {
            endOfSortedList.next = l2Pointer;
        }

        return dummyHead.next;
    }

    // Helper function to find the mid element of the linked list
    // So that we can divide the linked list in 2 list
    private ListNode getMiddleAndSplitInHalf(ListNode head) {

        // We use the concept of slow and fast pointers
        // The fast pointer will traverse 2*(Speed of slow pointer)
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // When fast pointer reaches the end
        // Slow pointer will reach the mid
        while (fast != null && fast.next != null) {
            prev = slow;

            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;

        return slow;
    }
}

