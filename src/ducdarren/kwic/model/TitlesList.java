package ducdarren.kwic.model;

import java.util.ArrayList;

public class TitlesList {
	
	ArrayList<String[]> titles = new ArrayList<String[]>();
	
	private void addTitle(String[] title) {
		titles.add(title);
	}
	
	private void addTitle(String title) {
		this.addTitle(tokenize(title));
	}
	
	private String[] tokenize(String input) {
		return input.split("\\s+");
	}
	
}
