package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;
//A subclass of scene for a specific scene
public class ChooseSpeciesScene extends Scene{
	public ChooseSpeciesScene(Player player) {
		super(player);
		//Reset the players state
		resetPlayerState();
		//attempts to read the flavor text from a text file
		try {
			textPane.setText(TextFileReader.getInstance().readFile("SpeciesDes.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//Create scene buttons 
		JButton humanBtn = new JButton("Human");
		JButton elfBtn = new JButton("Elf");
		JButton dwarfBtn = new JButton("Dwarf");
		//Add behaviour to the button
		humanBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Changes the players stats according to the choosen class
				player.changeStrength(2);
				player.changeAgility(2);
				player.changeSmarts(4);
				//Switch scene to the next one and update the players stat panel
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseClassScene(player)));
			}
			
		});
		elfBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Changes the players stats according to the choosen class
				player.changeStrength(2);
				player.changeAgility(4);
				player.changeSmarts(2);
				//Switch scene to the next one and update the players stat panel
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseClassScene(player)));
			}
			
		});
		dwarfBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Changes the players stats according to the choosen class
				player.changeStrength(4);
				player.changeAgility(2);
				player.changeSmarts(2);
				//Switch scene to the next one and update the players stat panel
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ChooseClassScene(player)));
			}
			
		});
		//add the button to the buttonPanel
		buttonPanel.add(humanBtn);
		buttonPanel.add(elfBtn);
		buttonPanel.add(dwarfBtn);


	}
	//Function that resets the player
	private void resetPlayerState() {
		player.resetPLayerStats();
		player.setClearedTreasureRoom(false);
		player.setDefeatedGoblin(false);
		player.setDefeatedThrone(false);
		player.setFoundDairy(false);
		player.setKnowsAnswerToRiddle(false);
		fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
	}

}
