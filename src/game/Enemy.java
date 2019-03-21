package game;
//abstract actor subclass used for enemies
public abstract class Enemy extends Actor{
	public Enemy() {
		//set the actor type to enemy
		this.type = ActorType.ENEMY;
	}
}
