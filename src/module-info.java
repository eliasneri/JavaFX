module JavaFX {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
	

	//no meu caso eu n�o tinha adicionado essa linha
        opens gui to javafx.graphics, javafx.fxml;
}

