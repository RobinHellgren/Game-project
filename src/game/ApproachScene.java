package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class ApproachScene extends Scene{

	public ApproachScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("Approach.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton createChar = new JButton("Create character");
		
		createChar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseSpeciesScene(player)));
			}
			
		});
		buttonPanel.add(createChar);
	}

}
