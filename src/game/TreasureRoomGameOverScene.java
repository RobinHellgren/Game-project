package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//game over scene for the treasure room
public class TreasureRoomGameOverScene extends Scene{
	public TreasureRoomGameOverScene(Player player) {
		super(player);
		//try to read text from file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("TreasureRoomGameOver.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//create button
		JButton cont = new JButton("Restart");
		//send the player back to the start of the game
		cont.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new IntroScene(player)));
			}

		});
		//add button to the gui
		buttonPanel.add(cont);

	}
}
