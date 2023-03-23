package org.lessons.HomeWork2;

import java.util.Iterator;
import java.util.function.Consumer;

public interface AlterList<E> extends Iterable<E> {
    void add(E e);

    void add(int index, E e);

    void clear();

    E get(int index);

    boolean isEmpty();

    void remove(int index);

    void remove(E e);

    int size();

    void forEach(Consumer<? super E> consumer);

    Iterator<E> iterator();
}
