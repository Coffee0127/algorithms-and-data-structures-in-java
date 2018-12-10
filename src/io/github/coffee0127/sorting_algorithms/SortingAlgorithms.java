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

    /**
     * <pre>
     * Array ----------------------------- [66,  83,  53,  39,  63]
     * mergeSort(0, 4)
     * |----- mergeSort(0, 2)              [66,  83,  53]
     * |    |----- mergeSort(0, 1)         [66,  83]
     * |    |      |----- mergeSort(0, 0)  ------ do nothing ------
     * |    |      |----- mergeSort(1, 1)  ------ do nothing ------
     * |    |      '----- merge(0, 0, 1)   L[66] R[83]
     * |    |                              => [66,   ]              copy from L
     * |    |                              => [66, 83]              copy the remaining elements from R
     * |    |----- mergeSort(2, 2)         ------ do nothing ------
     * |    '----- merge(0, 1, 2)          L[66, 83] R[53]
     * |                                   => [53,    ,    ]        copy from R
     * |                                   => [53,  66,  83]        copy the remaining elements from L
     * |----- mergeSort(3, 4)                            [39,  63]
     * |    |----- mergeSort(3, 3)         ------ do nothing ------
     * |    |----- mergeSort(4, 4)         ------ do nothing ------
     * |    '----- merge(3, 3, 4)          L[39] R[63]
     * |                                   => [39,   ]              copy from L
     * |                                   => [39, 63]              copy the remaining elements from R
     * '----- merge(0, 2, 4)               L[53, 66, 83] R[39, 63]
     *                                     => [39,   ,   ,   ,   ]  copy from R
     *                                     => [39, 53,   ,   ,   ]  copy from L
     *                                     => [39, 53, 63,   ,   ]  copy from R
     *                                     => [39, 53, 63, 66, 83]  copy the remaining elements from L
     * </pre>>
     */
    public void mergeSort() {
        mergeSort(0, array.length - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(left, middle);
            mergeSort(middle + 1, right);
            merge(left, middle, right);
        }
    }

    private void merge(int left, int middle, int right) {
        int leftArrayLength = middle - left + 1;
        int rightArrayLength = right - middle;
        int[] leftArray = new int[leftArrayLength];
        int[] rightArray = new int[rightArrayLength];

        for (int leftArrayIndex = 0; leftArrayIndex < leftArrayLength; leftArrayIndex++) {
            leftArray[leftArrayIndex] = array[left + leftArrayIndex];
        }
        for (int rightArrayIndex = 0; rightArrayIndex < rightArrayLength; rightArrayIndex++) {
            rightArray[rightArrayIndex] = array[middle + 1 + rightArrayIndex];
        }

        int leftArrayIndex = 0;
        int rightArrayIndex = 0;
        int index = left;
        // get the smaller number from leftArray or rightArray
        while (leftArrayIndex < leftArrayLength && rightArrayIndex < rightArrayLength) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                array[index] = leftArray[leftArrayIndex];
                leftArrayIndex++;
            } else {
                array[index] = rightArray[rightArrayIndex];
                rightArrayIndex++;
            }
            index++;
        }

        // copy the remaining elements from leftArray, then rightArray
        while (leftArrayIndex < leftArrayLength) {
            array[index] = leftArray[leftArrayIndex];
            leftArrayIndex++;
            index++;
        }
        while (rightArrayIndex < rightArrayLength) {
            array[index] = rightArray[rightArrayIndex];
            rightArrayIndex++;
            index++;
        }
    }

    /**
     * Array [66, 83, 53, 39, 63]
     * quickSort(0, 4)
     * |-- partition(0, 4)             pivot = 63
     * |                              |          |            |       |         array
     * |                            j |  result  |   action   | index | [66, 83, 53, 39, 63]
     * |                           ---|----------|------------|-------|----------------------
     * |                            0 | 66 >  63 | do nothing |   0   |          --
     * |                            1 | 83 >  63 | do nothing |   0   |          --
     * |                            2 | 53 <= 63 |    swap    |   1   | [53, **, 66, **, **]
     * |                            3 | 39 <= 63 |    swap    |   2   | [**, 39, **, 83, **]
     * |                                                            ==> [53, 39, 66, 83, 63]
     * |                                                            ==> [53, 39, 63, 83, 66]  // swap arr[index] and pivot
     * |                                                            ==> partitionIndex = 2
     * |-- quickSort(0, 1)
     * |    |-- partition(0, 1)        pivot = 39
     * |    |                         |          |            |       |         array
     * |    |                       j |  result  |   action   | index | [53, 39, **, **, **]
     * |    |                      ---|----------|------------|-------|----------------------
     * |    |                       0 | 53 >  39 | do nothing |   0   | [53, 39, **, **, **]
     * |    |                                                       ==> [53, 39, 63, 83, 66]
     * |    |                                                       ==> [39, 53, 63, 83, 66]  // swap arr[index] and pivot
     * |    |                                                       ==> partitionIndex = 0
     * |    |-- quickSort(0, -1)   do nothing
     * |    '-- quickSort(1, 1)    do nothing
     * '-- quickSort(3, 4)
     *      |-- partition(3, 4)        pivot = 66
     *      |                         |          |            |       |         array
     *      |                       j |  result  |   action   | index | [**, **, **, 83, 66]
     *      |                      ---|----------|------------|-------|----------------------
     *      |                       3 | 83 >  66 | do nothing |   0   | [**, **, **, 83, 66]
     *      |                                                       ==> [39, 53, 63, 83, 66]
     *      |                                                       ==> [39, 53, 63, 66, 83]  // swap arr[index] and pivot
     *      |                                                       ==> partitionIndex = 0
     *      |-- quickSort(3, 2)    do nothing
     *      '-- quickSort(4, 4)    do nothing
     */
    public void quickSort() {
        quickSort(0, array.length - 1, 1);
    }

    private void quickSort(int low, int high, int times) {
        if (low < high) {
            int partitionIndex = partition(low, high);

            // recursively sort elements before partition and after partition
            quickSort(low, partitionIndex - 1, times + 1);
            quickSort(partitionIndex + 1, high, times + 1);
        }
    }

    private int partition(int low, int high) {
        int pivot = array[high];
        int index = low;

        for (int j = low; j < high; j++) {
            // swap elements if current element is smaller than or equal to pivot
            if (array[j] <= pivot) {
                int temp = array[index];
                array[index] = array[j];
                array[j] = temp;
                index++;
            }
        }

        // swap arr[index] and arr[high] (i.e. pivot)
        int temp = array[index];
        array[index] = array[high];
        array[high] = temp;
        return index;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

}
