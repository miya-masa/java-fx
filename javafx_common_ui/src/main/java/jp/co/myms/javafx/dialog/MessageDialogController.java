package jp.co.myms.javafx.dialog;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jp.co.myms.javafx.dialog.MessageDialog.ButtonType;

public class MessageDialogController implements Initializable {

	@FXML
	// fx:id="btnBar"
	private HBox btnBar; // Value injected by FXMLLoader

	@FXML
	// fx:id="lblDialogMessage"
	private Label lblDialogMessage; // Value injected by FXMLLoader

	private ButtonType result;

	private Stage stage;

	@Override
	// This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert btnBar != null : "fx:id=\"btnBar\" was not injected: check your FXML file 'MessageDialog.fxml'.";
		assert lblDialogMessage != null : "fx:id=\"lblDialogMessage\" was not injected: check your FXML file 'MessageDialog.fxml'.";

		// initialize your logic here: all @FXML variables will have been
		// injected

	}

	public void setBtnBar(ButtonType... buttonTypes) {

		for (final ButtonType buttonType : buttonTypes) {
			Button button = new Button();
			button.setText(buttonType.name());
			button.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					setResult(buttonType);
					stage.close();
				}
			});
			this.btnBar.getChildren().add(button);
		}
	}

	private void setResult(ButtonType result) {
		this.result = result;
	}

	public ButtonType getResult() {
		return result;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setMessage(String message) {
		this.lblDialogMessage.setText(message);
	}
}
