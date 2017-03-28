package hrank.binarySearchTree;

/**
 * Created by dipen on 3/6/2017.
 */
public class EmptyBST<E extends Comparable> implements Tree<E>{
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int cardinality() {
        return 0;
    }

    @Override
    public <E1> boolean member(E1 emement) {
        return true;
    }

    @Override
    public NonEmptyBST<E> add(E element) {
        return new NonEmptyBST<E>(element);
    }
}
