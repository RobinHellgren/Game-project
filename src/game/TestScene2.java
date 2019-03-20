package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class TestScene2 extends Scene{
	public TestScene2(Player player) {
		super(player);
		textPane.setText("Test 2");
		JButton test1 = new JButton("test1");
		JButton test2 = new JButton("Intro");
		
		test1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new TestScene1(player)));
			}
			
		});
		test2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				fireSwitchSceneEvent(new SwitchSceneEvent(this, new IntroScene(player)));
			}
			
		});
		buttonPanel.add(test1);
		buttonPanel.add(test2);
	}

}

