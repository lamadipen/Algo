package com.effectivejava.concurrency.avoidExcessiveSynchronization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Effective Java
 * Chapter 11 CONCURRENCY
 * Avoid excessive synchronization
 * <p>
 * Synchronization is required for reliable communication between threads as well as for mutual exclusion.
 * The consequences of failing to synchronize access to shared mutable data can be dire even if the data is
 * automatically readable and writable.
 * <p>
 * A recommended way to stop one thread from another is to have the first thread poll a boolean field that is
 * initially false but can set to true by the second thread to indicate that the first thread is to stop itself.
 * Because reading and writing a boolean field is atomic.
 * <p>
 * Problem
 * The program never terminates
 */
public class ObservableSet<E> extends ForwardingSet<E> {

    public ObservableSet(Set<E> set) {
        super(set);
    }

    /** Fix with sychronization  but leads to deallock inital version was without sychronization*/
//    private final List<SetObserver> observers = new ArrayList<>();
//
//    public void addObserver(SetObserver<E> observer) {
//        synchronized (observers) {
//            observers.add(observer);
//        }
//    }
//
//    public boolean removeObserver(SetObserver<E> observer) {
//        synchronized (observers) {
//            return observers.remove(observer);
//        }
//    }
//
//    private void notifyElementsAdded(E element) {
//        synchronized (observers) {
//            for (SetObserver<E> observer : observers) {
//                observer.added(this, element);
//            }
//        }
//    }

/** Alien method moved outside of synchronized block open calls */
/*    private void notifyElementsAdded(E element) {
        List<SetObserver> snapshot = null;
        synchronized (observers) {
            snapshot = new ArrayList<>(observers);
        }
        for (SetObserver<E> observer : snapshot) {
            observer.added(this, element);
        }
    }*/


    /**
     * Final solution with CopyOnWriteArrayList
     */
    private final List<SetObserver<E>> observers = new CopyOnWriteArrayList<>();

    public void addObserver(SetObserver<E> observer) {
        observers.add(observer);
    }

    public boolean removeObserver(SetObserver<E> observer) {
        return observers.remove(observer);
    }

    public void notifyElementsAdded(E element) {
        for (SetObserver<E> observer : observers) {
            observer.added(this, element);
        }
    }
    @Override
    public boolean add(E element) {
        boolean added = super.add(element);
        if (added) {
            notifyElementsAdded(element);
        }
        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;
        for (E element : c) {
            result |= add(element); //Calls notifyElementAdded
        }
        return result;
    }
}
