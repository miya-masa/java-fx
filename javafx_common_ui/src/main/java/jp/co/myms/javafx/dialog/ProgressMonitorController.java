package jp.co.myms.javafx.dialog;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import jp.co.myms.javafx.progress.ProgressMonitor;

public class ProgressMonitorController implements Initializable {

	@FXML
	//  fx:id="lblMessage"
	private Label lblMessage; // Value injected by FXMLLoader

	@FXML
	//  fx:id="btnCancel"
	private Button btnCancel; // Value injected by FXMLLoader

	@FXML
	//  fx:id="progressBar"
	private ProgressBar progressBar; // Value injected by FXMLLoader

	private ProgressMonitor progressMonitor;

	// Handler for Button[fx:id="btnCancel"] onAction
	public void onSelectedCancel(ActionEvent event) {
		progressMonitor.setCanceled();
	}

	@Override
	// This method is called by the FXMLLoader when initialization is complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'ProgressMonitorDialog.fxml'.";
		assert lblMessage != null : "fx:id=\"lblMessage\" was not injected: check your FXML file 'ProgressMonitorDialog.fxml'.";
		assert progressBar != null : "fx:id=\"progressBar\" was not injected: check your FXML file 'ProgressMonitorDialog.fxml'.";

		// initialize your logic here: all @FXML variables will have been injected

	}

	public void setProgressMonitor(ProgressMonitor progressMonitor) {

		progressBar.progressProperty().bind(progressMonitor.getWorkTask());
		lblMessage.textProperty().bind(progressMonitor.getSubMessage());
		this.progressMonitor = progressMonitor;

	}
}
