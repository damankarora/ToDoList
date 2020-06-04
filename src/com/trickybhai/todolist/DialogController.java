package com.trickybhai.todolist;

import com.trickybhai.todolist.datamodel.TodoData;
import com.trickybhai.todolist.datamodel.Todoitems;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public void processResults(){
        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadLine = deadlinePicker.getValue();

        TodoData.getInstance().addTodoItem(new Todoitems(shortDescription, details, deadLine));
    }
}
