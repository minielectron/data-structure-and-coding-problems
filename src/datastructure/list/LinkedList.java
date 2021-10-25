package datastructure.list;

public class LinkedList {
    ListNode head;
    int size;

    public LinkedList() {
        head = new ListNode(); // dummy head
    }

    // O(n)
    public int getElementAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return -1;
        }

        ListNode curr = head.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    // O(1)
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);

        newNode.next = head.next; // wire new node to first item
        head.next = newNode; // wire dummy head to new node
        size++;
    }

    /*
      O(n) - can be made O(1) if we make the tail node doubly linked
      so it can "look back". This will complicate deletion and insertion
      a bit so for simplicity the linear approach is shown.
    */
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);

        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        size++;
    }

    // O(n)
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > this.size) {
            return;
        }

        ListNode newNode = new ListNode(val);

        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;

        size++;
    }

    // O(n)
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }

        ListNode curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;

        size--;
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode removeKthToLast(int k) throws IllegalArgumentException{
        ListNode previousElement = head;
        ListNode temp = head;
        for (int i = 0; i < k ; i++){
            if (temp == null && temp.next == null) {
                throw new IllegalArgumentException("The element not found");
            }else {
                temp = temp.next;
            }
        }

        while (temp.next != null){
            previousElement = previousElement.next;
            temp = temp.next;
        }

        previousElement.next = previousElement.next.next;

        return head;
    }

    @Override
    public String toString() {
        ListNode workingPointer = head.next;
        StringBuilder res = new StringBuilder();
        while (workingPointer != null) {
            res.append(workingPointer.val).append(", ");
            workingPointer = workingPointer.next;
        }
        return "LinkedList{" + res + '}';
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addAtHead(10);
        l.addAtTail(20);
        l.addAtTail(30);
        l.addAtTail(40);
        l.addAtTail(50);
        l.removeKthToLast(3);
        System.out.println(l.toString());
    }
}
