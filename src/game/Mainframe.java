package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class Mainframe {
	private SwitchSceneListener switchListener = new SwitchSceneListener() {
		@Override
		public void switchSceneEventOccured(SwitchSceneEvent event) {
			frame.remove(currentScene);
			currentScene = event.getScene();
			currentScene.addSwitchSceneListener(switchListener);
			currentScene.addAppendTextListener(appendListener);
			currentScene.addUpdateActorListener(statusListener);
			frame.add(currentScene);
			frame.revalidate();
			frame.repaint();
			System.out.println("Event: " + event.toString());	
		}
	};
	private AppendTextListener appendListener = new AppendTextListener() {
		@Override
		public void appendTextEventOccured(AppendTextEvent event) {
			currentScene.getTextPane().setText(currentScene.getTextPane().getText() + "/n /n" + event.getTextToAppend());
		}	
	};
	private UpdateActorStatusListener statusListener = new UpdateActorStatusListener() {
		@Override
		public void UpdateActorStatusEventOccured(UpdateActorStatusEvent event) {
			if(event.getType() == ActorType.PLAYER){
				playerPanel.updateField((Player)event.getActor());
				playerPanel.revalidate();
				playerPanel.repaint();
				}
			if(event.getType() == ActorType.ENEMY) {
				enemyPanel.updateField((Enemy)event.getActor());
				enemyPanel.revalidate();
				enemyPanel.repaint();
				}
			}
		
	};
	private Player player;
	private JFrame frame;
	private Scene currentScene;
	private PlayerStatusPanel playerPanel;
	private EnemyStatusPanel enemyPanel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe window = new Mainframe();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainframe() {
		initialize();
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 782, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		currentScene = new IntroScene(player);
		currentScene.addSwitchSceneListener(switchListener);
		currentScene.addAppendTextListener(appendListener);
		currentScene.addUpdateActorListener(statusListener);
		playerPanel = new PlayerStatusPanel();
		enemyPanel = new EnemyStatusPanel();
		frame.add(currentScene, BorderLayout.CENTER);
		frame.add(enemyPanel, BorderLayout.EAST);
		frame.add(playerPanel, BorderLayout.WEST);
	}

}
