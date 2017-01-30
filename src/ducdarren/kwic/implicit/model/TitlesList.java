package ducdarren.kwic.implicit.model;

import java.util.Arrays;
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
	 
	private LinkedList<String> tokenize(String input) {
		String[] tokens = input.split("\\s+");
		LinkedList<String> result = new LinkedList<String>();
		for (int i = 0; i < tokens.length; i++) {
			result.add(tokens[i]);
		}
		return result;
	}
	
	private String combine(LinkedList<String> input) {
		StringBuilder sb = new StringBuilder();
		for (String s : input) {
		    sb.append(s);
		    sb.append("\t");
		}
		return sb.toString();
	}
}
