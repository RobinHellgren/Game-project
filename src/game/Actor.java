package game;
//Data structure that represents an actor in the game, this is a base class for the player and the enemies 
public abstract class Actor {
	protected String name;
	protected String playerClass;
	protected Integer strength;
	protected Integer agility;
	protected Integer smarts;
	protected Integer health;
	protected DieType damageDie;
	protected ActorType type;
	public Actor() {
		//Initilizes the variables contained in the actor classes to prevent null pointer exceptions
		super();
		this.name = "";
		this.strength = 0;
		this.agility = 0;
		this.smarts = 0;
		this.health = 0;
		this.damageDie = null;
		this.type = null;
	}
	//Getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStrength() {
		return strength;
	}
	public void changeStrength(Integer strength) {
		this.strength += strength;
	}
	public Integer getAgility() {
		return agility;
	}
	public void changeAgility(Integer agility) {
		this.agility += agility;
	}
	public Integer getSmarts() {
		return smarts;
	}
	public void changeSmarts(Integer smarts) {
		this.smarts += smarts;
	}
	public Integer getHealth() {
		return health;
	}
	public void changeHealth(Integer health) {
		this.health += health;
	}
	public Integer getDefence(){
		return 10+(agility/3);
	}
	public DieType getDamageDie() {
		return damageDie;
	}
	public void setDamageDie(DieType damageDie) {
		this.damageDie = damageDie;
	}
	public ActorType getType() {
		return type;
	}
}
