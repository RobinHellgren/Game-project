package game;

import java.util.EventListener;
//listener that recives the switch scene events
public interface SwitchSceneListener extends EventListener{
	public void switchSceneEventOccured(SwitchSceneEvent event);

}
