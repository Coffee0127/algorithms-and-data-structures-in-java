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
package io.github.coffee0127.heap.array;

import java.util.Random;

/**
 * HeapArray
 *
 * @author Bo-Xuan Fan
 * @since 2018-12-02
 */
public class HeapArray {

    private int[] array;
    private int size;

    public HeapArray() {
        this(50);
    }

    public HeapArray(int size) {
        this.size = size;
        array = new int[size + 2];
        createArray(size);
    }

    private void createArray(int size) {
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int n = rand.nextInt(100) + 1;
            array[i + 1] = n;
        }
    }

    public void creatHeap() {
        int times = (int) Math.floor(Math.log10(size) / Math.log10(2));
        for (int time = 1; time <= times; time++) {
            for (int i = size / 2; i > 0; i--) {
                fixHeap(i);
            }
        }
    }

    private void fixHeap(int i) {
        int parent = array[i];
        int left = array[2 * i];
        int right = array[2 * i + 1];
        if (parent < left || parent < right) {
            // swap parent to left / right child
            array[i] = Math.max(left, right);
            if (array[i] == left) {
                array[2 * i] = parent;
            } else {
                array[2 * i + 1] = parent;
            }
        }
    }

    public void print() {
        for (int i = 1; i <= size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void printTree() {
        for (int i = 1, height = 1; i <= size; i++) {
            System.out.print(array[i] + " ");
            if ((Math.pow(2, height) - 1) == i) {
                height++;
                System.out.println();
            }
        }
        System.out.println();
    }
}
