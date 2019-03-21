package game;
//Sub class of scene for a specific scene
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class DungeonRoomScene extends Scene{
	public DungeonRoomScene(Player player) {
		super(player);
		//try to read text from a file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("DungeonRoom.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//create buttons
		JButton left = new JButton("Left door");
		JButton middle = new JButton("Middle door");
		JButton right = new JButton("Right door");

		//add behaviour
		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//if the player has cleared the treasure room send them to the cleared room
				if(player.isClearedTreasureRoom()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomClearedScene(player)));	
				}
				//Otherwise send them to the uncleared room
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomScene(player)));
				}
			}
			
		});
		//add behaviour
		middle.addActionListener(new ActionListener() {

			@Override
			//Send the player to the riddle room
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new RiddleRoomScene(player)));
			}
			
		});
		//add behaviour
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//if the player has defeated the goblin send them to the cleared room
				if(player.isDefeatedGoblin()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ClearedGoblinRoom(player)));	
				}
				//otherwise send them to the goblin combat scene
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new GoblinCombatScene(player, new Goblin())));
				}
			}
			
		});
		//add buttons to the scene
		buttonPanel.add(left);
		buttonPanel.add(middle);
		buttonPanel.add(right);

	}

}
