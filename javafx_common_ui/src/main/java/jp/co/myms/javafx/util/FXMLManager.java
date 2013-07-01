package jp.co.myms.javafx.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class FXMLManager {

	private FXMLLoader fxmlLoader;

	private Parent rootNode;

	private Scene scene;

	FXMLManager(String fxmlFile) {
		fxmlLoader = new FXMLLoader();
		try {
			rootNode = (Parent) fxmlLoader.load(this.getClass().getClassLoader().getResourceAsStream(fxmlFile));
			scene = new Scene(rootNode);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(fxmlFile);
		}
	}

	public FXMLLoader getFxmlLoader() {
		return fxmlLoader;
	}

	public <T> T getController(Class<T> conntrollerClass) {
		return fxmlLoader.getController();
	}

	public Parent getRootNode() {
		return rootNode;
	}

	public Scene getScene() {
		return scene;
	}

}
