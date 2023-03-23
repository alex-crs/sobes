package org.lessons.HomeWork2;

import org.w3c.dom.Node;

import java.util.*;
import java.util.function.Consumer;

public class AlterLinkedList<E> implements AlterList<E> {

    private int size;
    private AlterNode<E> first;
    private AlterNode<E> last;

    public AlterLinkedList() {
        this.size = 0;
    }

    @Override
    public void add(E e) {
        final AlterNode<E> lastNode = last;
        final AlterNode<E> newNode = new AlterNode<>(e, null, lastNode);
        last = newNode;
        if (lastNode == null) {
            first = newNode;
        } else {
            lastNode.next = newNode;
        }
        size++;
    }

    @Override
    public void add(int index, E e) {
        AlterNode<E> node = getNode(index);
        assert node != null;
        AlterNode<E> previousElement = node.previous;
        AlterNode<E> nextElement = node;
        AlterNode<E> insertElement = new AlterNode<>(e, nextElement, previousElement);
        previousElement.next = insertElement;
        nextElement.previous = insertElement;
        size++;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
    }

    @Override
    public E get(int index) {
        AlterNode<E> node = getNode(index);
        assert node != null;
        return node.element;
    }

    public int indexOf(E e) {
        return forwardStep(e);
    }

    private AlterNode<E> backStep(int index) {
        int indexCount = size - 1;
        AlterNode<E> node = last;
        while (node.previous != null) {
            if (indexCount == index) {
                return node;
            } else {
                indexCount--;
                node = node.previous;
            }
        }
        return null;
    }

    private AlterNode<E> forwardStep(int index) {
        int indexCount = 0;
        AlterNode<E> node = first;
        while (node.next != null) {
            if (indexCount == index) {
                return node;
            } else {
                indexCount++;
                node = node.next;
            }
        }
        return null;
    }

    private int forwardStep(E e) {
        int indexCount = 0;
        AlterNode<E> node = first;
        while (true) {
            if (node.element.equals(e)) {
                return indexCount;
            } else if (node.next == null) {
                return -1;
            }
            indexCount++;
            node = node.next;
        }
    }

    private AlterNode<E> findNodeByElement(E e){
        int indexCount = 0;
        AlterNode<E> node = first;
        while (true) {
            if (node.element.equals(e)) {
                return node;
            } else if (node.next == null) {
                return null;
            }
            indexCount++;
            node = node.next;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(int index) {
        AlterNode<E> node = getNode(index);
        removeLinks(node);
    }

    private AlterNode<E> getNode(int index) {
        if (index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException(String.format("index %s, last index %s", index, size - 1));
        }
        AlterNode<E> node;
        if (index <= size / 2) {
            node = forwardStep(index);
        } else {
            node = backStep(index);
        }
        return node;
    }

    @Override
    public void remove(E e) {
        AlterNode<E> node = findNodeByElement(e);
        removeLinks(node);
    }

    private void removeLinks(AlterNode<E> node){
        AlterNode<E> previousElement = node.previous;
        AlterNode<E> nextElement = node.next;
        previousElement.next = nextElement;
        nextElement.previous = previousElement;
        node.element = null;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void forEach(Consumer<? super E> consumer) {

    }

    @Override
    public Iterator<E> iterator() {
        return new ListItr(0);
    }

    private static class AlterNode<E> {
        E element;
        AlterNode<E> next;

        AlterNode<E> previous;

        public AlterNode(E element, AlterNode<E> next, AlterNode<E> previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
    }
    private class ListItr implements ListIterator<E> {
        private AlterNode<E> lastReturned;
        private AlterNode<E> next;
        private int nextIndex;


        ListItr(int index) {
            // assert isPositionIndex(index);
            next = (index == size) ? null : getNode(index);
            nextIndex = index;
        }

        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public E next() {
            lastReturned = next;
            next = next.next;
            nextIndex++;
            return lastReturned.element;
        }

        public boolean hasPrevious() {
            return nextIndex > 0;
        }

        @Override
        public E previous() {
            if (!hasPrevious())
                throw new NoSuchElementException();

            lastReturned = next = (next == null) ? last : next;
            nextIndex--;
            return lastReturned.element;
        }

        public int nextIndex() {
            return nextIndex;
        }

        public int previousIndex() {
            return nextIndex - 1;
        }

        @Override
        public void remove() {
            //не реализовывал
        }

        @Override
        public void set(E e) {
            //не реализовывал
        }

        @Override
        public void add(E e) {
            //не реализовывал
        }

    }

}
