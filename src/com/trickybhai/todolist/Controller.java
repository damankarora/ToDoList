package com.trickybhai.todolist;

import com.trickybhai.todolist.datamodel.Todoitems;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<Todoitems> todoitemsList;
    @FXML
    private ListView<Todoitems> todoListView;

    @FXML
    private TextArea itemDetailTextArea;
    @FXML
    private Label dateLabel;

    public void initialize() {
        Todoitems item1 = new Todoitems("Mail birthday card",
                "Buy a birthday card for aisha", LocalDate.of(2020, Month.AUGUST, 26));
        Todoitems item2 = new Todoitems("Doctor's appointment",
                "See doctor in the clinic", LocalDate.of(2020, Month.SEPTEMBER, 26));
        Todoitems item3 = new Todoitems("Finish design proposal of client",
                "Compose an email to mike about the designs", LocalDate.of(2020, Month.AUGUST, 27));
        Todoitems item4 = new Todoitems("Pickup heena from station",
                "Heena is arriving on Ludhina junction", LocalDate.of(2020, Month.MARCH, 26));
        Todoitems item5 = new Todoitems("Pickup dry cleaning",
                "Pickup clothes from downtown", LocalDate.of(2020, Month.APRIL, 26));

        todoitemsList = new ArrayList<>();
        todoitemsList.add(item1);
        todoitemsList.add(item2);
        todoitemsList.add(item3);
        todoitemsList.add(item4);
        todoitemsList.add(item5);

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Todoitems>() {
            @Override
            public void changed(ObservableValue<? extends Todoitems> observableValue, Todoitems todoitems, Todoitems t1) {
                if (t1!=null){
                    Todoitems item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    dateLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        todoListView.getItems().setAll(todoitemsList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();


    }
    @FXML
    public void handleClickListView(){
        Todoitems todoitems = todoListView.getSelectionModel().getSelectedItem();
//        System.out.println("The selected item is "+todoitems);
        dateLabel.setText(todoitems.getDeadline().toString());
        itemDetailTextArea.setText(todoitems.getDetails());

    }
}