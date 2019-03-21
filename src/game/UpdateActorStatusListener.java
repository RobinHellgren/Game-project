package game;

import java.util.EventListener;
//listener that handles the events that update the status panels
public interface UpdateActorStatusListener extends EventListener {
	public void UpdateActorStatusEventOccured(UpdateActorStatusEvent event);
}
