package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//subclass of scene for a specific scene
public class RiddleRoomScene extends Scene{
	public RiddleRoomScene(Player player) {
		super(player);
		//try to read text from a file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("RiddleRoom.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//If the player know the answer to the riddle...
		if(player.isKnowsAnswerToRiddle()) {
			//append text to the text box
			fireAppendTextEvent(new AppendTextEvent(this, "You know the answer to the riddle!"));
			//create a button
			JButton answerRiddleBtn = new JButton("Answer riddle!");
			//add it to the button panel
			buttonPanel.add(answerRiddleBtn);
			//add behaviour to the button
			answerRiddleBtn.addActionListener(new ActionListener() {
				
				@Override
				//send the player to the victory scene
				public void actionPerformed(ActionEvent e) {
					fireSwitchSceneEvent(new SwitchSceneEvent(this, new VictoryScene(player)));
				}
				
			});
		}
		//otherwise tell the player they dont know the answer
		else {
			fireAppendTextEvent(new AppendTextEvent(this, "You dont know the answer to the riddle"));
		}
		//create door buttons
		JButton gldDoor = new JButton("Gilded door");
		JButton mahoDoor = new JButton("Mahogany door");
		JButton ornateDoor = new JButton("Ornate door");
		//add behaviour to the buttons
		gldDoor.addActionListener(new ActionListener() {

			@Override
			//if the player has defeated the throne send them to the clreared room other wise end them to the uncleared room
			public void actionPerformed(ActionEvent e) {
				if(player.isDefeatedThrone()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ThroneRoomClearedScene(player)));	
				}
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ThroneRoomScene(player)));
				}			}
			
		});
		//send the player to the dungeon room
		mahoDoor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DungeonRoomScene(player)));	
		}
			
		});
		//send the player to the dining room
		ornateDoor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DiningRoomScene(player)));	
		}
			
		});
		//add buttons to the scene
		buttonPanel.add(gldDoor);
		buttonPanel.add(mahoDoor);
		buttonPanel.add(ornateDoor);

	}

}
