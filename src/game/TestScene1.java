package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TestScene1 extends Scene{
	public TestScene1(Player player) {
		super(player);
		textPane.setText("Test 1");
		JButton test1 = new JButton("Intro");
		JButton test2 = new JButton("test2");
		
		test1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new IntroScene(player)));
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

