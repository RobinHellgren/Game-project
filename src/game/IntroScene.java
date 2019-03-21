package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;

import tools.TextFileReader;

public class IntroScene extends Scene{
	public IntroScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("Intro.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton cont = new JButton("Continue");
		
		cont.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ApproachScene(player)));
			}
			
		});

		buttonPanel.add(cont);

	}

}
