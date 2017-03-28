package hrank.binarySearchTree;

/**
 * Created by dipen on 3/6/2017.
 */
public interface Tree<E extends Comparable> {
    public boolean isEmpty();
    public int cardinality();
    public <E> boolean member(E emement);
    public NonEmptyBST<E> add(E element);
}
