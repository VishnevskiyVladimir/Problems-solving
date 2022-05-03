package vladilen.linked_list;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);

        if (size == 0) {
            last = newNode;
        } else {
            newNode.setNext(first);
            first.setPrev(newNode);
        }
        first = newNode;
        size++;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<>(element);

        if (size == 0) {
            first = newNode;
        } else {
            newNode.setPrev(last);
            last.setNext(newNode);
        }
        last = newNode;
        size++;
    }

    public void removeFirst() {
        if(size == 0) {
            throw new NoSuchElementException();
        } else if (size == 1) {
            last = null;
            first = null;
        } else {
            Node<E> second = first.next;
            first.next = null;
            second.prev = null;
            first = second;
        }
        size--;
    }

    public void removeLast() {
        if(size == 0){
            throw new NoSuchElementException();
        } else if(size == 1) {
            last = null;
            first = null;
        } else {
            Node<E> preLast = last.prev;
            last.prev = null;
            preLast.next = null;
            last = preLast;
        }
        size--;
    }

    public E getFirst() {
        if(size == 0)
            throw new NoSuchElementException();
        return first.element;
    }

    public E getLast() {
        if(size == 0)
            throw new NoSuchElementException();
        return last.element;
    }

    public E get(long index) {

        checkIndex(index);
        Node<E> curNode;

        if (index <= size / 2) {
            curNode = first;
            for (long i = 0; i < index; i++)
                curNode = curNode.getNext();
        } else {
            curNode = last;
            for (long i = (size - 1L); i > index; i--)
                curNode = curNode.getPrev();
        }

        return curNode.getElement();
    }

    private void checkIndex(long index) {
        if (!(index < size && index >= 0))
            throw new IndexOutOfBoundsException("index=" + index);
    }

    public int getSize() {
        return size;
    }


    @Getter
    @Setter
    @NoArgsConstructor
    private static class Node<E> {
        E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E element) {
            this.element = element;
        }
    }
}



