package jp.co.myms.javafx.dialog;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class MessageDialog {

	private MessageDialogController controller;

	private Stage stage;

	public enum ButtonType {
		OK, CANCEL, YES, NO;
	}

	public MessageDialog(Window owner, String title) {
		stage = new Stage();
		FXMLLoader fxmlLoader = new FXMLLoader();
		Parent rootNode;
		try {
			rootNode = (Parent) fxmlLoader.load(this.getClass().getClassLoader().getResourceAsStream("jp/co/myms/javafx/fxml/MessageDialog.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		Scene scene = new Scene(rootNode);
		stage.setScene(scene);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.initOwner(owner);
		controller = (MessageDialogController) fxmlLoader.getController();
		controller.setStage(stage);
	}

	public void setMessage(String message) {
		controller.setMessage(message);
	}

	public ButtonType show(ButtonType... buttonTypes) {
		controller.setBtnBar(buttonTypes);
		stage.showAndWait();
		return controller.getResult();
	}
}
