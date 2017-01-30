package ducdarren.kwic.implicit.model;

import java.util.LinkedList;
import java.util.Observable;

import ducdarren.kwic.implicit.commons.events.ListChangedEvent;

public class TitlesWrapper extends Observable {
	TitlesList titlesList = new TitlesList();
	
	public void addTitle(String title) {
		titlesList.addTitle(title);
		ListChangedEvent addedToListEvent = new ListChangedEvent();
		broadcastChange(addedToListEvent);
	}
	
	public void addTitle(LinkedList<String> title) {
		titlesList.addTitle(title);
		ListChangedEvent addedToListEvent = new ListChangedEvent();
		broadcastChange(addedToListEvent);
	}
	
	public LinkedList<String> getAllTitles() {
		return titlesList.getAllTitlesAsString();
	}
	
	public LinkedList<LinkedList<String>> getAllTitlesRaw() {
		return titlesList.getRawData();
	}
	
	public void setData(LinkedList<String> newData) {
		titlesList.setData(newData);
	}
	
	private void broadcastChange(ListChangedEvent event) {
	    setChanged();
	    notifyObservers(event);
	}
}
