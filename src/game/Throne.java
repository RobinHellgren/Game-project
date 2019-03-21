package game;

public class Throne extends Enemy{
	public Throne() {
		this.name = "Throne";
		this.strength = 18;
		this.agility = 4;
		this.smarts = 0;
		this.health = 35;
		this.damageDie = DieType.D10;
	}
}
