/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2018 Bo-Xuan Fan
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.coffee0127.data_structures.linkedlist;

/**
 * List
 *
 * @author Bo-Xuan Fan
 * @since 2018-11-21
 */
public class List<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private String name;

    public List() {
        this("List");
    }

    public List(String name) {
        this.name = name;
    }

    public boolean isEmpty() {
        return firstNode == null;
    }

    public void insertAtFront(T item) {
        if (isEmpty()) {
            firstNode = new Node<>(item);
            lastNode = firstNode;
        } else {
            firstNode = new Node<>(item, firstNode);
        }
    }

    public void insertAtBack(T item) {
        if (isEmpty()) {
            firstNode = new Node<>(item);
            lastNode = firstNode;
        } else {
            lastNode.nextNode = new Node<>(item);
            lastNode = lastNode.nextNode;
        }
    }

    public void insertAt(T item, int index) {
        if (isEmpty()) {
            insertAtFront(item);
        } else {
            if (index == 1) {
                insertAtFront(item);
                return;
            }

            int number = 1;
            Node<T> current = firstNode;
            Node<T> prev = current;
            while (number++ != index) {
                prev = current;
                current = current.nextNode;
            }
            prev.nextNode = new Node<>(item, current);
        }
    }

    public String print() {
        if (isEmpty()) {
            return "Empty " + name + " List";
        }

        StringBuilder str = new StringBuilder("The " + name + " is : \n");
        Node<T> current = firstNode;
        while (current != null) {
            str.append(current.getData()).append("\n");
            current = current.getNextNode();
        }

        str.append("End ").append(name);
        return str.toString();
    }

    public void removeAll() {
        firstNode = null;
        lastNode = null;
    }

    public T removeFromFront() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException(name);
        }

        T removedItem = firstNode.getData();

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            firstNode = firstNode.nextNode;
        }

        return removedItem;
    }

    public T removeFromBack() throws EmptyListException {
        if (isEmpty()) {
            throw new EmptyListException(name);
        }

        T removedItem = lastNode.getData();

        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            Node<T> current = firstNode;
            while (current.getNextNode() != lastNode) {
                current = current.getNextNode();
            }
            lastNode = current;
            current.setNextNode(null);
        }

        return removedItem;
    }

    public String printElementAt(int index) {
        int number = 1;
        if (isEmpty()) {
            return "Empty " + name;
        }

        StringBuilder str = new StringBuilder("The Node at " + index + " is : ");

        Node<T> current = firstNode;
        while (current != null) {
            if (number == index) {
                str.append(current.getData());
                break;
            }
            number++;
            current = current.nextNode;
        }

        return str.toString();
    }

    public boolean deleteNode(int index) {
        if (isEmpty()) {
            return false;
        }

        if (index == 1) {
            firstNode = firstNode.nextNode;
            return true;
        }

        int number = 1;
        Node<T> current = firstNode;
        Node<T> prev = current;

        while (current != null) {
            if (number == index) {
                prev.nextNode = current.nextNode;
                return true;
            }
            number++;
            prev = current;
            current = current.nextNode;
        }
        return false;
    }
}
