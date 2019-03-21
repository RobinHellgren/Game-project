package game;

import java.io.IOException;

import tools.TextFileReader;

public class GoblinCombatScene extends CombatScene {

	public GoblinCombatScene(Player player, Enemy enemy) {
		super(player, enemy);
		this.victoryScene = new ClearedGoblinRoom(player);
		this.defeatScene = new GoblinGameOverScene(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("CombatGoblin.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}



}
