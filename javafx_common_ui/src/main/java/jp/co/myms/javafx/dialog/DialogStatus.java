package jp.co.myms.javafx.dialog;

import javafx.stage.Window;
import jp.co.myms.javafx.dialog.MessageDialog.ButtonType;

public class DialogStatus {

	private String message;
	private String title;
	private ButtonType[] buttonType;
	private Window owner;
	public String detailMessage;

	private DialogStatus() {
	}

	public static class DialogStatusBuilder {
		private DialogStatus target;

		public DialogStatusBuilder(String title) {
			target = new DialogStatus();
			target.title = title;
		}

		public DialogStatusBuilder setMessage(String message) {
			target.message = message;
			return this;
		}

		public DialogStatusBuilder setButtonType(ButtonType... buttonTypes) {
			target.buttonType = buttonTypes;
			return this;
		}

		public DialogStatusBuilder setOwner(Window owner) {
			target.owner = owner;
			return this;
		}

		public DialogStatusBuilder setDetailsMessage(String detailMessage) {
			target.detailMessage = detailMessage;
			return this;
		}

		public DialogStatus build() {
			return target;
		}

	}

	/**
	 * messageを取得します。
	 * 
	 * @return message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * titleを取得します。
	 * 
	 * @return title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * buttonTypeを取得します。
	 * 
	 * @return buttonType
	 */
	public ButtonType[] getButtonType() {
		return buttonType;
	}

	/**
	 * ownerを取得します。
	 * 
	 * @return owner
	 */
	public Window getOwner() {
		return owner;
	}

	/**
	 * detailMessageを取得する.
	 * 
	 * @return detailMessage
	 */
	public String getDetailMessage() {
		return detailMessage;
	}

	/**
	 * detailMessageを設定する.
	 * 
	 * @param detailMessage detailMessage
	 */
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}

}
