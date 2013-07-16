package jp.co.myms.javafx.progress;

import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProgressMonitorImpl implements ProgressMonitor {
	private SimpleDoubleProperty totalTask = new SimpleDoubleProperty(0);

	private SimpleDoubleProperty amountTask = new SimpleDoubleProperty(0);

	private SimpleDoubleProperty workTask = new SimpleDoubleProperty(0);

	private SimpleStringProperty messageProperty = new SimpleStringProperty();

	private SimpleStringProperty mainMessageProperty = new SimpleStringProperty();

	private boolean canceled;

	private boolean isRunning;

	@Override
	public void startTask(int totalTask, String message) {

		isRunning = true;
		this.totalTask.set(totalTask);
		this.amountTask.set(totalTask);
		setMainMessage(message);
	}

	@Override
	public void start() {
		isRunning = true;
	}

	@Override
	public void work(int work) {
		workTask.set(workTask.get() + work / totalTask.get());
		amountTask.add(-work);
	}

	@Override
	public DoubleProperty getAmountTask() {
		return amountTask;
	}

	@Override
	public DoubleProperty getWorkTask() {
		return workTask;
	}

	@Override
	public void end() {
		isRunning = false;
	}

	@Override
	public void setSubMessage(final String message) {
		setMessage(message, messageProperty);
	}

	@Override
	public void clear() {
		isRunning = false;
		totalTask.set(-1);
		amountTask.set(-1);
		workTask.set(-1);
	}

	@Override
	public void setCanceled() {
		canceled = true;
	}

	@Override
	public void checkCanceled() throws CancelException {
		if (canceled) {
			isRunning = false;
			throw new CancelException();
		}
	}

	@Override
	public StringProperty getSubMessage() {
		return messageProperty;
	}

	@Override
	public void setMainMessage(String mainMessage) {
		setMessage(mainMessage, mainMessageProperty);

	}

	private void setMessage(final String mainMessage, final SimpleStringProperty messgeProperty) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				messgeProperty.set(mainMessage);
			}
		});

	}

	@Override
	public StringProperty getMainMessage() {
		return mainMessageProperty;
	}

	@Override
	public boolean isRunning() {
		return isRunning;
	}
}
