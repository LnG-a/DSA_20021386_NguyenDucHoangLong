package week6;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class SortStackAndQueue {
    /**
     * Complexity O(N^2/2)
     * Worst case: Reversed Sorted Stack
     * Best case: Sorted Stack
     *
     * @param stack a stack
     */
    public static void sortStack(Stack<Integer> stack){
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            stackAscending(stack,temp);
        }
    }
    public static void stackAscending(Stack<Integer> stack,int element){
        if (stack.isEmpty() || element< stack.peek()){
            stack.push(element);
        } else {
            int temp= stack.pop();
            stackAscending(stack,element);
            stack.push(temp);
        }
    }

    /**
     * Complexity O(N^2/2).
     * No worst case or best case.
     *
     * @param queue a queue
     */
    public static void sortQueue(Queue<Integer>  queue){
        if (!queue.isEmpty()){
            int temp= queue.dequeue();
            sortQueue(queue);
            queueAscending(queue,temp, queue.size());
        }
    }

    private static void queueAscending(Queue<Integer> queue, int element, int size) {
        if (size==0){
            queue.enqueue(element);
        } else if (element<queue.peek()){
            queue.enqueue(element);
            for (int i=0;i<size;i++){
                queue.enqueue(queue.dequeue());
            }
        } else {
            queue.enqueue(queue.dequeue());
            queueAscending(queue,element,size-1);
        }
    }

    public static void main(String[] args) {
        Stack s= new Stack();
        s.push(1);
        s.push(4);
        s.push(5);
        s.push(2);
        s.push(3);
        sortStack(s);
        System.out.println(s);
        Queue q = new Queue();
        q.enqueue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(5);
        q.enqueue(4);
        sortQueue(q);
        System.out.println(q);

    }
}
