package com.vc.collections.list.impl;

import com.vc.collections.list.List;
import com.vc.collections.model.Node;

public class LinkedList<T> implements List<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    @Override
    public T get(int index) {
        return getNode(index).getValue();
    }

    @Override
    public void add(T element) {
        if (size == 0) {
            first = new Node<>(null, element, null);
            last = first;
        } else {
            Node<T> secondLast = last;
            last = new Node<>(secondLast, element, null);
            secondLast.setNext(last);
        }
        size++;
    }

    @Override
    public void add(T element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size) {
            add(element);
            return;
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
    }

    @Override
    public boolean remove(T element) {
        Node<T> node = first;
        for (int i = 0; i < size; i++) {
            if (node.getValue().equals(element)) {
                return removeAt(i);
            }
            node = node.getNext();
        }
        return false;
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