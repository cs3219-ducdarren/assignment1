package ducdarren.kwic.commons.io;

import java.util.LinkedList;

import ducdarren.kwic.implicit.model.TitlesWrapper;

public class Output {
	
	public void print(TitlesWrapper circularsList) {
		LinkedList<String> outputList = circularsList.getAllTitles();
		for (String s : outputList) {
			System.out.println(s);
		}
	}
	
}
