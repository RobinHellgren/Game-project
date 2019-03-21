package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//The goblin gameover scene
public class GoblinGameOverScene extends Scene {

	public GoblinGameOverScene(Player player) {
		super(player);
		//try to read text from file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("GameOverGoblin.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//create button
		JButton restart = new JButton("Restart");
		//add behaviour
		restart.addActionListener(new ActionListener() {
			//restart the game
			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new IntroScene(player)));
			}

		});

		buttonPanel.add(restart);

	}

}
