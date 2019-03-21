package game;

import tools.DieBag;

public class CombatEngine {
	private Player player;
	private Enemy enemy;
	private int damageDealt;
	private int playerDefence;
	private int enemyDefence;
	
	//This class handles the data manipulation of the combat system
	public CombatEngine(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
		playerDefence = player.getDefence();
		enemyDefence = enemy.getDefence();
	}
	//Returns the damage dealt in the last combat action
	public  int getDamageDealt() {
		return damageDealt;
	}
	//Function that returns true if the attack hits and false if it misses
	public boolean attackAction(ActorType actor) {
		boolean outcome = false;
		//Generate a d20 die roll
		int dieResult = DieBag.rolld20(1);
		//If the ActorType variable is of the type PLAYER then execute a player turn.
		if (actor == ActorType.PLAYER) {
			//Check if the attack is successful
			if (dieResult + player.getStrength() > enemyDefence) {
				//Check what die type the actor is using
				if (player.getDamageDie() == DieType.D6) {
					//Determine the damage dealt
					damageDealt = (DieBag.rolld6(1) + player.getStrength());
					//Change the opponents health 
					enemy.changeHealth(-damageDealt);
					//set outcome to true because the attack hit
					outcome = true;
				} else if (player.getDamageDie() == DieType.D8) {
					damageDealt = (DieBag.rolld8(1) + player.getStrength());
					enemy.changeHealth(-damageDealt);
					outcome = true;
				} else if (player.getDamageDie() == DieType.D10) {
					damageDealt = (DieBag.rolld10(1) + player.getStrength());
					enemy.changeHealth(-(DieBag.rolld10(1) + player.getStrength()));
					outcome = true;
				}
			}

		}
		//If the ActorType variable is of the type ENEMY then execute a player turn.
		if (actor == ActorType.ENEMY) {
			//Check if the attack is successful
			if (dieResult + enemy.getStrength() > playerDefence) {
				//Check what die type the actor is using
				if (enemy.getDamageDie() == DieType.D6) {
					//Determine the damage dealt
					damageDealt = (DieBag.rolld6(1) + enemy.getStrength());
					//Change the opponents health 
					player.changeHealth(-damageDealt);
					//set outcome to true because the attack hit
					outcome = true;
				} else if (enemy.getDamageDie() == DieType.D8) {
					damageDealt = (DieBag.rolld8(1) + enemy.getStrength());
					player.changeHealth(-damageDealt);
					outcome = true;
				} else if (enemy.getDamageDie() == DieType.D10) {
					damageDealt = (DieBag.rolld10(1) + enemy.getStrength());
					player.changeHealth(-damageDealt);
					outcome = true;
				}
			}

		}
		//Remove the bonus from the defence action
		restoreDefence(actor);
		//return the boolean
		return outcome;
	}
	//Function that increases the defence of the actor if they choose to defend themselves
	public void defenceAction(ActorType actor) {
		//If the actor typ is player increase the players defence
		if(actor == ActorType.PLAYER) {
			playerDefence = (int) (player.getDefence()*1.5);
		}
		//If the actor typ is enemy increase the enemy's defence
		if(actor == ActorType.ENEMY) {
			enemyDefence = (int)(enemy.getDefence()*1.5);
		}
	}
	//Remove the defence bonus
	private void restoreDefence(ActorType actor) {
		if(actor == ActorType.PLAYER) {
			playerDefence = player.getDefence();
		}
		if(actor == ActorType.ENEMY) {
			enemyDefence = enemy.getDefence();
		}
	}
}
