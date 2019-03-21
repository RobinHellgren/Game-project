package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class ThroneRoomClearedScene extends Scene{
	public ThroneRoomClearedScene(Player player) {
		super(player);
		player.setDefeatedThrone(true);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("ThroneRoomCleared.txt"));
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
