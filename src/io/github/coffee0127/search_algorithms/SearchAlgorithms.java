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
package io.github.coffee0127.search_algorithms;

import java.util.Arrays;

/**
 * SearchAlgorithms
 *
 * @author Bo-Xuan Fan
 * @since 2018-12-11
 */
public class SearchAlgorithms {

    private int[] array;

    public void initializeArray(int n) {
        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * i;
        }
    }

    @Override
    public String toString() {
        return "Array : " + Arrays.toString(array);
    }

    public String linearSearch(int number) {
        boolean isFound = false;

        long start = System.nanoTime();
        for (int i : array) {
            if (number == i) {
                isFound = true;
                break;
            }
        }

        long elapsedTime = System.nanoTime() - start;
        String result;
        if (isFound) {
            result = "The number was found!";
        } else {
            result = "The number was not found...";
        }
        return result + "\nThe time it takes the function to complete: " + elapsedTime + " nano seconds";
    }

}
