package hrank.customQueue;


import java.util.LinkedList;

/**
 * Created by dipen on 3/3/2017.
 */
public class CustomQueue {

    LinkedList queue;

    public CustomQueue()
    {
        queue = new LinkedList();
    }

    public boolean isEmpty()
    {
        return queue.isEmpty();
    }

    public int size()
    {
        return  queue.size();
    }

    public void enqueue(int value){
        queue.addLast(value);
    }

    public  int dequeue()
    {
        return (int)queue.remove(0);
    }

    public  int peek()
    {
        return (int)queue.get(0);
    }

    public static void main(String [] args)
    {
        CustomQueue cq = new CustomQueue();
        cq.enqueue(10);
        cq.enqueue(1);
        cq.enqueue(2);
        System.out.println(cq.peek());
        System.out.println(cq.dequeue());
        System.out.println(cq.peek());
    }
}
