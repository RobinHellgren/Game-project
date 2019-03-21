package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class RiddleRoomScene extends Scene{
	public RiddleRoomScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("RiddleRoom.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if(player.isKnowsAnswerToRiddle()) {
			fireAppendTextEvent(new AppendTextEvent(this, "You know the answer to the riddle!"));
			JButton answerRiddleBtn = new JButton("Answer riddle!");
			buttonPanel.add(answerRiddleBtn);
;			answerRiddleBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					fireSwitchSceneEvent(new SwitchSceneEvent(this, new VictoryScene(player)));
				}
				
			});
		}
		else {
			fireAppendTextEvent(new AppendTextEvent(this, "You dont know the answer to the riddle"));
		}
		JButton gldDoor = new JButton("Gilded door");
		JButton mahoDoor = new JButton("Mahogany door");
		gldDoor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(player.isDefeatedThrone()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ThroneRoomClearedScene(player)));	
				}
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ThroneRoomScene(player)));
				}			}
			
		});
		gldDoor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DungeonRoomScene(player)));	
		}
			
		});

		buttonPanel.add(gldDoor);
		buttonPanel.add(mahoDoor);

	}

}
