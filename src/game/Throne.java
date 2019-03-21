package game;
//definition of the throne enemy
public class Throne extends Enemy{
	public Throne() {
		this.name = "Throne";
		this.strength = 5;
		this.agility = 4;
		this.smarts = 0;
		this.health = 35;
		this.damageDie = DieType.D10;
	}
}
