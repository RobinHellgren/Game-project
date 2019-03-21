package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;

import tools.TextFileReader;
//A subclass of scene for a specific scene
public class ChooseNameScene extends Scene{
	public ChooseNameScene(Player player) {
		super(player);
		//attempts to read the flavor text from a text file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("NameDes.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//Create scene buttons
		JButton contBtn = new JButton("Continue");
		JTextField nameField = new JTextField(35);
		
		//Add behaviour to the button
		contBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//set the players name
				player.setName(nameField.getText());
				//Switch scene to the next one and update the players stat panel
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DungeonRoomScene(player)));
			}
			
		});
		//add the button to the buttonPanel
		buttonPanel.add(nameField);
		buttonPanel.add(contBtn);
	}
}
