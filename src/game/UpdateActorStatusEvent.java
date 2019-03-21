package game;

import java.util.EventObject;

public class UpdateActorStatusEvent extends EventObject{
	Actor actor;
	ActorType type;
	public UpdateActorStatusEvent(Object source, Actor actor) {
		super(source);
		this.actor = actor;
		this.type = actor.getType();
	}
	public Actor getActor() {
		return actor;
	}
	public ActorType getType() {
		return type;
	}
}
