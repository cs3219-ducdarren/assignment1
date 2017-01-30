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
		// perform circular shifts
		for (int i = 0; i < titlesListRaw.size(); i++) {
			
		}

	}
}