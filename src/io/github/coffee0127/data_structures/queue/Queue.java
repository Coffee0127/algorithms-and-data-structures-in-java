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
package io.github.coffee0127.data_structures.queue;

import java.util.Arrays;

/**
 * Queue
 *
 * @author Bo-Xuan Fan
 * @since 2018-11-25
 */
public class Queue {

    private int size;
    private int[] array;
    private int front = 0;
    private int rear = 0;
    private int itemCount = 0;

    public Queue() {
        this(10);
    }

    public Queue(int size) {
        this.size = size;
        array = new int[size];
    }

    public int getItemCount() {
        return itemCount;
    }

    public int peek() {
        return array[front];
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public boolean isFull() {
        return itemCount == size;
    }

    public void setSize(int size) {
        this.size = size;
        array = new int[size];
    }

    public boolean enqueue(int data) {
        if (!isFull()) {
            array[rear++ % size] = data;
            itemCount++;
            return true;
        }
        return false;
    }

    public int dequeue() throws EmptyQueueException {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        int index = front % size;
        int data = array[index];
        array[index] = 0;

        if (front < rear) {
            front++;
        }

        if (itemCount > 0) {
            itemCount--;
        }

        return data;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
