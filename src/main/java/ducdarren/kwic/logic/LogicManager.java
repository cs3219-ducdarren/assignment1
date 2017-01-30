package src.main.java.ducdarren.kwic.logic;

import src.main.java.ducdarren.kwic.logic.commands.Command;
import src.main.java.ducdarren.kwic.logic.commands.CommandResult;
import src.main.java.ducdarren.kwic.model.LineStorage;
import src.main.java.ducdarren.kwic.logic.parser.Parser;

public class LogicManager implements Logic {
	
	private final LineStorage linesInStorage;
	private final LineStorage circularsStorage;
	private final Parser parser;
	
	public LogicManager(LineStorage linesInStorage, LineStorage circularsStorage) {
        this.linesInStorage = linesInStorage;
        this.circularsStorage = circularsStorage;
        parser = Parser.getInstance();
    }
	
	@Override
    public CommandResult execute(String commandText) {
        Command command = parser.parseCommand(commandText);
        command.setStorages(linesInStorage, circularsStorage);
        CommandResult result = command.execute();
        // putting valid command into undo stack
        return result;
    }

}
