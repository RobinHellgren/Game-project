package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class ClearedGoblinRoom extends Scene {

	public ClearedGoblinRoom(Player player) {
		super(player);
		player.setDefeatedGoblin(true);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("GoblinRoomCleared.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton left = new JButton("Left door");
		JButton right = new JButton("Left door");
		left.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DungeonRoomScene(player)));
			}

		});
		right.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DiningRoomScene(player)));
			}

		});

		buttonPanel.add(left);
		buttonPanel.add(right);

	}

}
