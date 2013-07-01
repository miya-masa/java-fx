package jp.co.myms.javafx.util;

import java.util.HashMap;
import java.util.Map;

public class FXMLManagerFactory {
	private static Map<String, FXMLManager> PATH_FXMLLOADER = new HashMap<>();

	public static FXMLManager create(String fxmlFile) {
		if (PATH_FXMLLOADER.containsKey(fxmlFile)) {
			return PATH_FXMLLOADER.get(fxmlFile);
		}
		FXMLManager fxmlManager = new FXMLManager(fxmlFile);
		PATH_FXMLLOADER.put(fxmlFile, fxmlManager);
		return fxmlManager;
	}

}
