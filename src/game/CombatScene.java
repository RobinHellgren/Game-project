package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tools.DieBag;

public abstract class CombatScene extends Scene {
	protected Player player;
	private Enemy enemy;
	private CombatEngine engine;
	private JButton attackBtn;
	private JButton defendBtn;
	protected Scene victoryScene;
	protected Scene defeatScene;

	public CombatScene(Player player, Enemy enemy) {
		super(player);
		engine = new CombatEngine(player, enemy);
		this.player = player;
		this.enemy = enemy;

		attackBtn = new JButton("Attack");
		attackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (engine.attackAction(ActorType.PLAYER)) {
					fireAppendTextEvent(new AppendTextEvent(this,
							player.getName() + " attacks dealing " + engine.getDamageDealt() + " damage"));
				} else {
					fireAppendTextEvent(new AppendTextEvent(this, player.getName() + " attacks but misses"));
				}
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, enemy));
				if (enemy.getHealth() < 1) {
					System.out.println("Player won");
					victory();
				}
				if (player.getHealth() < 1) {
					System.out.println("Player lost");
					defeat();
				}
				enemyAction();
			}

		});
		defendBtn = new JButton("Defend");
		defendBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				engine.defenceAction(ActorType.PLAYER);
				fireAppendTextEvent(new AppendTextEvent(this, player.getName() + " defends themselves"));
				enemyAction();
				if (enemy.getHealth() < 1) {
					System.out.println("Player won");
					victory();
				}

				if (player.getHealth() < 1) {
					System.out.println("Player lost");
					defeat();
				}
				enemyAction();
			}

		});
		buttonPanel.add(attackBtn);
		buttonPanel.add(defendBtn);

	}

	private void enemyAction() {
		if (DieBag.rolld10(1) > 5) {
			if (engine.attackAction(ActorType.ENEMY)) {
				fireAppendTextEvent(new AppendTextEvent(this,
						enemy.getName() + " attacks dealing " + engine.getDamageDealt() + " damage"));
			} else {
				fireAppendTextEvent(new AppendTextEvent(this, enemy.getName() + " attacks but misses"));
			}
			fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
		} else {
			engine.defenceAction(ActorType.ENEMY);
			fireAppendTextEvent(new AppendTextEvent(this, enemy.getName() + " defends themselves"));
		}
	}

	protected void victory() {
		System.out.println("Gob ded");
		player.setDefeatedGoblin(true);
		fireSwitchSceneEvent(new SwitchSceneEvent(this, victoryScene));
	}

	protected void defeat() {
		fireSwitchSceneEvent(new SwitchSceneEvent(this, defeatScene));
	}
}
