package game;

public abstract class Actor {
	protected String name;
	protected Integer strength;
	protected Integer agility;
	protected Integer smarts;
	protected Integer health;
	protected DieType damageDie;
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
		return 10+(agility/10);
	}
	public DieType getDamageDie() {
		return damageDie;
	}
	public void setDamageDie(DieType damageDie) {
		this.damageDie = damageDie;
	}
}
