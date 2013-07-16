package jp.co.myms.javafx.progress;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

public interface ProgressMonitor {

	void startTask(int totalTask, String message);

	void start();

	void work(int work);

	DoubleProperty getAmountTask();

	DoubleProperty getWorkTask();

	void end();

	void setSubMessage(String message);

	void clear();

	void setCanceled();

	void checkCanceled() throws CancelException;

	StringProperty getSubMessage();

	void setMainMessage(String mainMessage);

	StringProperty getMainMessage();

	boolean isRunning();

}
