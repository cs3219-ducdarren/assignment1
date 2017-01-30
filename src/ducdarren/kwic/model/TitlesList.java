package ducdarren.kwic.model;

import java.util.ArrayList;

public class TitlesList {
	
	ArrayList<String[]> titles = new ArrayList<String[]>();
	
	protected void addTitle(String[] title) {
		titles.add(title);
	}
	
	protected void addTitle(String title) {
		this.addTitle(tokenize(title));
	}
	
	private String[] tokenize(String input) {
		return input.split("\\s+");
	}
	
}
