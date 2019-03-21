package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class ThroneRoomClearedScene extends Scene{
	public ThroneRoomClearedScene(Player player) {
		super(player);
		player.setDefeatedThrone(true);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("ThroneRoomCleared.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton treasureDoor = new JButton("Treaure door");
		JButton questionDoor = new JButton("Questionmark door");

		if(player.isKnowsAnswerToRiddle()) {
			fireAppendTextEvent(new AppendTextEvent(this, "You see the bookcase mentioned by the servant"));
			JButton bookcaseBtn = new JButton("Investigate bookcase");
			bookcaseBtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {
						fireAppendTextEvent(new AppendTextEvent(this, TextFileReader.getInstance().readFile("InvestigateBookcase.txt")));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					player.setKnowsAnswerToRiddle(true);
				}
				
			});
			buttonPanel.add(bookcaseBtn);
		}		
		treasureDoor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(player.isClearedTreasureRoom()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomClearedScene(player)));	
				}
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomScene(player)));
				}
			}
			
		});
		questionDoor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new RiddleRoomScene(player)));	
			}
			
		});
		buttonPanel.add(treasureDoor);
		buttonPanel.add(questionDoor);

	}

}
