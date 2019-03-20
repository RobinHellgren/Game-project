package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import tools.DieBag;

public abstract class CombatScene extends Scene{
	private Player player;
	private Enemy enemy;
	private CombatEngine engine;
	private JButton attackBtn;
	private JButton defendBtn;
	public CombatScene(Player player, Enemy enemy) {
		super(player);
		engine = new CombatEngine(player, enemy);
		this.player = player;
		this.enemy = enemy;
		
		attackBtn = new JButton("Attack");
		attackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(engine.attackAction(ActorType.PLAYER)) {
					fireAppendTextEvent(new AppendTextEvent(this, player.getName() + " attacks dealing " + engine.getDamageDealt()));
				}
				else {
					fireAppendTextEvent(new AppendTextEvent(this, player.getName() + " attacks but misses"));
				}
				fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, enemy));
				enemyAction();
			}
			
		});
		defendBtn = new JButton("Defend");
		defendBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				engine.defenceAction(ActorType.PLAYER);
				fireAppendTextEvent(new AppendTextEvent(this, player.getName() + " defends themselves"));
				if(enemy.getHealth()<= 0) {
					victory();
				}
				enemyAction();
				if(player.getHealth()<= 0) {
					defeat();
				}
			}
			
		});
		buttonPanel.add(attackBtn);
		buttonPanel.add(defendBtn);
		
	}
	private void enemyAction() {
		if(DieBag.rolld10(1) > 5) {
			if(engine.attackAction(ActorType.ENEMY)) {
				fireAppendTextEvent(new AppendTextEvent(this, enemy.getName() + " attacks dealing " + engine.getDamageDealt()));
			}
			else {
				fireAppendTextEvent(new AppendTextEvent(this, enemy.getName() + " attacks but misses"));
			}
			fireUpdateActorEventEvent(new UpdateActorStatusEvent(this, player));
		}
		else {
			engine.defenceAction(ActorType.ENEMY);
			fireAppendTextEvent(new AppendTextEvent(this, enemy.getName() + " defends themselves"));
		}
	}
	protected abstract void victory();
	protected abstract void defeat();
}
