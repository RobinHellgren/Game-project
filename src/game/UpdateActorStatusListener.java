package game;

import java.util.EventListener;

public interface UpdateActorStatusListener extends EventListener {
	public void UpdateActorStatusEventOccured(UpdateActorStatusEvent event);
}
