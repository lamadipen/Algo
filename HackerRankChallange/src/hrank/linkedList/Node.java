package hrank.linkedList;

/**
 * Created by dipen on 2/27/2017.
 */
public class Node {

    Node next;
    int data;

    //constructors
    public Node(int newData)
    {
        this.data = newData;
    }
    public Node(int newData,Node next)
    {
        this.data = newData;
        this.next = next;
    }

    //getters & setters
    public int getData()
    {
        return data;
    }

    public void setData(int data)
    {
        this.data = data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }


}
