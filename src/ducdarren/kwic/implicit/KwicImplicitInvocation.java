package ducdarren.kwic.implicit;

import ducdarren.kwic.implicit.logic.alphabetizer.Alphabetizer;
import ducdarren.kwic.implicit.logic.shifter.CircularShifter;
import ducdarren.kwic.implicit.model.TitlesWrapper;

public class KwicImplicitInvocation {

	private static TitlesWrapper titles;
	private static TitlesWrapper circulars;
	
	private static CircularShifter circularShifter;
	private static Alphabetizer alphabetizer;
	
	private static void init() {
		// Databases
		titles = new TitlesWrapper();
		circulars = new TitlesWrapper();
	    // I/O
		
		// Add circularShifter listener in titles
		circularShifter = new CircularShifter(null, circulars);
	    titles.addObserver(circularShifter);
	    // Add alphabetizer listener in circulars
	    alphabetizer = new Alphabetizer();
	    circulars.addObserver(alphabetizer);
	    // 
	    
	}
	
	public static void main(String[] args) {
		init();
	}
}
