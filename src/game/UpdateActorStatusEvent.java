package game;

import java.util.EventObject;
//Event that contains the actor who's status planel should be updated and what type of actor they are
public class UpdateActorStatusEvent extends EventObject{
	Actor actor;
	ActorType type;
	public UpdateActorStatusEvent(Object source, Actor actor) {
		super(source);
		this.actor = actor;
		this.type = actor.getType();
	}
	//getters
	public Actor getActor() {
		return actor;
	}
	public ActorType getType() {
		return type;
	}
}
