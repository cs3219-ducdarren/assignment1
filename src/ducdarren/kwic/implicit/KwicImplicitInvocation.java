package ducdarren.kwic.implicit;

import java.util.LinkedList;

import ducdarren.kwic.commons.io.Input;
import ducdarren.kwic.commons.io.Output;
import ducdarren.kwic.implicit.logic.alphabetizer.Alphabetizer;
import ducdarren.kwic.implicit.logic.shifter.CircularShifter;
import ducdarren.kwic.implicit.model.TitlesWrapper;

public class KwicImplicitInvocation {

	private static TitlesWrapper titles;
	private static TitlesWrapper circulars;
	private static LinkedList<String> ignoreList;

	private static CircularShifter circularShifter;
	private static Alphabetizer alphabetizer;

	private static Input input;
	private static Output output;

	private static void init(String titlesFile, String ignoreFile) {

		// Databases
		titles = new TitlesWrapper();
		circulars = new TitlesWrapper();
		// I/O
		input = new Input();
		input.readTitleFile(titlesFile, titles);
		input.readIgnoreFile(ignoreFile, ignoreList);
		output = new Output();
		// Add circularShifter listener in titles
		circularShifter = new CircularShifter(null, circulars);
		titles.addObserver(circularShifter);
		// Add alphabetizer listener in circulars
		alphabetizer = new Alphabetizer();
		circulars.addObserver(alphabetizer);
	}

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Error: Invalid number of arguments");
			System.exit(1);
		} else {
			init(args[0], args[1]);
			output.print(circulars);
		}
	}
}
