package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//subclass of scene for specific scene
public class ThroneGameOverScene extends Scene{
	public ThroneGameOverScene(Player player) {
		super(player);
		//try to read text from file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("ThroneRoomGameOver.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//create button
		JButton cont = new JButton("Restart");
		//send the player to the start of the game
		cont.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new IntroScene(player)));
			}

		});
		//add buttons to the scene
		buttonPanel.add(cont);

	}
}
