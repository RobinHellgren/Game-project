package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tools.DieBag;
//Abstract sub class of scene that handles combats scenes
public abstract class CombatScene extends Scene {
	protected Player player;
	private Enemy enemy;
	private CombatEngine engine;
	private JButton attackBtn;
	private JButton defendBtn;
	//Scene variables that store the victory and defeat scene
	protected Scene victoryScene;
	protected Scene defeatScene;

	public CombatScene(Player player, Enemy enemy) {
		super(player);
		//Create a new combat engine to handle the data manipulation
		engine = new CombatEngine(player, enemy);
		this.player = player;
		this.enemy = enemy;
		//Create the button for attacking 
		attackBtn = new JButton("Attack");
		//Define button behaviour
		attackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//If the attack hits
				if (engine.attackAction(ActorType.PLAYER)) {
					//print message to the text box
					fireAppendTextEvent(new AppendTextEvent(this,
							player.getName() + " attacks dealing " + engine.getDamageDealt() + " damage"));
				}
				//If the attack misses
				else {
					//print message to the text box
					fireAppendTextEvent(new AppendTextEvent(this, player.getName() + " attacks but misses"));
				}
				//Update the enemy status box in the UI
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, enemy));
				//If the enemy has less than 1 health...
				if (enemy.getHealth() < 1) {
					//and if the player has less than 1 health
					if (player.getHealth() < 1) {
						//Trigger the defeat scene
						defeat();
					}
					//and if the player has more than 1 health
					if (player.getHealth() > 1) {
						//trigger the victory scene
						victory();
					}
				}
				//If the player has less than 1 health but the enemy is still alive..
				if (player.getHealth() < 1) {
					//trigger the defeat scene
					defeat();
				}
				//If the enemy has more than 1 health execute its combat turn 
				if(enemy.getHealth() > 0) {
					enemyAction();
				}

			}

		});
		//Create defend button
		defendBtn = new JButton("Defend");
		//define button behaviour
		defendBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Execute a defend action for the player
				engine.defenceAction(ActorType.PLAYER);
				//Update the UI
				fireAppendTextEvent(new AppendTextEvent(this, player.getName() + " defends themselves"));
				//If the enemy has less than 1 health...
				if (enemy.getHealth() < 1) {
					//and if the player has less than 1 health
					if (player.getHealth() < 1) {
						//Trigger the defeat scene
						defeat();
					}
					//and if the player has more than 1 health
					if (player.getHealth() > 1) {
						//trigger the victory scene
						victory();
					}
				}
				//If the player has less than 1 health but the enemy is still alive..
				if (player.getHealth() < 1) {
					//trigger the defeat scene
					defeat();
				}
				//If the enemy has more than 1 health execute its combat turn 
				if(enemy.getHealth() > 0) {
					enemyAction();
				}
			}

		});
		//Add button to the button panel
		buttonPanel.add(attackBtn);
		buttonPanel.add(defendBtn);

	}
	//Trigger the enemy's turn
	private void enemyAction() {
		//If the die is 6 or more the enemy attacks  
		if (DieBag.rolld10(1) > 5) {
			//If the attack hits
			if (engine.attackAction(ActorType.ENEMY)) {
				//Send a message to the text box
				fireAppendTextEvent(new AppendTextEvent(this,
						enemy.getName() + " attacks dealing " + engine.getDamageDealt() + " damage"));
			}
			//If the attack misses
			else {
				//Send a message to the text box
				fireAppendTextEvent(new AppendTextEvent(this, enemy.getName() + " attacks but misses"));
			}
			//Update the players status box
			fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
		}
		//If the die is 5 or less 
		else {
			//The enemy defends 
			engine.defenceAction(ActorType.ENEMY);
			//send a message to the message box
			fireAppendTextEvent(new AppendTextEvent(this, enemy.getName() + " defends themselves"));
		}
	}
	//If the player wins switch to the victory scene
	protected void victory() {
		fireSwitchSceneEvent(new SwitchSceneEvent(this, victoryScene));
	}
	//If the player loses switch to the defeat scene
	protected void defeat() {
		fireSwitchSceneEvent(new SwitchSceneEvent(this, defeatScene));
	}
}
