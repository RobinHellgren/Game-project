package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//A subclass of scene for a specific scene
public class DiningRoomScene extends Scene{
	public DiningRoomScene(Player player) {
		super(player);
		//attempts to read the flavor text from a text file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("DiningRoom.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//Create scene buttons
		JButton darkDoor = new JButton("Dark doorway");
		JButton ornateDoor = new JButton("Ornate door");
		//If the player haven't found the diary yet
		if(!player.isFoundDairy()) {
			//send message to the text box
			fireAppendTextEvent(new AppendTextEvent(this, "Under one of the legs of the table theres a strange tome, balancing the table."));
			//Create the diary button
			JButton diaryBtn = new JButton("Strange tome");
			//add behaviour to the button
			diaryBtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					//Try to add text to the text box from a file
					try {
						fireAppendTextEvent(new AppendTextEvent(this, TextFileReader.getInstance().readFile("ReadDiary.txt")));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					//Set a boolean to remember that the player has found the diary
					player.setFoundDairy(true);
					//Remove the button from the scene
					buttonPanel.remove(diaryBtn);
					//Refresh the scene gui
					revalidate();
					repaint();
				}
				
			});
			//add the diary button to the scene
			buttonPanel.add(diaryBtn);
		}
		//add behaviour to the button
		darkDoor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//If the player has defeated the goblin send them to the cleared goblin scene
				if(player.isDefeatedGoblin()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ClearedGoblinRoom(player)));	
				}
				//Otherwise send them to the goblin combat scene
				else{
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new GoblinCombatScene(player, new Goblin())));
				}
			}
			
		});
		//add behaviour to the button
		ornateDoor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//If the player has defeated the goblin send them to the cleared throne scene
				if(player.isDefeatedThrone()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ThroneRoomClearedScene(player)));	
				}
				//Otherwise send them to the throne room scene where the throne isn't defeated scene
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ThroneRoomScene(player)));
				}
			}
			
		});
		//add buttons to the scene
		buttonPanel.add(darkDoor);
		buttonPanel.add(ornateDoor);

	}

}
