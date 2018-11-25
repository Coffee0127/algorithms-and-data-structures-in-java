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
package io.github.coffee0127.queue;

import java.util.Random;

import io.github.coffee0127.AbstractApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

/**
 * AppQueue
 *
 * @author Bo-Xuan Fan
 * @since 2018-11-25
 */
public class AppQueue extends AbstractApplication {

    private Queue queue = new Queue(10);

    @FXML
    private TextArea textArea;

    @FXML
    private void enqueueElement(ActionEvent event) {
        Random random = new Random();
        int n = random.nextInt(50) + 1;

        if (queue.enqueue(n)) {
            textArea.setText("Queue: \n" + queue.toString()
                + "\nThe number of element is : " + queue.getItemCount());
        } else {
            textArea.setText("Queue: \n" + queue.toString()
                + "\nThe number of element is : " + queue.getItemCount()
                + "\nCould not insert data, queue is full");
        }
    }

    @FXML
    private void dequeueElement(ActionEvent event) {
        try {
            int dequeue = queue.dequeue();
            textArea.setText("Queue: \n" + queue.toString()
                + "\nThe number of element is : " + queue.getItemCount()
                + "\nDequeue data is : " + dequeue);
        } catch (EmptyQueueException e) {
            textArea.setText("Queue is empty!");
        }
    }

    @FXML
    public void peekElement(ActionEvent actionEvent) {
        textArea.setText("Queue: \n" + queue.toString()
            + "\nThe number of element is : " + queue.getItemCount()
            + "\nPeek data is : " + queue.peek());
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected String getAppTitle() {
        return "Queue";
    }

    @Override
    protected String getResourceName() {
        return "AppQueue.fxml";
    }
}
