package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;

import tools.TextFileReader;

public class DiningRoomScene extends Scene{
	public DiningRoomScene(Player player) {
		super(player);
		try {
			textPane.setText(TextFileReader.getInstance().readFile("DiningRoom.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		JButton darkDoor = new JButton("Dark doorway");
		JButton ornateDoor = new JButton("Ornate door");

		if(!player.isFoundDairy()) {
			fireAppendTextEvent(new AppendTextEvent(this, "On the table a strange tome rests"));
			JButton diaryBtn = new JButton("Strange tome");
			diaryBtn.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					try {
						fireAppendTextEvent(new AppendTextEvent(this, TextFileReader.getInstance().readFile("ReadDiary.txt")));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					player.setFoundDairy(true);
				}
				
			});
			buttonPanel.add(diaryBtn);
		}
		
		darkDoor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(player.isDefeatedGoblin()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ClearedGoblinRoom(player)));	
				}
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new GoblinCombatScene(player, new Goblin())));
				}
			}
			
		});
		ornateDoor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(player.isDefeatedThrone()) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ThroneRoomClearedScene(player)));	
				}
				else {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new ThroneRoomScene(player)));
				}
			}
			
		});

		buttonPanel.add(darkDoor);
		buttonPanel.add(ornateDoor);

	}

}
