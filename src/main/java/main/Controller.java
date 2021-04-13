package main;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import logic.Logic;
import logic.Point;

import java.util.List;
import java.util.stream.Collectors;

public class Controller {

    private Logic logic;

    @FXML private TableColumn<Point, Double> xColumn;
    @FXML private TableColumn<Point, Double> yColumn;
    @FXML private TableView<Point> tableXY;

    @FXML
    private TextField startField;

    @FXML
    private TextField finishField;

    @FXML
    private TextField stepField;

    public void initialize() {
        logic = new Logic();
        xColumn.setCellValueFactory(new PropertyValueFactory<>("x"));
        yColumn.setCellValueFactory(new PropertyValueFactory<>("y"));
    }

    public void calculate() {
        double start = Double.parseDouble(startField.getText());
        double finish = Double.parseDouble(finishField.getText());
        double step = Double.parseDouble(stepField.getText());
        List<Point> points = logic.tabulate(start, finish, step, x -> Math.sqrt(x) * 7);
        //textArea.setText(points.stream().map(Point::toString).collect(Collectors.joining("\n")));
        tableXY.setItems(FXCollections.observableList(points));
    }

    public void about() {
        Alert.AlertType alertAlertType;
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("О программе");
        alert.setHeaderText("Здесь какая-то краткая информация");  // alert.setHeaderText(null);
        alert.setContentText("Здесь полная информация о программе");
        alert.show();
    }
}
