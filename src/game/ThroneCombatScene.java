package game;

import java.io.IOException;

import tools.TextFileReader;
//specific combat scene
public class ThroneCombatScene extends CombatScene{
	public ThroneCombatScene(Player player, Enemy enemy) {
		super(player, enemy);
		//set the victory & defeat scenes
		this.victoryScene = new ThroneRoomClearedScene(player);
		this.defeatScene = new ThroneGameOverScene(player);
		//try to read text from file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("CombatThrone.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
