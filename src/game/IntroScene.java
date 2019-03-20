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
		JButton test1 = new JButton("test1");
		JButton test2 = new JButton("test2");
		
		test1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TestScene1(player)));
			}
			
		});
		test2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TestScene2(player)));
			}
			
		});
		buttonPanel.add(test1);
		buttonPanel.add(test2);
	}

}
