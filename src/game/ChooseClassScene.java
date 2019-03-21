package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class ChooseClassScene extends Scene{

	public ChooseClassScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("ClassDes.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton fightBtn = new JButton("Fighter");
		JButton theifBtn = new JButton("Thief");
		JButton clericBtn = new JButton("Cleric");
		fightBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.changeStrength(2);
				player.changeAgility(1);
				player.changeSmarts(0);
				player.changeHealth(45);
				player.setDamageDie(DieType.D6);
				player.setPlayerClass("Fighter");
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseNameScene(player)));
			}
			
		});
		theifBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.changeStrength(0);
				player.changeAgility(2);
				player.changeSmarts(1);
				player.changeHealth(25);
				player.setDamageDie(DieType.D10);
				player.setPlayerClass("Thief");
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseNameScene(player)));
			}
			
		});
		clericBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.changeStrength(1);
				player.changeAgility(0);
				player.changeSmarts(2);
				player.changeHealth(35);
				player.setDamageDie(DieType.D8);
				player.setPlayerClass("Cleric");
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseNameScene(player)));
			}
			
		});

		buttonPanel.add(fightBtn);
		buttonPanel.add(theifBtn);
		buttonPanel.add(clericBtn);


	}
	
}
