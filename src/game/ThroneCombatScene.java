package game;

import java.io.IOException;

import tools.TextFileReader;

public class ThroneCombatScene extends CombatScene{
	public ThroneCombatScene(Player player, Enemy enemy) {
		super(player, enemy);
		this.victoryScene = new ThroneRoomClearedScene(player);
		this.defeatScene = new GoblinGameOverScene(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("CombatThrone.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
}
