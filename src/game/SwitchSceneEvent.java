package game;

import java.util.EventObject;

public class SwitchSceneEvent extends EventObject{
	private Scene scene;
	public SwitchSceneEvent(Object arg0, Scene scene) {
		super(arg0);
		this.scene = scene;
	}
	public Scene getScene() {
		return scene;
	}
}
