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
package io.github.coffee0127.linkedlist;

import io.github.coffee0127.AbstractApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * AppLinkedList
 *
 * @author Bo-Xuan Fan
 * @since 2018-11-21
 */
public class AppLinkedList extends AbstractApplication {

    private List<String> list = new List<>("MyList");

    @FXML
    private Label eventShower;

    @FXML
    private TextField insertElement;

    @FXML
    private TextArea printList;

    @FXML
    private TextField index;

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private void insertAtFrontClick(ActionEvent event) {
        list.insertAtFront(insertElement.getText());
        eventShower.setText("Insert At Front");
        insertElement.setText(null);
    }

    @FXML
    private void insertAtBackClick(ActionEvent event) {
        list.insertAtBack(insertElement.getText());
        eventShower.setText("Insert At Back");
        insertElement.setText(null);
    }

    @FXML
    private void insertAt(ActionEvent event) {
        list.insertAt(insertElement.getText(), Integer.parseInt(index.getText()));
        eventShower.setText("Insert At");
        insertElement.setText(null);
    }

    @FXML
    private void randomListClick(ActionEvent event) {
        for (int i = 0; i < 10; i++) {
            list.insertAtBack(String.valueOf(Math.round(Math.random() * 100)));
        }
    }

    @FXML
    private void removeFromFrontClick(ActionEvent event) {
        try {
            printList.setText("Removed: " + list.removeFromFront());
        } catch (EmptyListException e) {
            printList.setText(e.getMessage());
        }
    }

    @FXML
    private void removeFromBackClick(ActionEvent event) {
        try {
            printList.setText("Removed: " + list.removeFromBack());
        } catch (EmptyListException e) {
            printList.setText(e.getMessage());
        }
    }

    @FXML
    private void removeAllClick(ActionEvent event) {
        list.removeAll();
    }

    @FXML
    private void printTheListClick(ActionEvent event) {
        printList.setText(list.print());
    }

    @FXML
    private void getElementAtClick(ActionEvent event) {
        if (isBlank(index.getText())) {
            eventShower.setText("No index.");
            return;
        }

        eventShower.setText(list.printElementAt(Integer.parseInt(index.getText())));
    }

    @FXML
    private void removeAtClick(ActionEvent event) {
        if (isBlank(index.getText())) {
            eventShower.setText("No index.");
            return;
        }

        eventShower.setText("remove success:" + list.deleteNode(Integer.parseInt(index.getText())));
    }

    @Override
    protected String getAppTitle() {
        return "LinkedList";
    }

    @Override
    protected String getResourceName() {
        return "AppLinkedList.fxml";
    }

}
