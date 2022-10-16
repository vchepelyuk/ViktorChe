package com.vc.collections.list.impl;

import com.vc.collections.list.List;
import com.vc.collections.list.Queue;
import com.vc.collections.model.Node;

public class LinkedList<T> implements List<T>, Queue<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    @Override
    public T peek() {
        if (size > 0) {
            return get(0);
        } else {
            return null;
        }
    }

    @Override
    public T poll() {
        T element = get(0);
        removeAt(0);
        return element;
    }

    @Override
    public T get(int index) {
        return getNode(index).getValue();
    }

    @Override
    public boolean add(T element) {
        if (size == 0) {
            first = new Node<>(null, element, null);
            last = first;
        } else {
            Node<T> secondLast = last;
            last = new Node<>(secondLast, element, null);
            secondLast.setNext(last);
        }
        size++;
        return true;
    }

    @Override
    public boolean add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
           return add(element);

        }
        Node<T> nodeNext = getNode(index);
        Node<T> nodePrev = nodeNext.getPrevious();
        Node<T> newNode = new Node<>(nodePrev, element, nodeNext);
        nodeNext.setPrevious(newNode);
        if (nodePrev != null) {
            nodePrev.setNext(newNode);
        } else {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(T element) {
        int index = findElement(element);
        if (index != -1) {
            return removeAt(index);
        }
        return false;
    }

    @Override
    public boolean contains(T element) {
        int index = findElement(element);
        return index != -1;
    }

    @Override
    public boolean removeAt(int index) {
        Node<T> node = getNode(index);
        Node<T> nodeNext = node.getNext();
        Node<T> nodePrev = node.getPrevious();
        if (nodeNext != null) {
            nodeNext.setPrevious(nodePrev);
        } else {
            last = nodePrev;
        }
        if (nodePrev != null) {
            nodePrev.setNext(nodeNext);
        } else {
            first = nodeNext;
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    private int findElement(T element) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (node.getValue().equals(element)) {
                return i;
            }
            node = node.getNext();
        }
        return -1;
    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }
}