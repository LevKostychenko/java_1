package sample;

import logic.CalculateLogic;
import logic.ConvertLogic;
import logic.ICalculateLogic;
import logic.IConvertLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button resultButton;
    @FXML
    private TextField yearInput;
    @FXML
    private TextField dayInput;
    @FXML
    private Label weekDay;

    private int year;
    private int dayNumber;

    private IConvertLogic convertLogic;
    private ICalculateLogic calculateLogic;

    public Controller() {
        this.convertLogic = new ConvertLogic();
        this.calculateLogic = new CalculateLogic();
    }

    @FXML
    private void onButtonClick(ActionEvent event) {
        if(convertLogic.tryParse(this.yearInput.getText())) {
            this.year = Integer.parseInt(this.yearInput.getText());
        }
        else {
            this.year = 0;
        }

        if(convertLogic.tryParse(this.dayInput.getText())) {
            this.dayNumber = Integer.parseInt(this.dayInput.getText());
        }
        else {
            this.dayNumber = 0;
        }

        String dayName = calculateLogic.getWeekDay(this.year, this.dayNumber);

        this.weekDay.setText(dayName);
    }
}
