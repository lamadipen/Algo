package hrank.linkedList;

/**
 * Created by dipen on 2/27/2017.
 */
public class LinkedList {
    Node head;
    int count;

   /* public LinkedList()
    {
        head =null;
        count =0;
    }*/

    public LinkedList(Node head)
    {
        this.head =head;
        count =1;
    }

    public void add(int newData)
    {
        Node temp= new Node(newData);
        Node current = head;
        while(current.getNext() !=null)
        {
            current = current.getNext();
        }
        current.setNext(temp);
        count++;
    }

    public int get(int index)
    {
        if(index <=0)
        {
            return -1;
        }
        Node current = head;
        for(int i=1; i <index;i++)
        {
            current = current.getNext();
        }
        return current.getData();
    }

    public int size()
    {
        return count;
    }

    public boolean isEmpty()
    {
        return head==null;
    }

    public void remove()
    {
        Node current =head;
        while(current.getNext().getNext() != null)
        {
            current.getNext();
        }
        current.setNext(null);
        count--;
    }
    public static void main(String [] args)
    {

    }

}
