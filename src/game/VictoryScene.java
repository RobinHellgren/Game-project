package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class VictoryScene extends Scene{
	public VictoryScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("Victory.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton cont = new JButton("Victory!");
		
		cont.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});

		buttonPanel.add(cont);

	}

}
