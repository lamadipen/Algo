package com.cdk.effectiveJava.staticfactorymethod;

public interface MyCollection<E> extends Iterable<E> {

    int isEmpty();

    int size();
}
