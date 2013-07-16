package jp.co.myms.javafx.progress;

public interface RunnableWithProgress<T> {

	T run(ProgressMonitor progressMonitor) throws CancelException;

}
