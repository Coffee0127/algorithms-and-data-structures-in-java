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
package io.github.coffee0127.data_structures.stack;

import java.util.Arrays;

/**
 * Stack
 *
 * @author Bo-Xuan Fan
 * @since 2018-11-25
 */
public class Stack {

    private int size;
    private int[] stack;
    private int top = -1;

    public Stack() {
        this(10);
    }

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
    }

    public int getItemCount() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return (top + 1) == size;
    }

    public int peek() {
        if (isEmpty()) {
            return 0;
        }
        return stack[top];
    }

    public boolean pop() {
        if (!isEmpty()) {
            stack[top--] = 0;
            return true;
        }
        return false;
    }

    public boolean push(int data) {
        if (!isFull()) {
            stack[++top] = data;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(stack);
    }

}
