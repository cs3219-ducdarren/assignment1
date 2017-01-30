package ducdarren.kwic.implicit.logic.shifter;

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
			toShift.addFirst(s);
		}
		// perform circular shift
		for (int i = 0; i < toShift.size(); i++) {
			if (ignoreList.contains(toShift.getFirst())) {
				continue;
			} else {
				circularsList.addTitle(toShift);
				String previousHead = toShift.getFirst();
				toShift.removeFirst();
				toShift.add(previousHead);
			}
		}

	}
}
