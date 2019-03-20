package game;

import java.util.EventObject;

public class AppendTextEvent extends EventObject{
	private String textToAppend;
	public AppendTextEvent(Object source, String textToAppend) {
		super(source);
		this.textToAppend = textToAppend;
	}
	public String getTextToAppend() {
		return textToAppend;
	}

}
