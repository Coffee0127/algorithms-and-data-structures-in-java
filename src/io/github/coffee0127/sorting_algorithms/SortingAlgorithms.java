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
package io.github.coffee0127.sorting_algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * SortingAlgorithms
 *
 * @author Bo-Xuan Fan
 * @since 2018-12-08
 */
public class SortingAlgorithms {

    private int[] array = new int[50];

    public SortingAlgorithms() {
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(101);
        }
    }

    public void selectionSort() {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // swap the min value
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[i]) {
                    // swap the bigger value
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
    }

    /**
     * <pre>
     * Array [86, 52, 71, 28, 85, 16, 46, 55, 52, 68]
     * "--" which means skip comparing during this loop
     * i = 0 [86, --, --, --, --, --, --, --, --, --]
     * index starts from 1 since i = 0 compares nothing
     * i = 1 [86, 52, --, --, --, --, --, --, --, --]
     *       [52, 86, --, --, --, --, --, --, --, --]
     * i = 2 [52, 86, 71, --, --, --, --, --, --, --]
     *       [52, 71, 86, --, --, --, --, --, --, --]
     * i = 3 [52, 71, 86, 28, --, --, --, --, --, --]
     *       [28, 52, 71, 86, --, --, --, --, --, --]
     * i = 4 [28, 52, 71, 86, 85, --, --, --, --, --]
     *       [28, 52, 71, 85, 86, --, --, --, --, --]
     * i = 5 [28, 52, 71, 85, 86, 16, --, --, --, --]
     *       [16, 28, 52, 71, 85, 86, --, --, --, --]
     * i = 6 [16, 28, 52, 71, 85, 86, 46, --, --, --]
     *       [16, 28, 46, 52, 71, 85, 86, --, --, --]
     * i = 7 [16, 28, 46, 52, 71, 85, 86, 55, --, --]
     *       [16, 28, 46, 52, 55, 71, 85, 86, --, --]
     * i = 8 [16, 28, 46, 52, 55, 71, 85, 86, 52, --]
     *       [16, 28, 46, 52, 52, 55, 71, 85, 86, --]
     * i = 9 [16, 28, 46, 52, 52, 55, 71, 85, 86, 68]
     *       [16, 28, 46, 52, 52, 55, 68, 71, 85, 86]
     * </pre>
     */
    public void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                // move the element rightward
                array[j + 1] = array[j];
                // minus index j for previous element
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
