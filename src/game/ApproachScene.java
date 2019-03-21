package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//A subclass of scene for a specific scene
public class ApproachScene extends Scene{

	public ApproachScene(Player player) {
		super(player);
		//attempts to read the flavor text from a text file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("Approach.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//Create scene buttons 
		JButton createChar = new JButton("Create character");
		//Add behaviour to the button
		createChar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Switch scene to the next one
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseSpeciesScene(player)));
			}
			
		});
		//add the button to the buttonPanel
		buttonPanel.add(createChar);
	}

}
