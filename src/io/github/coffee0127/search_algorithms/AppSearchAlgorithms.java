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

import io.github.coffee0127.AbstractApplication;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * AppSearchAlgorithms
 *
 * @author Bo-Xuan Fan
 * @since 2018-12-11
 */
public class AppSearchAlgorithms extends AbstractApplication {

    private SearchAlgorithms algorithms = new SearchAlgorithms();

    @FXML
    private TextField size;
    @FXML
    private TextField num;
    @FXML
    private Label array;
    @FXML
    private TextArea print;

    public void setSize() {
        int size = Integer.parseInt(this.size.getText());
        algorithms.initializeArray(size);
        array.setText(algorithms.toString());
    }

    public void linearSearch() {
        int num = Integer.parseInt(this.num.getText());
        print.setText(algorithms.linearSearch(num));
    }

    public void binarySearch() {
        int num = Integer.parseInt(this.num.getText());
        print.setText(algorithms.binarySearch(num));
    }

    @Override
    protected String getAppTitle() {
        return "Linear SearchAlgorithms";
    }

    @Override
    protected String getResourceName() {
        return "AppSearchAlgorithms.fxml";
    }
}
