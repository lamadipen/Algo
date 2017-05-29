package hrank.IsThisaBinarySearchTree.BSTExample;

/**
 * Created by dipen on 5/28/2017.
 */
public class Node {

    public int data;
    public Node left,right;

    public Node(int data)
    {
        this.data = data;
    }


    public  void insert(int value)
    {
        if(value <= data)
        {
            if(left == null)
            {
                left = new Node(value);
            }
            else
            {
                left.insert(value);
            }
        }
        else
        {
            if(right == null)
            {
                right = new Node(value);
            }
            else
            {
                right.insert(value);
            }

        }
    }

    public boolean contains(int value)
    {
        if(data == value)
        {
            return true;
        }
        else if(value < data)
        {
            if(left == null)
            {
                return false;
            }else
            {
                return left.contains(value);
            }
        }
        else{
            if(right == null)
            {
                return  false;
            }else{
                return right.contains(value);
            }
        }
    }

    public void  printInorder()
    {
        if(left != null)
        {
            left.printInorder();
        }
        System.out.println(data);
        if(right != null)
        {
            right.printInorder();
        }
    }

    public  static  void main(String [] args)
    {
        Node root = new Node(4);

        root.insert(2);
        root.insert(6);
       // root.insert(1);
       // root.insert(3);
       // root.insert(5);
       // root.insert(7);

        root.printInorder();
    }
}
