package sample;

import Logic.CalculateLogic;
import Logic.ConvertLogic;
import Logic.ICalculateLogic;
import Logic.IConvertLogic;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private Button _resultButton;
    @FXML
    private TextField _yearInput;
    @FXML
    private TextField _dayInput;
    @FXML
    private Label _weekDay;

    private int _year;
    private int _dayNumber;

    private IConvertLogic _convertLogic;
    private ICalculateLogic _calculateLogic;

    public Controller()
    {
        this._convertLogic = new ConvertLogic();
        this._calculateLogic = new CalculateLogic();
    }

    @FXML
    private void OnButtonClick(ActionEvent event)
    {
        if(_convertLogic.TryParse(this._yearInput.getText()))
        {
            this._year = Integer.parseInt(this._yearInput.getText());
        }
        else
        {
            this._year = 0;
        }

        if(_convertLogic.TryParse(this._dayInput.getText()))
        {
            this._dayNumber = Integer.parseInt(this._dayInput.getText());
        }
        else
        {
            this._dayNumber = 0;
        }

        String dayName = _calculateLogic.GetWeekDay(this._year, this._dayNumber);

        this._weekDay.setText(dayName);
    }
}
