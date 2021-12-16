package week5;

import java.util.Stack;

public class Queue2Stacks {
    private Stack sEnqueue=new Stack();
    private Stack sDequeue=new Stack();

    private static Stack reverse(Stack other){
        Stack myStack=new Stack();
        while (!other.isEmpty()){
            myStack.push(other.pop());
        }
        return myStack;
    }

    /**
     * This method adds an element in the tail of queue.
     *
     * @param k an int variable
     */
    public void queue(int k){
        this.sEnqueue=reverse(this.sDequeue);
        this.sEnqueue.push(k);
        this.sDequeue=reverse(this.sEnqueue);
    }

    /**
     * This method removes the first element.
     */
    public void dequeue(){
        if (!this.sDequeue.isEmpty()){
            this.sDequeue.pop();
        } else {
            System.out.println("week5.Queue is empty");
        }
    }

    /**
     * This method prints the queue.
     */
    public void print(){
       if(!this.sDequeue.isEmpty()){
           System.out.println(this.sDequeue);
       }else {
           System.out.println("week5.Queue is empty");
       }
    }

    public static void main(String[] args) {
        Queue2Stacks a= new Queue2Stacks();
        a.queue(1);
        a.queue(2);
        a.queue(3);
        a.dequeue();
        a.queue(4);
        a.print();
    }
}
