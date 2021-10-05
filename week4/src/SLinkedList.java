public class SLinkedList {
    Node head;

    /**
     * This method adds a new Node at head of LinkedList.
     *
     * @param data the data of new Node
     */
    public void addFirst(int data) {
        if (this.head == null) this.head = new Node(data, null);
        else this.head = new Node(data, this.head);
    }

    /**
     * This method adds a new Node at tail of LinkedList.
     *
     * @param data the data of new Node
     */
    public void addLast(int data) {
        if (this.head == null) addFirst(data);
        else {
            Node current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node(data, null);
        }
    }

    /**
     * This method deletes head Node.
     */
    public void deleteFirst() {
        if (head!=null) head=head.next;
    }

    /**
     * This method deltes the tail Node.
     */
    public void deleteLast() {
        if (head==null) return;
        if (head.next==null) {
            deleteFirst();
            return;
        }
        Node current = head;
        while (current.next.next!=null) current=current.next;
        current.next=null;
    }

    /**
     * This methdo deletes Node has specific position.
     * @param index the position of the Node.
     */
    public void delete(int index) {
        if (index==0) {
            deleteFirst();
            return;
        }
        Node current = head;
        for (int i=1;i<index;i++) current = current.next;
        if (current != null && current.next!=null) {
            current.next=current.next.next;
        } else {
            System.out.println("Invalid index");
        }

    }

    public void reverse(){
        reverse(head);
    }

    private void reverse(Node start){
        if(start==null||start.next==null){
            head=start;
            return;
        }
        reverse(start.next);
        start.next.next=start;
        start.next=null;
    }
    /**
     * This method print all Nodes in LinkedList
     */
    public void print() {
        Node a = head;
        System.out.print("[");
        while (a != null) {
            System.out.print(a.data);
            if (a.next != null) System.out.print(", ");
            a = a.next;
        }
        System.out.println("]");
    }

    /**
     * This method print all Nodes in LinkedList in reverse order.
     */
    public void printReverse() {
        System.out.print("[");
        printReverse(this.head);
        System.out.println("]");
    }

    private void printReverse(Node start) {
        if (start == null) {
            return;
        }
        printReverse(start.next);
        if (start != this.head) {
            System.out.print(start.data + ", ");
        } else {
            System.out.print(start.data);
        }
    }

    private class Node {
        public int data;
        public Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
