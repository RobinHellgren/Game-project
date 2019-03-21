package game;

import java.io.IOException;

import tools.TextFileReader;
//specific combat scene
public class GoblinCombatScene extends CombatScene {

	public GoblinCombatScene(Player player, Enemy enemy) {
		super(player, enemy);
		//set the victory and defeat scenes
		this.victoryScene = new ClearedGoblinRoom(player);
		this.defeatScene = new GoblinGameOverScene(player);
		//try to read text from file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("CombatGoblin.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}



}
