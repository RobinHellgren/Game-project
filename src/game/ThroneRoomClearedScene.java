package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//cleared version of the throne room
public class ThroneRoomClearedScene extends Scene{
	public ThroneRoomClearedScene(Player player) {
		super(player);
		//set the boolean to remember that the player has defeated the throne
		player.setDefeatedThrone(true);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("ThroneRoomCleared.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//create buttons
		JButton treasureDoor = new JButton("Treaure door");
		JButton questionDoor = new JButton("Questionmark door");
		//if the player has found the diary and haven't investigated the bookcase before
		if(player.isFoundDairy() && !player.isKnowsAnswerToRiddle()) {
			fireAppendTextEvent(new AppendTextEvent(this, "You see the bookcase mentioned by the servant"));
			JButton bookcaseBtn = new JButton("Investigate bookcase");
			bookcaseBtn.addActionListener(new ActionListener() {
				//show the player text from the text file, set the boolean to true, remove the button an revalidate the gui
				public void actionPerformed(ActionEvent e) {
					try {
						fireAppendTextEvent(new AppendTextEvent(this, TextFileReader.getInstance().readFile("InvestigateBookcase.txt")));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					player.setKnowsAnswerToRiddle(true);
					buttonPanel.remove(bookcaseBtn);
					revalidate();
					repaint();
				}
				
			});
			//add button to gui
			buttonPanel.add(bookcaseBtn);
		}		
		treasureDoor.addActionListener(new ActionListener() {

			@Override
			//if the player has cleared the treasure room send them to the cleared version otherwise send them to the uncleared version
			public void actionPerformed(ActionEvent e) {
				if(player.isClearedTreasureRoom()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomClearedScene(player)));	
				}
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TreasureRoomScene(player)));
				}
			}
			
		});
		//send the player to the riddle room
		questionDoor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new RiddleRoomScene(player)));	
			}
			
		});
		//add the buttons to the gui
		buttonPanel.add(treasureDoor);
		buttonPanel.add(questionDoor);

	}

}
