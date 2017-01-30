package main.java.ducdarren.kwic.logic.commands;

public class InvalidCommand extends Command {
	public final String feedbackToUser;

    public InvalidCommand(String feedbackToUser){
        this.feedbackToUser = feedbackToUser;
    }

    @Override
    public CommandResult execute() {
        return new CommandResult(feedbackToUser);
    }
}
