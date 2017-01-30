package main.java.ducdarren.kwic.logic.commands;

/**
 * Result of a command in form of user feedback (string)
 */

public class CommandResult {

    public final String userFeedBack;

    public CommandResult(String userFeedBack) {
        assert userFeedBack != null;
        this.userFeedBack = userFeedBack;
	}

}
