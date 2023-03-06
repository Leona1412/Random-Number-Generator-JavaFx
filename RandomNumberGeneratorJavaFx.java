package com.example.localtime;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.io.IOException;

public class RandomNumberGeneratorJavaFx extends Application {
    private Button buttonGenerate = new Button("Generate");
    private Button buttonClear = new Button("Clear");
    private Label resultLabel = new Label();
    private Label errorLabelLowerLargerUpper = new Label();
    private Label errorLabelLowerTextfield = new Label();
    private Label errorLabelUpperTextfield = new Label();
    private TextField lowerLimitTextfield = new TextField();
    private TextField upperLimitTextfield = new TextField();
    private GridPane gridPane = new GridPane();

    @Override
    public void start(Stage stage) throws IOException {
        headingLabel();
        lowerLimitLabel();
        upperLimitLabel();
        lowerLimitTextfield();
        upperLimitTextfield();
        addButtonstoGrid();

        buttonGenerateAction();
        buttonClearAction();
        gridPane.add(resultLabel, 2, 10, 2, 2);
        gridPaneDesignSettings();
        Scene scene = new Scene(gridPane, 550, 360);
        stage.setTitle("Random Number Gemerator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void gridPaneDesignSettings() {
        gridPane.setGridLinesVisible(false);
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setPadding(new Insets(40));

        // Set the horizontal gap between columns
        gridPane.setHgap(10);

        // Set the vertical gap between rows
        gridPane.setVgap(10);
    }

    public void headingLabel() {
        Label topLabel = new Label("Let's generate a random number!");
        topLabel.setFont(new Font(19));
        topLabel.setTextAlignment(TextAlignment.CENTER);
        gridPane.add(topLabel, 1, 0, 2, 1);
        GridPane.setMargin(topLabel, new Insets(20, 0, 20, 0));
    }

    public void lowerLimitLabel() {
        Label lowerLimitLabel = new Label("Lower Limit");
        lowerLimitLabel.setFont(new Font(15));
        gridPane.add(lowerLimitLabel, 1, 2, 1, 1);
    }

    public void upperLimitLabel() {
        Label upperLimitLabel = new Label("Upper Limit");
        upperLimitLabel.setFont(new Font(15));
        gridPane.add(upperLimitLabel, 1, 5, 1, 1);
    }

    public void lowerLimitTextfield() {
        lowerLimitTextfield.setMaxSize(100, 2);
        gridPane.add(lowerLimitTextfield, 2, 2, 2, 2);
    }

    public void upperLimitTextfield() {
        upperLimitTextfield.setMaxSize(100, 2);
        gridPane.add(upperLimitTextfield, 2, 5, 2, 2);
    }

    public void addButtonstoGrid() {
        gridPane.add(buttonGenerate, 1, 8);
        gridPane.add(buttonClear, 2, 8);
    }

    public void buttonGenerateAction() {

        buttonGenerate.setOnAction(e -> {

            boolean isValidInput = false;
            boolean islowerLimitErrorLabelShown = false;
            boolean isUpperLimitErrorLabelShown = false;

            if (lowerLimitTextfield.getText().isEmpty()) {
                errorLabelLowerTextfield = labelErrorTextfield();
                gridPane.add(errorLabelLowerTextfield, 3, 2, 2, 2);
                islowerLimitErrorLabelShown = true;
            }
            if (upperLimitTextfield.getText().isEmpty()) {
                errorLabelUpperTextfield = labelErrorTextfield();
                gridPane.add(errorLabelUpperTextfield, 3, 5, 2, 2);
                isUpperLimitErrorLabelShown = true;
            }

            if (isValidTextfieldInput(upperLimitTextfield.getText()) && isValidTextfieldInput(lowerLimitTextfield.getText())) {
                isValidInput = true;
            } else if (!isValidTextfieldInput(lowerLimitTextfield.getText())) {
                if (!islowerLimitErrorLabelShown) {
                    errorLabelLowerTextfield = labelErrorTextfield();
                    gridPane.add(errorLabelLowerTextfield, 3, 2, 2, 2);
                    islowerLimitErrorLabelShown = true;
                }
            }
            if (!isValidTextfieldInput(upperLimitTextfield.getText()) && !isUpperLimitErrorLabelShown) {
                errorLabelUpperTextfield = labelErrorTextfield();
                gridPane.add(errorLabelUpperTextfield, 3, 5, 2, 2);
                isUpperLimitErrorLabelShown = true;
            }

            if (!upperLimitTextfield.getText().isEmpty() && !lowerLimitTextfield.getText().isEmpty() && isValidInput) {
                gridPane.getChildren().remove(errorLabelLowerTextfield);
                gridPane.getChildren().remove(errorLabelUpperTextfield);
                errorLabelLowerTextfield.setText("");
                errorLabelUpperTextfield.setText("");

                if (!isLowerSmallerThanUpper()) {
                    errorLabelLowerLargerUpper = lowerlimitLargerThanUpperLimit();
                    gridPane.add(errorLabelLowerLargerUpper, 3, 2, 2, 2);
                    return;
                }
                errorLabelLowerLargerUpper.setText("");
                gridPane.getChildren().remove(errorLabelLowerLargerUpper);
//generate random number
                RandomNumbers randomNumbers = new RandomNumbers();
                int resultRandomNumber = randomNumbers.generateRandomInt(Integer.parseInt(lowerLimitTextfield.getText()), Integer.parseInt(upperLimitTextfield.getText()));
                resultLabel.setText("Your number: " + resultRandomNumber);
            }
        });
    }

    public Label labelErrorTextfield() {
        Label labelemptyTextField = new Label("Please enter a number.");
        labelemptyTextField.setTextFill(Color.color(1, 0, 0));
        labelemptyTextField.setFont(new Font(12));
        return labelemptyTextField;
    }

    public boolean isValidTextfieldInput(String textTypedInTextfield) {
        return textTypedInTextfield.matches("^[0-9]+");
    }

    public boolean isLowerSmallerThanUpper() {
        //implied that both textfields provide a valid number
        return Integer.parseInt(lowerLimitTextfield.getText()) < Integer.parseInt(upperLimitTextfield.getText());
    }

    public Label lowerlimitLargerThanUpperLimit() {
        Label laberlowerNeedsToBeSmallerThanUpper = new Label("The lower limit value \nneeds to be smaller \nthan the upper limit value.");
        laberlowerNeedsToBeSmallerThanUpper.setTextFill(Color.color(1, 0, 0));
        laberlowerNeedsToBeSmallerThanUpper.setFont(new Font(12));
        return laberlowerNeedsToBeSmallerThanUpper;
    }

    public void buttonClearAction() {
        buttonClear.setOnAction(e -> {
            lowerLimitTextfield.setText("");
            upperLimitTextfield.setText("");
            resultLabel.setText("");

            errorLabelLowerTextfield.setText("");
            errorLabelUpperTextfield.setText("");
            gridPane.getChildren().remove(errorLabelLowerTextfield);
            gridPane.getChildren().remove(errorLabelUpperTextfield);

            errorLabelLowerLargerUpper.setText("");
            gridPane.getChildren().remove(errorLabelLowerLargerUpper);
        });
    }
}