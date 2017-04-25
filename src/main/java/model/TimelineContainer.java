package model;

import java.util.ArrayList;

import interfaces.ModelChangedListener;

/**
 * Main model class of the application. Holds all the timelines that are currently loaded into
 * the application and a reference to the currently active timeline, i.e. the one the user has opened and is working on.
 * 
 * Has methods for managing the list of timelines, for example adding a timeline.
 * 
 * Notifies MainController via the ModelChangedListener set in registerListener whenever a 
 * change occurs to the list of timelines.
 * 
 * @author Daniel Alm Grundstrom
 * @version 0.00.00
 * @name MainController.java
 */
public class TimelineContainer {

	private ModelChangedListener listener;
	private ArrayList<TimeLine> timelines;
	private TimeLine activeTimeline;
	
	public TimelineContainer() {
		timelines = new ArrayList<TimeLine>();
	}
	
	/**
	 * Adds a timeline to this TimelineContainer.
	 */
	public void addTimeline(TimeLine timeline) {
		System.out.println("TimelineContainer: Request to add timeline received");
		
		timelines.add(timeline);
		activeTimeline = timeline; // Set the newly added timeline to be the active one
		
		listener.onModelChanged(timelines, activeTimeline); // tell listener that a timeline has been added
	}
	
	/**
	 * Fetches the currently active timeline. The active timeline is the timeline the user has selected in the 
	 * list of timelines and the one that is currently displayed in the view.
	 *  
	 * @return the active timeline
	 */
	public TimeLine getActiveTimeline() {
		return activeTimeline;
	}
	
	/**
	 * Registers an object as a listener to this TimelineContainer. It will then be notified
	 * whenever a change occurs to the timelines.
	 * 
	 * @param listener - the listener to register, must implement the interface ModelChangedListener
	 */
	public void registerListener(ModelChangedListener listener) {
		this.listener = listener;
	}
}