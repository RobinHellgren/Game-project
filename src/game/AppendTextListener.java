package game;

import java.util.EventListener;
//EventListerner interface used to pass the event to the mainframe.
public interface AppendTextListener extends EventListener{
	public void appendTextEventOccured(AppendTextEvent event);
}
