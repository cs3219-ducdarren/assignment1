package src.main.java.ducdarren.kwic.logic;

import src.main.java.ducdarren.kwic.logic.commands.CommandResult;

public interface Logic {
	
	CommandResult execute(String commandText);
}
