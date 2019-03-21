package game;

import java.util.EventObject;
//Event that's fired when the program wants to append text to the scene text box, contains a string to pass the text.
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
