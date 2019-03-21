package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//the victory scene
public class VictoryScene extends Scene{
	public VictoryScene(Player player) {
		super(player);
		//read text from file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("Victory.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//create button
		JButton cont = new JButton("Victory!");
		//close the application
		cont.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		//add buttons to gui
		buttonPanel.add(cont);

	}

}
