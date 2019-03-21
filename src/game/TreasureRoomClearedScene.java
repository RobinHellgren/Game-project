package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class TreasureRoomClearedScene extends Scene{
	public TreasureRoomClearedScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("TreasureRoomCleared.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton right = new JButton("White oak door");
		JButton left = new JButton("Gilded door");


		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DungeonRoomScene(player)));
			}
			
		});
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(player.isDefeatedThrone()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomClearedScene(player)));	
				}
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomScene(player)));
				}
			}
			
		});

		buttonPanel.add(left);
		buttonPanel.add(right);

	}
}
