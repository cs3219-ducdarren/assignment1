package ducdarren.kwic.implicit.model;
/**
 * @author A0144750J
 * This class represents the basic database of the software
 * It contains a LinkedList of LinkeList<String>
 * and helper methods to add and get data of different forms
 * at a lowerer level of data. 
 * It can also perform data conversion between types
 */
import java.util.LinkedList;

public class TitlesList {
	
	LinkedList<LinkedList<String>> titles = new LinkedList<LinkedList<String>>();
	
	protected void addTitle(LinkedList<String> title) {
		titles.add(title);
	}
	
	protected void addTitle(String title) {
		this.addTitle(tokenize(title));
	}
	
	protected LinkedList<String> getAllTitlesAsString() {
		LinkedList<String> result = new LinkedList<String>();
		for (LinkedList<String> stringList : titles) {
			result.add(combine(stringList));
		}
		return result;
	}
	
	protected int getLength() {
		return titles.size();
	}
	
	protected void setData(LinkedList<String> newList) {
		titles = new LinkedList<LinkedList<String>>();
		for (String s : newList) {
			titles.add(tokenize(s));
		}
	}
	
	protected LinkedList<LinkedList<String>> getRawData() {
		return titles;
	}
	// convert String --> LinkedList<String>
	private LinkedList<String> tokenize(String input) {
		String[] tokens = input.split("\\s+");
		LinkedList<String> result = new LinkedList<String>();
		for (int i = 0; i < tokens.length; i++) {
			result.add(tokens[i]);
		}
		return result;
	}
	// convet LinkedList<String> --> String
	private String combine(LinkedList<String> input) {
		StringBuilder sb = new StringBuilder();
		for (String s : input) {
		    sb.append(s);
		    sb.append(" ");
		}
		return sb.toString();
	}
}
