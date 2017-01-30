package ducdarren.kwic.implicit.logic.shifter;
/**
 * @author A0144750J
 * This class handles the circular shift of a title following the KWIC principle
 * Its main function is called when a ListChangedEvent is dispatched by the list
 * of titles
 */
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import ducdarren.kwic.implicit.model.TitlesWrapper;

public class CircularShifter implements Observer{
	
	private LinkedList<String> ignoreList;
	private TitlesWrapper circularsList;
	
	public CircularShifter(LinkedList<String> ignoreList, TitlesWrapper circularsList) {
		this.ignoreList = ignoreList;
		this.circularsList = circularsList;
	}
	
	public void update(Observable observable, Object data) {
		TitlesWrapper titlesList = (TitlesWrapper) observable;
		// Get the last title i.e. just added
		LinkedList<LinkedList<String>> titlesListRaw = titlesList.getAllTitlesRaw();
		LinkedList<String> title = titlesListRaw.get(titlesListRaw.size() - 1);
		// clone the list
		LinkedList<String> toShift = new LinkedList<String>();
		for (String s : title) {
			toShift.add(s);
		}
		// perform circular shift following KWIC principle
		for (int i = 0; i < toShift.size(); i++) {
			if (isIgnore(toShift.getFirst())) {
				String previousHead = toShift.getFirst();
				toShift.removeFirst();
				toShift.add(previousHead);
			} else {
				circularsList.addTitle(toShift);
				String previousHead = toShift.getFirst();
				toShift.removeFirst();
				toShift.add(previousHead);
			}
		}
	}
	// helper function to scan for ingored words
	private boolean isIgnore(String head) {
		for (String s : ignoreList) {
			if (s.equalsIgnoreCase(head)) {
				return true;
			}
		}
		return false;
	}
}
