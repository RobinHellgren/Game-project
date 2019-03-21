package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class GoblinGameOverScene extends Scene {

	public GoblinGameOverScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("GameOverGoblin.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton cont = new JButton("Restart");

		cont.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new IntroScene(player)));
			}

		});

		buttonPanel.add(cont);

	}

}
