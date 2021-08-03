package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable{
	
	@FXML
	private Button btTest, btTest2, btSoma;
	
	@FXML	
	private TextField txtNumero1;
	
	@FXML
	private TextField txtNumero2;
	
	@FXML
	private Label labelResultado;
		
	@FXML
	public void onBtTestAction() {
		System.out.println("Click");
		
		Alerts.showAlert("Titulo", null, "Mensagem", Alert.AlertType.INFORMATION);
		
	}
	
	@FXML
	public void onBtTest2Action() {
		int a=0;
		
		for (int i=0; i<10; i++) {
			System.out.println(i);
			a=a+i*2;
			
		}
		
		Alerts.showAlert("Resultado", null, "Resultado do La�o: "+a, Alert.AlertType.INFORMATION);
	}
	
	public void onBrSomaAction() {
		try {
			Locale.setDefault(Locale.US);
			double soma = Double.parseDouble(txtNumero1.getText()) 
					    + Double.parseDouble(txtNumero2.getText());
			labelResultado.setText(String.format("Resultado: %.2f", soma));
		}
		catch(NumberFormatException e) {
			Alerts.showAlert("ERROR!", null, e.getMessage(), AlertType.ERROR);
		}
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumero1);
		Constraints.setTextFieldDouble(txtNumero2);
		Constraints.setTextFieldMaxLength(txtNumero1, 5);
		Constraints.setTextFieldMaxLength(txtNumero2, 5);
		
	}

}
