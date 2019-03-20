package game;

import java.util.EventListener;

public interface AppendTextListener extends EventListener{
	public void appendTextEventOccured(AppendTextEvent event);
}
