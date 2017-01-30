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
	 
	private LinkedList<String> tokenize(String input) {
		return (LinkedList<String>) Arrays.asList(input.split("\\s+"));
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
