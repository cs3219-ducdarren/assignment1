package ducdarren.kwic.commons.io;
/**
 * @author A0144570J
 * This class handles the output of data 
 * Currently it prints all shifted strings on the console
 */
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
