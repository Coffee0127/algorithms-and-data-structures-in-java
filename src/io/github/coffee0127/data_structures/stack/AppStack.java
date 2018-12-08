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

import java.util.Random;

import io.github.coffee0127.AbstractApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * AppStack
 *
 * @author Bo-Xuan Fan
 * @since 2018-11-25
 */
public class AppStack extends AbstractApplication {

    @FXML
    private TextArea textArea;

    private Stack stack = new Stack(10);

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void pushElement(ActionEvent event) {
        Random random = new Random();
        int n = random.nextInt(50) + 1;

        if (stack.push(n)) {
            textArea.setText("Array: \n" + stack.toString()
                + "\nThe number of element is : " + stack.getItemCount());
        } else {
            textArea.setText("Array: \n" + stack.toString()
                + "\nThe number of element is : " + stack.getItemCount()
                + "\nCould not insert data, stack is full");
        }
    }

    @FXML
    private void popElement(ActionEvent event) {
        if (stack.pop()) {
            textArea.setText("Array: \n" + stack.toString()
                + "\nThe number of element is : " + stack.getItemCount());
        } else {
            textArea.setText("Array: \n" + stack.toString()
                + "\nThe number of element is : " + stack.getItemCount()
                + "\nCould not retrieve data, stack is empty");
        }
    }

    @FXML
    private void peekElement(ActionEvent event) {
        textArea.setText("Array: \n" + stack.toString()
            + "\nThe number of element is : " + stack.getItemCount()
            + "\nThe top element is : " + stack.peek());
    }

    @Override
    protected String getAppTitle() {
        return "Stack";
    }

    @Override
    protected String getResourceName() {
        return "AppStack.fxml";
    }
}
