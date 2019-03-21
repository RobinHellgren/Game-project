package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//cleared version of the treasure room
public class TreasureRoomClearedScene extends Scene{
	public TreasureRoomClearedScene(Player player) {
		super(player);
		//try to read text from file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("TreasureRoomCleared.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//create buttons
		JButton right = new JButton("White oak door");
		JButton left = new JButton("Gilded door");

		//send player to the dungeon room
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DungeonRoomScene(player)));
			}
			
		});
		//if the player has cleared the throne room send them to the cleared version otherwise send them to the uncleared version
		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(player.isDefeatedThrone()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ThroneRoomClearedScene(player)));	
				}
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ThroneRoomScene(player)));
				}
			}
			
		});
		//add buttons to the gui
		buttonPanel.add(left);
		buttonPanel.add(right);

	}
}
