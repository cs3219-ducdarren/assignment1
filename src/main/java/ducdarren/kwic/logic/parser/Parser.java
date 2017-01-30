package src.main.java.ducdarren.kwic.logic.parser;
/**
 * repurpose from CS2103 sample code
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.main.java.ducdarren.kwic.logic.commands.AddCommand;
import src.main.java.ducdarren.kwic.logic.commands.Command;
import src.main.java.ducdarren.kwic.logic.commands.InvalidCommand;
import src.main.java.ducdarren.kwic.logic.commands.PrintCommand;

public class Parser {
	
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid Command format";
    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";

	private static final Pattern BASIC_COMMAND_FORMAT = Pattern
            .compile("(?<commandWord>\\S+)(?<arguments>.*)");
	
	// Singleton implementation
	private static Parser instance = new Parser();
    private Parser() {
    }
    public static Parser getInstance() {
        return instance;
    }
    
    public Command parseCommand(String userInput) {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            return new InvalidCommand(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        Command toReturn;
        
        switch (commandWord) {
        case AddCommand.COMMAND_WORD:
            toReturn = constructAddCommand(arguments);
            break;
        case PrintCommand.COMMAND_WORD:
        	toReturn = constructPrintCommand();
        	break;
        default:
            toReturn = new InvalidCommand(MESSAGE_UNKNOWN_COMMAND);
            break;
        }
        
        return toReturn;
    };
    
    private Command constructAddCommand(String arguments) {
        return new AddCommand(arguments);
    }
    
    private Command constructPrintCommand() {
        return new PrintCommand();
    }
}
