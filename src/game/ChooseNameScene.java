package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JTextField;

import tools.TextFileReader;

public class ChooseNameScene extends Scene{
	public ChooseNameScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("NameDes.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton contBtn = new JButton("Continue");
		JTextField nameField = new JTextField(35);
		
		
		contBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.setName(nameField.getText());
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new DungeonRoomScene(player)));
			}
			
		});
		buttonPanel.add(nameField);
		buttonPanel.add(contBtn);
	}
}
