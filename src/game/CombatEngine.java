package game;

import tools.DieBag;

public class CombatEngine {
	private Player player;
	private Enemy enemy;
	private int damageDealt;
	private int playerDefence;
	private int enemyDefence;
	

	public CombatEngine(Player player, Enemy enemy) {
		this.player = player;
		this.enemy = enemy;
		playerDefence = player.getDefence();
		enemyDefence = enemy.getDefence();
	}
	public  int getDamageDealt() {
		return damageDealt;
	}
	public boolean attackAction(ActorType actor) {
		boolean outcome = false;
		if (actor == ActorType.PLAYER) {
			if (DieBag.rolld20(1) + player.getStrength() > enemyDefence) {
				if (player.getDamageDie() == DieType.D6) {
					damageDealt = (DieBag.rolld6(1) + (player.getStrength() / 2));
					enemy.changeHealth(-damageDealt);
					outcome = true;
				} else if (player.getDamageDie() == DieType.D8) {
					damageDealt = (DieBag.rolld8(1) + (player.getStrength() / 2));
					enemy.changeHealth(-damageDealt);
					outcome = true;
				} else if (player.getDamageDie() == DieType.D10) {
					damageDealt = (DieBag.rolld10(1) + (player.getStrength() / 2));
					enemy.changeHealth(-(DieBag.rolld10(1) + (player.getStrength() / 2)));
					outcome = true;
				}
			}

		}
		if (actor == ActorType.ENEMY) {
			if (DieBag.rolld20(1) + enemy.getStrength() > playerDefence) {
				if (player.getDamageDie() == DieType.D6) {
					damageDealt = (DieBag.rolld6(1) + (enemy.getStrength() / 2));
					player.changeHealth(-damageDealt);
					outcome = true;
				} else if (player.getDamageDie() == DieType.D8) {
					damageDealt = (DieBag.rolld8(1) + (enemy.getStrength() / 2));
					player.changeHealth(-damageDealt);
					outcome = true;
				} else if (player.getDamageDie() == DieType.D10) {
					damageDealt = (DieBag.rolld10(1) + (enemy.getStrength() / 2));
					player.changeHealth(-damageDealt);
					outcome = true;
				}
			}

		}
		restoreDefence(actor);
		return outcome;
	}
	public void defenceAction(ActorType actor) {
		if(actor == ActorType.PLAYER) {
			playerDefence = (int) (player.getDefence()*1.3);
		}
		if(actor == ActorType.ENEMY) {
			enemyDefence = (int)(enemy.getDefence()*1.3);
		}
	}
	private void restoreDefence(ActorType actor) {
		if(actor == ActorType.PLAYER) {
			playerDefence = player.getDefence();
		}
		if(actor == ActorType.ENEMY) {
			enemyDefence = enemy.getDefence();
		}
	}
}
