package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class TreasureRoomScene extends Scene{
	public TreasureRoomScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("TreasureRoom.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton swordBtn = new JButton("Sword");
		JButton shieldBtn = new JButton("Shield");
		JButton gobBtn = new JButton("Goblet");
		
		swordBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomClearedScene(player)));
			}
			
		});
		shieldBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomGameOverScene(player)));
			}
			
		});
		gobBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomGameOverScene(player)));
			}
			
		});

		buttonPanel.add(gobBtn);
		buttonPanel.add(shieldBtn);
		buttonPanel.add(swordBtn);

	}

}
