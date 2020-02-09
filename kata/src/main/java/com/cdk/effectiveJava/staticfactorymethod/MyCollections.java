package com.cdk.effectiveJava.staticfactorymethod;

import java.io.Serializable;
import java.util.Iterator;
/**
 * Chapeter 2 Static Factory Method
 * **/
public class MyCollections{

    private MyCollections() {
    }

    public static <T> MyCollection<T> unmodifiableCollection(MyCollection<? extends T> c){
        return new MyCollections.UnmodifiableCollection<>(c);
    }

    static class UnmodifiableCollection<E> implements MyCollection<E>, Serializable {
        final MyCollection<? extends E> c;

        UnmodifiableCollection(MyCollection<? extends E> c) {
            if (c==null)
                throw new NullPointerException();
            this.c = c;
        }
        @Override
        public int isEmpty() {
            return 0;
        }

        @Override
        public int size() {
            return 0;
        }

        @Override
        public Iterator<E> iterator() {
            return null;
        }
    }
}
