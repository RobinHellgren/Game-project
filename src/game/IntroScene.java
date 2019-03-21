package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;

import tools.TextFileReader;
//specific scene
public class IntroScene extends Scene{
	public IntroScene(Player player) {
		super(player);
		//try to read text from file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("Intro.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//create the button
		JButton cont = new JButton("Continue");
		//send the player to the next scene
		cont.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ApproachScene(player)));
			}
			
		});
		//add button to scene
		buttonPanel.add(cont);

	}

}
