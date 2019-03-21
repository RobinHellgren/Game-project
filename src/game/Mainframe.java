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
//Created with window builder, the main window of the game. The listeners are implemented here and it contains the other gui components
public class Mainframe {
	//event listener that handles scene switching
	private SwitchSceneListener switchListener = new SwitchSceneListener() {
		@Override
		public void switchSceneEventOccured(SwitchSceneEvent event) {
			//remove the current scene from the gui
			frame.remove(currentScene);
			//set the current scene to the one from the event
			currentScene = event.getScene();
			//add the listeners
			currentScene.addSwitchSceneListener(switchListener);
			currentScene.addAppendTextListener(appendListener);
			currentScene.addUpdateActorListener(statusListener);
			//add it to the gui
			frame.add(currentScene);
			//refresh the gui
			frame.revalidate();
			frame.repaint();
		}
	};
	//listener that appends text to the text box
	private AppendTextListener appendListener = new AppendTextListener() {
		@Override
		public void appendTextEventOccured(AppendTextEvent event) {
			//set the text in the text box to the current text plus the text from the event
			currentScene.getTextPane().setText(currentScene.getTextPane().getText() + "\n \n" + event.getTextToAppend());
		}	
	};
	//listener that updates the status panels in the gui
	private UpdateActorStatusListener statusListener = new UpdateActorStatusListener() {
		@Override
		public void UpdateActorStatusEventOccured(UpdateActorStatusEvent event) {
			//if the actor type in the event defines player; update the player panel
			if(event.getType() == ActorType.PLAYER){
				playerPanel.updateField((Player)event.getActor());
				playerPanel.revalidate();
				playerPanel.repaint();
				}
			//if the actor type in the event defines enemy; update the enemy panel
			if(event.getType() == ActorType.ENEMY) {
				enemyPanel.updateField(event.getActor());
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
	//main function
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//create the mainframe and make it visible
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
		//initilize the components
		initialize();
		//start the game maximized
		frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		player = new Player();
		frame = new JFrame();
		frame.setBounds(100, 100, 782, 597);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		currentScene = new IntroScene(player);
		currentScene.addSwitchSceneListener(switchListener);
		currentScene.addAppendTextListener(appendListener);
		currentScene.addUpdateActorListener(statusListener);
		currentScene.addUpdateActorListener(statusListener);
		playerPanel = new PlayerStatusPanel();
		enemyPanel = new EnemyStatusPanel();
		frame.add(currentScene, BorderLayout.CENTER);
		frame.add(enemyPanel, BorderLayout.EAST);
		frame.add(playerPanel, BorderLayout.WEST);
		
		
	}

}
