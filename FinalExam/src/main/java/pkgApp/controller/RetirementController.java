package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

	private RetirementApp mainApp = null;
	
	@FXML
	private TextField txtYearsToWork;
	@FXML
	private TextField txtSaveEachMonth;
	@FXML
	private TextField txtAnnualReturn;
	@FXML
	private TextField txtYearsRetired;
	@FXML
	private TextField txtRequiredIncome;
	@FXML
	private TextField txtMonthlySSI;
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
		
		txtYearsToWork.clear();
		txtSaveEachMonth.clear();
		txtAnnualReturn.clear();
		txtYearsRetired.clear();
		txtRequiredIncome.clear();
		txtMonthlySSI.clear();
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		Retirement Retirement = new Retirement(Integer.parseInt((txtYearsToWork.getText())),
				Double.parseDouble(txtSaveEachMonth.getText()), Integer.parseInt((txtAnnualReturn.getText())),
				Double.parseDouble(txtYearsRetired.getText()),
				Double.parseDouble(txtRequiredIncome.getText()), Double.parseDouble(txtMonthlySSI.getText()));	
	}
}
