package main.java.ducdarren.kwic.logic.commands;

public class PrintCommand extends Command {
	
	public static final String COMMAND_WORD = "print";
	public static final String MESSAGE_USAGE = COMMAND_WORD;
	public static final String MESSAGE_SUCCESS = "Sucessfully printed list of KWIC: ";

	public PrintCommand() {
		
	}

	@Override
	public CommandResult execute() {
		// need to try/catch duplicate later
		linesInStorage.getCirculars();
		return new CommandResult(String.format(MESSAGE_SUCCESS));
	}
}
