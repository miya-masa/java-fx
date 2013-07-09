package jp.co.myms.javafx.dialog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.application.Platform;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.Window;
import jp.co.myms.javafx.progress.CancelException;
import jp.co.myms.javafx.progress.ProgressMonitor;
import jp.co.myms.javafx.progress.ProgressMonitorImpl;
import jp.co.myms.javafx.progress.RunfailureException;
import jp.co.myms.javafx.progress.RunnableWithProgress;
import jp.co.myms.javafx.util.FXMLManager;
import jp.co.myms.javafx.util.FXMLManagerFactory;

public class ProgressMonitorDialog {

	private Stage stage;

	private ProgressMonitor progressMonitor;

	public ProgressMonitorDialog(Window owner, ProgressMonitor progressMonitor) {
		stage = new Stage();
		FXMLManager fxmlManager = FXMLManagerFactory.create("jp/co/myms/javafx/fxml/ProgressMonitorDialog.fxml");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setScene(fxmlManager.getScene());
		stage.initStyle(StageStyle.DECORATED);
		stage.initOwner(owner);
		stage.setTitle("進捗ダイアログ");
		ProgressMonitorController controller = fxmlManager.getController(ProgressMonitorController.class);
		controller.setProgressMonitor(progressMonitor);
		this.progressMonitor = progressMonitor;
	}

	public ProgressMonitorDialog(Window owner) {
		this(owner, new ProgressMonitorImpl());
	}

	public void run(final RunnableWithProgress runnable) throws CancelException, RunfailureException {

		ExecutorService executorService = Executors.newSingleThreadExecutor();
		InternalRunnable internalRunnable = new InternalRunnable(stage, runnable, progressMonitor);
		executorService.execute(internalRunnable);
		stage.showAndWait();
		if (internalRunnable.getCancelException() != null) {
			throw internalRunnable.getCancelException();
		} else if (internalRunnable.getRunfailureException() != null) {
			throw internalRunnable.getRunfailureException();
		}
	}

	private static class InternalRunnable implements Runnable {
		private CancelException cancelException;
		private RunfailureException runfailureException;
		private RunnableWithProgress runnable;
		private ProgressMonitor progressMonitor;
		private Stage stage;

		public InternalRunnable(Stage stage, RunnableWithProgress runnable, ProgressMonitor progressMonitor) {
			this.runnable = runnable;
			this.progressMonitor = progressMonitor;
			this.stage = stage;
		}

		@Override
		public void run() {
			try {
				runnable.run(progressMonitor);
			} catch (CancelException e) {
				progressMonitor.setCanceled();
				this.cancelException = e;
			} catch (Exception e) {
				this.runfailureException = new RunfailureException("実行中に例外が発生しました", e);
			} finally {
				closeStage(stage);
			}
		}

		private void closeStage(final Stage stage) {
			Platform.runLater(new Runnable() {

				@Override
				public void run() {
					stage.close();
				}
			});
		}

		public CancelException getCancelException() {
			return cancelException;
		}

		public RunfailureException getRunfailureException() {
			return runfailureException;
		}
	}

}
