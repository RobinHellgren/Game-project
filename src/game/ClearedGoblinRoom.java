package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//A subclass of scene for a specific scene
public class ClearedGoblinRoom extends Scene {

	public ClearedGoblinRoom(Player player) {
		super(player);
		//sets the boolean to remeber that the goblin is defeated
		player.setDefeatedGoblin(true);
		//attempts to read the flavor text from a text file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("GoblinRoomCleared.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//Create scene buttons
		JButton left = new JButton("Left door");
		JButton right = new JButton("Right door");
		//Add behaviour to the button
		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Switch scene to the next one 
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DungeonRoomScene(player)));
			}

		});
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Switch scene to the next one 
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DiningRoomScene(player)));
			}

		});
		//add the button to the buttonPanel
		buttonPanel.add(left);
		buttonPanel.add(right);

	}

}
