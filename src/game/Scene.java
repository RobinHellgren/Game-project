package game;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.event.EventListenerList;
import java.awt.Font;

public class Scene extends JPanel {
	//listener list to contain the listeners
	private EventListenerList listenerList = new EventListenerList();
	protected JTextPane textPane;
	protected JPanel buttonPanel;
	protected String textFileMapPath;
	protected Player player;
	/**
	 * Create the panel and instanziate the varibles.
	 */
	public Scene(Player player) {
		setLayout(new BorderLayout(0, 0));
		
		buttonPanel = new JPanel();
		add(buttonPanel, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		textPane = new JTextPane();
		//set font and font size of the text box
		textPane.setFont(new Font("Lucida Bright", Font.PLAIN, 20));
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		this.player = player;
		
		

	}
	//getter
	public JTextPane getTextPane() {
		return textPane;
	}
	//add/remove functions for the listeners
	public void addSwitchSceneListener(SwitchSceneListener listener) {
		listenerList.add(SwitchSceneListener.class, listener);
	}
	public void removeSwitchSceneListener(SwitchSceneListener listener) {
		listenerList.remove(SwitchSceneListener.class, listener);
	}
	public void addAppendTextListener(AppendTextListener listener) {
		listenerList.add(AppendTextListener.class, listener);
	}
	public void removeAppendTextListener(AppendTextListener listener) {
		listenerList.remove(AppendTextListener.class, listener);
	}
	public void addUpdateActorListener(UpdateActorStatusListener listener) {
		listenerList.add(UpdateActorStatusListener.class, listener);
	}
	public void removeUpdateActorListener(UpdateActorStatusListener listener) {
		listenerList.remove(UpdateActorStatusListener.class, listener);
	}
	//fire event functions to send events to the mainframe
	protected void fireSwitchSceneEvent(SwitchSceneEvent event) {
		//Creates an Object array which containts all the listeners
		Object[] listeners = listenerList.getListenerList();
		//For loop that looks through the array for the specific listener that should receive the event
		for(int i=0; i<listeners.length; i+=2) {
			if(listeners[i] == SwitchSceneListener.class) {
				//Cast the generic listener to the correct one to call the correct method
				((SwitchSceneListener)listeners[i+1]).switchSceneEventOccured(event);
			}
		}
	}
	protected void fireAppendTextEvent(AppendTextEvent event) {
		//Creates an Object array which containts all the listeners
		Object[] listeners = listenerList.getListenerList();
		//For loop that looks through the array for the specific listener that should receive the event
		for(int i=0; i<listeners.length; i+=2) {
			if(listeners[i] == AppendTextListener.class) {
				//Cast the generic listener to the correct one to call the correct method
				((AppendTextListener)listeners[i+1]).appendTextEventOccured(event);
			}
		}
	}
	protected void fireUpdateActorEventEvent(UpdateActorStatusEvent event) {
		//Creates an Object array which containts all the listeners
		Object[] listeners = listenerList.getListenerList();
		//For loop that looks through the array for the specific listener that should receive the event
		for(int i=0; i<listeners.length; i+=2) {
			if(listeners[i] == UpdateActorStatusListener.class) {
				//Cast the generic listener to the correct one to call the correct method
				((UpdateActorStatusListener)listeners[i+1]).UpdateActorStatusEventOccured(event);
			}
		}
	}

}
