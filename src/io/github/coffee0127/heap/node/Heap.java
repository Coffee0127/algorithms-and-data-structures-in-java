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
package io.github.coffee0127.heap.node;

/**
 * Heap
 *
 * @author Bo-Xuan Fan
 * @since 2018-12-05
 */
public class Heap {

    private HeapNode node;

    public void addNode(int value) {
        HeapNode prev = null;
        HeapNode tmp = node;

        HeapNode current = new HeapNode(value);

        while (tmp != null) {
            prev = tmp;

            if (value < tmp.getValue()) {
                tmp = tmp.getLeft();
            } else if (value > tmp.getValue()) {
                tmp = tmp.getRight();
            } else if (value == tmp.getValue()) {
                tmp = current;
            }
        }

        if (prev == null) {
            node = current;
        } else if (value < prev.getValue()) {
            prev.setLeft(current);
        } else if (value > prev.getValue()) {
            prev.setRight(current);
        }
    }

    public HeapNode minValueNode(HeapNode node) {
        HeapNode current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }

        return current;
    }

    public HeapNode deleteNode(HeapNode node, int value) {
        // delete nothing
        if (node == null) {
            return null;
        }

        if (value < node.getValue()) {
            // search the left subtree
            node.setLeft(deleteNode(node.getLeft(), value));
        } else if (value > node.getValue()) {
            // search the right subtree
            node.setRight(deleteNode(node.getRight(), value));
        } else {
            // delete the node
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            // delete node with two children
            HeapNode tmp = minValueNode(node.getRight());
            node.setValue(tmp.getValue());
            node.setRight(deleteNode(node.getRight(), tmp.getValue()));
        }

        return node;
    }

    public HeapNode getHeapNode() {
        return node;
    }

    /**
     * root -> left -> right
     */
    public void preOrderPrint(HeapNode node) {
        if (node != null) {
            System.out.println(node.getValue());
            preOrderPrint(node.getLeft());
            preOrderPrint(node.getRight());
        }
    }

    /**
     * left -> root -> right
     */
    public void inOrderPrint(HeapNode node) {
        if (node != null) {
            inOrderPrint(node.getLeft());
            System.out.println(node.getValue());
            inOrderPrint(node.getRight());
        }
    }

    /**
     * left -> right -> root
     */
    public void postOrderPrint(HeapNode node) {
        if (node != null) {
            postOrderPrint(node.getLeft());
            postOrderPrint(node.getRight());
            System.out.println(node.getValue());
        }
    }

}
