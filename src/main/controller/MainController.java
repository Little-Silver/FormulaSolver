package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logic.Expression;
import logic.exceptions.ArityException;
import logic.exceptions.EvaluationException;
import logic.exceptions.ImproperParenthesesException;
import model.FormulaModel;

import java.io.IOException;

/**
 * @author Pascal Isliker
 */
public class MainController
{

    public Label     lblFormulaResolved;
    public Button    btCalculate;
    public TextField tfFormRight;
    public TextField tfFormLeft;
    public Label     lblEquals;
    public ListView<String> lvHistory;

    Expression expression;

    public void onBtCalculateClick(MouseEvent mouseEvent)
    {
        System.out.println("Calculation: ");

        FormulaModel formulaTuple = new FormulaModel(tfFormLeft.getText(),tfFormRight.getText());
        expression = new Expression(formulaTuple);
        System.out.println(expression.getExpression().getOriginalExpression());

        try {
            String expressionSolution = expression.evaluate().toString();
            ObservableList<String> items = FXCollections.observableArrayList(expression.getExpression().getTokenListHistory());
            items.add(formulaTuple.getTokenListRight().toString().replaceAll("\\[|\\]|,", ""));
            lvHistory.setItems(items);

            System.out.println(expressionSolution);
            lblFormulaResolved.setText(expressionSolution);
        } catch (ArityException | EvaluationException | ImproperParenthesesException e) {
            System.out.println("ERROR");
        }
    }

    public void keyReleasedF1(KeyEvent keyEvent) throws IOException
    {
        if (keyEvent.getCode().equals(KeyCode.F1)) {
            Parent helpRoot  = FXMLLoader.load(getClass().getResource("/resources/Help.fxml"));

            Scene  scene = new Scene(helpRoot, 800, 400);
            scene.getStylesheets().add("/resources/DefaultStyles.css");

            //Stage - Window
            Stage helpWindow = new Stage();
            helpWindow.setX(100);
            helpWindow.setY(100);
            helpWindow.setTitle("Help");
            helpWindow.initModality(Modality.NONE);
            helpWindow.setScene(scene);
            helpWindow.show();
        }
    }
}
