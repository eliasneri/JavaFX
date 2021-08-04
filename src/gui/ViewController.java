package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constraints;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {

	@FXML
	private Button btTest, btTest2, btSoma, btAll;

	@FXML
	private TextField txtNumero1;

	@FXML
	private TextField txtNumero2;

	@FXML
	private Label labelResultado;

	@FXML
	private ComboBox<Person> comboBoxPerson;

	private ObservableList<Person> obsList;

	@FXML
	public void onBtTestAction() {
		System.out.println("Click");

		Alerts.showAlert("Titulo", null, "Mensagem", Alert.AlertType.INFORMATION);

	}

	@FXML
	public void onBtTest2Action() {
		int a = 0;

		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			a = a + i * 2;

		}

		Alerts.showAlert("Resultado", null, "Resultado do Laço: " + a, Alert.AlertType.INFORMATION);
	}

	public void onBrSomaAction() {
		try {
			Locale.setDefault(Locale.US);
			double soma = Double.parseDouble(txtNumero1.getText()) + Double.parseDouble(txtNumero2.getText());
			labelResultado.setText(String.format("Resultado: %.2f", soma));
		} catch (NumberFormatException e) {
			Alerts.showAlert("ERROR!", null, e.getMessage(), AlertType.ERROR);
		}

	}
	
	public void onComboBoxPersonAction() {
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		Alerts.showAlert(null, null, person.getId() + " - " +
				person.getName() + " - " + 
				person.getEmail(), AlertType.INFORMATION);
	}
	
	public void onBtAllAction() {
		for(Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
		
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		Constraints.setTextFieldDouble(txtNumero1);
		Constraints.setTextFieldDouble(txtNumero2);
		Constraints.setTextFieldMaxLength(txtNumero1, 5);
		Constraints.setTextFieldMaxLength(txtNumero2, 5);

		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "maria", "maria@gmail.com"));
		list.add(new Person(2, "Alex", "alex@gmail.com"));
		list.add(new Person(3, "Bob", "bob@gmail.com"));

		obsList = FXCollections.observableArrayList(list);
		comboBoxPerson.setItems(obsList);

		// PARA MOSTRAR NO COMBO BOX APENAS AS INFORMAÇÕES ESCOLHIDAS - ID E NOME...
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getId() + " - "+ item.getName().toUpperCase());
			}
		};
		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));

	}

}
