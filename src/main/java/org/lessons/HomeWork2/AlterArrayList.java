package org.lessons.HomeWork2;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class AlterArrayList<E> implements AlterList<E> {
    protected transient int modCount = 0;

    private int size;

    private final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public AlterArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public AlterArrayList(int capacity){
        this.elements = new Object[capacity];
        size = 0;
    }

    @Override
    public void add(E e) {
        if (size == elements.length) {
            expandArray();
        }
        elements[size] = e;
        size += 1;
    }

    @Override
    public void add(int index, E e) {
        if (size == elements.length) {
            expandArray();
        }
        if (index < size) {
            Object[] newArray = Arrays.copyOfRange(elements, index, size);
            elements[index] = e;
            System.arraycopy(newArray, 0, elements, index + 1, newArray.length);
            size += 1;
        } else {
            throw new IndexOutOfBoundsException(String.format("index %s, last index %s", index, lastIndex()));
        }
    }

    private void expandArray() {
        elements = Arrays.copyOf(elements, ((size / 2) + 1) + size);
    }

    private int lastIndex() {
        return size - 1;
    }

    @Override
    public void clear() {
        this.elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int indexOf(E e) {
        for (int i = 0; i < this.size; i++) {
            if (e.equals(this.elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int index) {
        return (E) elements[index];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        removeElement(get(index));
    }

    @Override
    public void remove(E e) {
        removeElement(e);
    }

    @SuppressWarnings("unchecked")
    private void removeElement(E e) {
        elements = Arrays.stream(elements).filter(o -> !e.equals((E) o)).toArray();
        size -= 1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    @Override
    public void forEach(Consumer<? super E> consumer) {
        Objects.requireNonNull(consumer);
        final int expectedModCount = modCount;
        final Object[] es = elements;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size; i++) {
            consumer.accept(elementAt(es, i));
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    @SuppressWarnings("unchecked")
    static <E> E elementAt(Object[] es, int index) {
        return (E) es[index];
    }

    private class Itr implements Iterator<E> {
        int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return elements[currentIndex + 1] != null;
        }

        @Override
        @SuppressWarnings("unchecked")
        public E next() {
            E element = (E) elements[currentIndex + 1];
            currentIndex++;
            return element;
        }
    }
}