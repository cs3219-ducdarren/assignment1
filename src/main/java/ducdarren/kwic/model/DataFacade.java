package main.java.ducdarren.kwic.model;

import java.util.Observable;

import main.java.ducdarren.kwic.commons.events.DataChangedEvent;

public class DataFacade extends Observable {

	public void addLine(String line) {
	}
	public void getCirculars() {
	}
	public void broadcastChangeEvent(DataChangedEvent event) {
		setChanged();
		notifyObservers(event);
	}
}
