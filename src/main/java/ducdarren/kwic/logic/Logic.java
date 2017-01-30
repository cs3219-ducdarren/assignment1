package main.java.ducdarren.kwic.logic;

import java.util.Scanner;

import main.java.ducdarren.kwic.logic.commands.Command;
import main.java.ducdarren.kwic.logic.commands.CommandResult;
import main.java.ducdarren.kwic.model.LineStorage;
import main.java.ducdarren.kwic.logic.parser.Parser;
import main.java.ducdarren.kwic.model.LineStorageManager;

public class Logic {
	
	private static final String HELP_MESSAGE = "Welcome to KWIC! Available commands: \n"
			+ "Add: [add title-you-want-to-add]\n"
			+ "Print: print\n";
	private static final String SEPARATOR = "====================";
	private static LineStorage linesInStorage;
	private static LineStorage circularsStorage;
	private static Parser parser;
	private static Scanner scanner;

    public static CommandResult execute(String commandText) {
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
        scanner = new Scanner(System.in);
        // main loop
        while (true) {
        	System.out.print(HELP_MESSAGE);
        	String input = scanner.nextLine();
        	System.out.println(execute(input).toString());
        	System.out.println(SEPARATOR);
        }
    }
}
