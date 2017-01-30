package ducdarren.kwic.model;

import java.util.Observable;

import ducdarren.kwic.commons.events.ListChangedEvent;

public class TitlesWrapper extends Observable {
	TitlesList titlesList = new TitlesList();
	
	public void addTitle(String title) {
		titlesList.addTitle(title);
		ListChangedEvent addedToListEvent = new ListChangedEvent();
		broadcastChange(addedToListEvent);
	}
	
	private void broadcastChange(ListChangedEvent event) {
	    setChanged();
	    notifyObservers(event);
	}
}
