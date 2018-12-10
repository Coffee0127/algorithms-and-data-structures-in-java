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

import io.github.coffee0127.AbstractApplication;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * AppSortingAlgorithms
 *
 * @author Bo-Xuan Fan
 * @since 2018-11-25
 */
public class AppSortingAlgorithms extends AbstractApplication {

    @FXML
    private TextArea textArea;

    private SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void selectionSort() {
        long start = System.nanoTime();
        sortingAlgorithms.selectionSort();
        long elapsedTime = System.nanoTime() - start;
        textArea.setText("Selection Sort\nTime : " + elapsedTime + " nano seconds.");
    }

    @FXML
    private void bubbleSort() {
        long start = System.nanoTime();
        sortingAlgorithms.bubbleSort();
        long elapsedTime = System.nanoTime() - start;
        textArea.setText("Bubble Sort\nTime : " + elapsedTime + " nano seconds.");
    }

    @FXML
    private void insertionSort() {
        long start = System.nanoTime();
        sortingAlgorithms.insertionSort();
        long elapsedTime = System.nanoTime() - start;
        textArea.setText("Insertion Sort\nTime : " + elapsedTime + " nano seconds.");
    }

    @FXML
    private void mergeSort() {
        long start = System.nanoTime();
        sortingAlgorithms.mergeSort();
        long elapsedTime = System.nanoTime() - start;
        textArea.setText("Merge Sort\nTime : " + elapsedTime + " nano seconds.");
    }

    @FXML
    private void quickSort() {
        long start = System.nanoTime();
        sortingAlgorithms.quickSort();
        long elapsedTime = System.nanoTime() - start;
        textArea.setText("Quick Sort\nTime : " + elapsedTime + " nano seconds.");
    }

    @FXML
    private void newArrays() {
        sortingAlgorithms.newArrays();
        textArea.setText("Arrays were reset to\n" + sortingAlgorithms.toString());
    }

    @FXML
    private void allSort() {
        String originalArray = sortingAlgorithms.toString();

        long start1 = System.nanoTime();
        sortingAlgorithms.selectionSort();
        long elapsedTime1 = System.nanoTime() - start1;

        long start2 = System.nanoTime();
        sortingAlgorithms.bubbleSort();
        long elapsedTime2 = System.nanoTime() - start2;

        long start3 = System.nanoTime();
        sortingAlgorithms.insertionSort();
        long elapsedTime3 = System.nanoTime() - start3;

        long start4 = System.nanoTime();
        sortingAlgorithms.mergeSort();
        long elapsedTime4 = System.nanoTime() - start4;

        long start5 = System.nanoTime();
        sortingAlgorithms.quickSort();
        long elapsedTime5 = System.nanoTime() - start5;

        textArea.setText("Sorting Array " + originalArray + "\n"
         + "Selection Sort\nTime : " + elapsedTime1 + " nano seconds.\n"
         + "Bubble Sort\nTime : " + elapsedTime2 + " nano seconds.\n"
         + "Insertion Sort\nTime : " + elapsedTime3 + " nano seconds.\n"
         + "Merge Sort\nTime : " + elapsedTime4 + " nano seconds.\n"
         + "Quick Sort\nTime : " + elapsedTime5 + " nano seconds.");
    }

    @Override
    protected String getAppTitle() {
        return "Sorting Algorithms";
    }

    @Override
    protected String getResourceName() {
        return "AppSortingAlgorithms.fxml";
    }
}
