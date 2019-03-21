package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//uncleared version of the treasure room
public class TreasureRoomScene extends Scene{
	public TreasureRoomScene(Player player) {
		super(player);
		//try to read text from file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("TreasureRoom.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//create buttons
		JButton swordBtn = new JButton("Sword");
		JButton shieldBtn = new JButton("Shield");
		JButton gobBtn = new JButton("Goblet");
		//send the player to the cleared version of the room
		swordBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setClearedTreasureRoom(true);
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomClearedScene(player)));
			}
			
		});
		//send the player to the gameover screen
		shieldBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomGameOverScene(player)));
			}
			
		});
		//send the player to the gameover screen
		gobBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomGameOverScene(player)));
			}
			
		});
		//add buttons to the gui
		buttonPanel.add(gobBtn);
		buttonPanel.add(shieldBtn);
		buttonPanel.add(swordBtn);

	}

}
