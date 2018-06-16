/* Java Program to implement a queue using two stacks */
// Note that Stack class is used for Stack implementation

import java.util.Stack;

public class emae
{

    static class Queue
    {
        Stack<Integer> stack1 ;
        Stack<Integer> stack2 ;
    }

   //push
    static void push(Stack<Integer> top_ref, int new_data)
    {
        //Push  stack
        top_ref.push(new_data);
    }


    static int pop(Stack<Integer> top_ref)
    {

        if(top_ref.isEmpty())
        {
            System.out.println("Stack Overflow");
            System.exit(0);
        }

        return top_ref.pop();
    }

    static void enQueue(Queue q, int x) {
        push(q.stack1, x);
    }

    static int deQueue(Queue q) {
        int x;
        if(q.stack1.isEmpty() && q.stack2.isEmpty() ) {
            System.out.println("Q is empty");
            System.exit(0);
        }

        // Move elements from stack1 to stack 2 only if
       // stack2 is empty
        if(q.stack2.isEmpty()) {
            while(!q.stack1.isEmpty()) {
                x = pop(q.stack1);
                push(q.stack2, x);

            }
        }
        x = pop(q.stack2);
        return x;
    }

    // Driver function to test anove functions
    public static void main(String args[])
    {

        Queue q= new Queue();
        q.stack1 = new Stack<>();
        q.stack2 = new Stack<>();
        enQueue(q, 1);
        enQueue(q, 2);
        enQueue(q, 3);
        enQueue(q,5);
        enQueue(q,8);
        enQueue(q,10);
        System.out.print(deQueue(q)+" ");
        System.out.print(deQueue(q)+" ");
        System.out.print(deQueue(q)+" ");
        System.out.print(deQueue(q)+" ");
        System.out.print(deQueue(q)+" ");
        System.out.println(deQueue(q)+" ");
    }
}