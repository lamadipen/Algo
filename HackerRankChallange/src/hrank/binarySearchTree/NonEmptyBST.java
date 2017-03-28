package hrank.binarySearchTree;

/**
 * Created by dipen on 3/6/2017.
 */
public class NonEmptyBST<E extends Comparable> implements Tree<E>{
    E data;
    Tree<E> left;
    Tree<E> right;

    public NonEmptyBST(E element)
    {
        data = element;
        left = new EmptyBST<E>();
        right = new EmptyBST<E>();
    }

    public NonEmptyBST(E element,Tree<E> leftTree,Tree<E> rightTree)
    {
        data = element;
        left = leftTree;
        right = rightTree;
    }
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int cardinality() {
        return 1+left.cardinality()+right.cardinality();
    }

    @Override
    public <E1> boolean member(E1 element) {
        if(data == element)
        {
            return  true;
        }
        else{
            if(data.compareTo(element)<0)
            {
                return left.member(element);
            }
            else{
                return right.member(element);
            }
        }

    }

    @Override
    public NonEmptyBST<E> add(E element) {
        if(data == element)
        {
            return  this;
        }
        else{
            if(data.compareTo(element)<0)
            {
                return new NonEmptyBST<E>(element,left.add(element),right);
            }
            else{
                return new NonEmptyBST<E>(element,left,right.add(element));
            }
        }
    }
}
