public class LinkedListQueue {
    private SLinkedList queue= new SLinkedList();

    public void enqueue(int data){
        queue.addFirst(data);
    }

    public void dequeue(){
        queue.deleteLast();
    }

    public void print(){
        queue.printReverse();
    }
}
