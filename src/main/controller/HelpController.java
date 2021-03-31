package controller;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.OperationHelpEntry;

import java.util.List;
public class HelpController
{
    public TableView<OperationHelpEntry> tvOperationDescription = new TableView<>();
    public TableColumn<OperationHelpEntry, String> clmOperation = new TableColumn<>("Operation");
    public TableColumn<OperationHelpEntry, String> clmDescription = new TableColumn<>("Description");
    public TableColumn<OperationHelpEntry, String> clmExample = new TableColumn<>("Example");

    public HelpController(){
        List<OperationHelpEntry> operationHelpEntries = List.of(
                new OperationHelpEntry("+", "Addition", "1 + 2 = 3")
        );

        ObservableList<OperationHelpEntry> entries = FXCollections.observableArrayList(operationHelpEntries);

        clmOperation.setCellValueFactory(new PropertyValueFactory<>("Operation"));
        clmDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        clmExample.setCellValueFactory(new PropertyValueFactory<>("Example"));

        tvOperationDescription.setItems(entries);

        tvOperationDescription.refresh();
    }



}
