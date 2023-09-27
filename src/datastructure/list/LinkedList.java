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

        return curr.data;
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
            res.append(workingPointer.data).append(", ");
            workingPointer = workingPointer.next;
        }
        return "LinkedList{" + res + '}';
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        // Find the tail and list length (so we can adjust k)
        ListNode tail = head;
        int size = 1;
        while (tail.next != null) {
            size++;
            tail = tail.next;
        }

        // Normalize k
        k %= size;

        // If k normalizes to 0, we just return the same head
        if (k == 0) {
            return head;
        }

        // Create a cycle we can traverse, we will break this later
        tail.next = head;

        int stepsToNewTail = size - k;
        ListNode rotatedListTail = tail;
        while (stepsToNewTail > 0) {
            rotatedListTail = rotatedListTail.next;
            stepsToNewTail--;
        }

        ListNode rotatedListHead = rotatedListTail.next; // The head we return
        rotatedListTail.next = null; // Cut off cycle

        return rotatedListHead;
    }

    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.addAtHead(10);
        l.addAtTail(20);
        l.addAtTail(30);
        l.addAtTail(40);
        l.addAtTail(50);
        ListNode node = l.rotateRight(l.head, 2);
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}

