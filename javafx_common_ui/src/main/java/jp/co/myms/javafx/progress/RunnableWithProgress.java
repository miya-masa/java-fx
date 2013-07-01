package jp.co.myms.javafx.progress;

public interface RunnableWithProgress {

	void run(ProgressMonitor progressMonitor) throws CancelException;

}
