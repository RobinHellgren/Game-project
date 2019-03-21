package game;
//specific enemy class
public class Goblin extends Enemy{
	public Goblin() {
		//define the attributes of the goblin
		this.name = "Goblin";
		this.strength = 2;
		this.agility = 1;
		this.smarts = -2;
		this.health = 15;
		this.damageDie = DieType.D6;
	}

}
