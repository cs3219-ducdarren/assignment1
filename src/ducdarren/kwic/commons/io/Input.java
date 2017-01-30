package ducdarren.kwic.commons.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import ducdarren.kwic.implicit.model.TitlesWrapper;

public class Input {
	
	public void readTitleFile(String titlesFile, TitlesWrapper titles) {
		try {	
			BufferedReader reader = new BufferedReader(new FileReader(titlesFile));
			String nextLine = reader.readLine();
			while (nextLine != null) {
				titles.addTitle(nextLine);
				nextLine = reader.readLine();
			}
		} catch (FileNotFoundException exc) {
			System.err.println("File not found at: " + titlesFile);
			System.exit(1);
		} catch (IOException exc) {
			System.err.println("Unable to read file at: " + titlesFile);
			System.exit(1);
		}
	}
	
	public void readIgnoreFile( String ignoreFile, LinkedList<String> ignoreList) {
		try {	
			BufferedReader reader = new BufferedReader(new FileReader(ignoreFile));
			String nextLine = reader.readLine();
			while (nextLine != null) {
				ignoreList.add(nextLine);
				nextLine = reader.readLine();
			}
		} catch (FileNotFoundException exc) {
			System.err.println("File not found at: " + ignoreFile);
			System.exit(1);
		} catch (IOException exc) {
			System.err.println("Unable to read file at: " + ignoreFile);
			System.exit(1);
		}
	}
}
