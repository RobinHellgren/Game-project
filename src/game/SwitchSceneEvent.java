package game;

import java.util.EventObject;
//event that contains the scene which should be switched to
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
