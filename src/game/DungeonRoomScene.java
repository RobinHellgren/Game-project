package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class DungeonRoomScene extends Scene{
	public DungeonRoomScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("DungeonRoom.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton left = new JButton("Left door");
		JButton middle = new JButton("Middle door");
		JButton right = new JButton("Right door");


		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(player.isDefeatedGoblin()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomClearedScene(player)));	
				}
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomScene(player)));
				}
			}
			
		});
		middle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new RiddleRoomScene(player)));
			}
			
		});
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(player.isDefeatedGoblin()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ClearedGoblinRoom(player)));	
				}
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new GoblinCombatScene(player, new Goblin())));
				}
			}
			
		});

		buttonPanel.add(left);
		buttonPanel.add(middle);
		buttonPanel.add(right);

	}

}
