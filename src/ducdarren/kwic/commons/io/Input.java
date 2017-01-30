package ducdarren.kwic.commons.io;
/**
 * @author A0144750J
 * 
 * This class handles the input from files to the program
 * Responsibilities:
 * 	1. Read files for lists of titles and words to ignore
 *  2. Write raw data (String) into inner data structures of the program
 *  3. I/O error trapping
 *  
 * There are two methods to read from two files separately.
 * In terms of architecture:
 * 	1. readIgnoreFile: Does not trigger any event
 *  2. readTitleFile: Trigger ListChangedEvent that is listened to by CircularShifter
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

import ducdarren.kwic.implicit.model.TitlesWrapper;

public class Input {
	
	/**
	 * Read a list of titles from an input txt file to a wrapped LinkedList
	 * Trigger a ListChangedEvent as data is written onto titles list
	 * This event is handled by the CircularShifter
	 * @param titlesFile: path for input file containing titles separated by a new line
	 * @param titles: software's own data structure to store all input titles
	 */
	public void readTitleFile(String titlesFile, TitlesWrapper titles) {
		try {	
			BufferedReader reader = new BufferedReader(new FileReader(titlesFile));
			String nextLine = reader.readLine();
			while (nextLine != null) {
				titles.addTitle(nextLine);
				nextLine = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException exc) {
			System.err.println("File not found at: " + titlesFile);
			System.exit(1);
		} catch (IOException exc) {
			System.err.println("Unable to read file at: " + titlesFile);
			System.exit(1);
		} finally {
			
		}
	}
	
	/**
	 * Read a list of words to ignore into a linked list
	 * Does not trigger any event
	 * @param titlesFile: path for input file containing words to ignore
	 * @param titles: software's own data structure to store all ignored words
	 */
	public void readIgnoreFile( String ignoreFile, LinkedList<String> ignoreList) {
		try {	
			BufferedReader reader = new BufferedReader(new FileReader(ignoreFile));
			String nextLine = reader.readLine();
			while (nextLine != null) {
				ignoreList.add(nextLine);
				nextLine = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException exc) {
			System.err.println("File not found at: " + ignoreFile);
			System.exit(1);
		} catch (IOException exc) {
			System.err.println("Unable to read file at: " + ignoreFile);
			System.exit(1);
		}
	}
}
