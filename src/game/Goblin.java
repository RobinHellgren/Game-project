package game;

public class Goblin extends Enemy{
	public Goblin() {
		this.name = "Goblin";
		this.strength = 2;
		this.agility = 1;
		this.smarts = -2;
		this.health = 15;
		this.damageDie = DieType.D6;
	}

}
