package src.main.java.ducdarren.kwic.logic;

import src.main.java.ducdarren.kwic.logic.commands.Command;
import src.main.java.ducdarren.kwic.logic.commands.CommandResult;
import src.main.java.ducdarren.kwic.model.LineStorage;
import src.main.java.ducdarren.kwic.logic.parser.Parser;
import src.main.java.ducdarren.kwic.model.LineStorageManager;

public class Logic {
	
	private static LineStorage linesInStorage;
	private static LineStorage circularsStorage;
	private static Parser parser;


    public CommandResult execute(String commandText) {
        Command command = parser.parseCommand(commandText);
        command.setStorages(linesInStorage, circularsStorage);
        CommandResult result = command.execute();
        // putting valid command into undo stack
        return result;
    }

    public static void main(String[] args) {
    	// init components
    	linesInStorage = new LineStorageManager();
        circularsStorage = new LineStorageManager();
        parser = Parser.getInstance();
    }
}
