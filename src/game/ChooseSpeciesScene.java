package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class ChooseSpeciesScene extends Scene{
	public ChooseSpeciesScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("SpeciesDes.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton humanBtn = new JButton("Human");
		JButton elfBtn = new JButton("Elf");
		JButton dwarfBtn = new JButton("Dwarf");
		humanBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.changeStrength(2);
				player.changeAgility(2);
				player.changeSmarts(4);
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseClassScene(player)));
			}
			
		});
		elfBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.changeStrength(2);
				player.changeAgility(4);
				player.changeSmarts(2);
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseClassScene(player)));
			}
			
		});
		dwarfBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				player.changeStrength(4);
				player.changeAgility(2);
				player.changeSmarts(2);
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseClassScene(player)));
			}
			
		});

		buttonPanel.add(humanBtn);
		buttonPanel.add(elfBtn);
		buttonPanel.add(dwarfBtn);


	}

}
