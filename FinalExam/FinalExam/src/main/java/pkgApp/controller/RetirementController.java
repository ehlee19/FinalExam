ackage pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {
	
	@FXML
	private TextField YearsToWorkField;
	@FXML
	private TextField TopAnnualReturnField;
	@FXML
	private TextField YearsRetiredField;
	@FXML
	private TextField BottomAnnualReturnField;
	@FXML
	private TextField RequiredIncomeField;
	@FXML
	private TextField MonthlySSIField;
	@FXML
	private Label MonthlySavings;
	@FXML
	private Label TotalSavings;

	private RetirementApp mainApp = null;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");

		YearsToWorkField.clear();
		TopAnnualReturnField.clear();
		YearsRetiredField.clear();
		BottomAnnualReturnField.clear();
		RequiredIncomeField.clear();
		MonthlySSIField.clear();
		TotalSavings.setText("");
		MonthlySavings.setText("");
	}

	@FXML
	public void btnCalculate(ActionEvent event) {
		try {
		Retirement r = new Retirement(Integer.parseInt((YearsToWorkField.getText())),
				Double.parseDouble(TopAnnualReturnField.getText()), Integer.parseInt((YearsRetiredField.getText())),
				Double.parseDouble(BottomAnnualReturnField.getText()),
				Double.parseDouble(RequiredIncomeField.getText()), Double.parseDouble(MonthlySSIField.getText()));
		MonthlySavings.setText("$" + Double.toString(r.AmountToSave()));
		TotalSavings.setText("$" + Double.toString(r.TotalAmountSaved()));
		if (Double.parseDouble(TopAnnualReturnField.getText()) > 0.2){
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Annual Return Error");
            alert.setHeaderText("Annual Return unexpectingly high");
            alert.setContentText("Working Annual Return is higher than recommended, please reconsider.");

            alert.showAndWait();
		}
		if (Double.parseDouble(BottomAnnualReturnField.getText()) > 0.03){
			Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Annual Return Error");
            alert.setHeaderText("Annual Return unexpectingly high");
            alert.setContentText("Retired Annual Return is higher than recommended, please reconsider.");

            alert.showAndWait();
		}
		}
		catch (NumberFormatException e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Text Inserted");
            alert.setHeaderText("Incorrect Input");
            alert.setContentText("Please fill every field with only numbers.");

            alert.showAndWait();
		}
		catch (Exception e) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Error");
            alert.setHeaderText("Unexpected error");
            alert.setContentText("Please check all fields are valid.");

            alert.showAndWait();
		}

	}
	@FXML
	public boolean checkFields() {
		
		
		
		return true;
	}

}
