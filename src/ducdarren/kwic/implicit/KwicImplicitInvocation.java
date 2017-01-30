package ducdarren.kwic.implicit;
/**
 * @author A0144750J
 * This class contains the main logic of the software
 * It holds static reference to each component of the software
 * It registers event-dispatchers and event-handlers
 * 	1. CircularShifter listens for ListChangedEvents caused when
 * 		a new title is added to titles. It will shift the new input
 * 	2. Alphabetizer listens for ListChangedEvents caused when
 * 		a newly shifted title is added to the list of circulars. 
 * 		It will sort the new input
 * It contains parameters to run the software
 * 	1. File paths
 */
import java.util.LinkedList;

import ducdarren.kwic.commons.io.Input;
import ducdarren.kwic.commons.io.Output;
import ducdarren.kwic.implicit.logic.alphabetizer.Alphabetizer;
import ducdarren.kwic.implicit.logic.shifter.CircularShifter;
import ducdarren.kwic.implicit.model.TitlesWrapper;

public class KwicImplicitInvocation {
	
	private static final String TITLES_FILE = "data/titles.txt";
	private static final String IGNORE_FILE = "data/ignore.txt";

	private static TitlesWrapper titles;
	private static TitlesWrapper circulars;
	private static LinkedList<String> ignoreList;

	private static CircularShifter circularShifter;
	private static Alphabetizer alphabetizer;

	private static Input input;
	private static Output output;

	private static void init() {

		// Databases
		titles = new TitlesWrapper();
		circulars = new TitlesWrapper();
		ignoreList = new LinkedList<String>();
		// I/O
		input = new Input();
		output = new Output();
		// Add circularShifter listener in titles
		input.readIgnoreFile(IGNORE_FILE, ignoreList);
		circularShifter = new CircularShifter(ignoreList, circulars);
		titles.addObserver(circularShifter);
		// Add alphabetizer listener in circulars
		alphabetizer = new Alphabetizer();
		circulars.addObserver(alphabetizer);
	}

	public static void main(String[] args) {
		init();
		input.readTitleFile(TITLES_FILE, titles);
		output.print(circulars);
	}
}
