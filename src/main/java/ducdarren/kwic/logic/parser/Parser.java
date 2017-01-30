package src.main.java.ducdarren.kwic.logic.parser;

public class Parser {
	
	// Singleton implementation
	private static Parser instance = new Parser();
    private Parser() {
    }
    public static Parser getInstance() {
        return instance;
    }
}
