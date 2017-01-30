package ducdarren.kwic.logic.commands;

/**
 * Adds a person to the task book.
 */

public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + " Title";
    public static final String MESSAGE_SUCCESS = "New title added: %1$s";
    public static final String MESSAGE_DUPLICATE_ITEM = "This line is already in the list";

    private final String toAdd;
    
    public AddCommand(String title)
            throws IllegalValueException {
        toAdd = title;
    }


    @Override
    public CommandResult execute() {
        try {
            // add item
            return new CommandResult(
                    String.format(MESSAGE_SUCCESS, toAdd)
        } catch (UniqueItemList.DuplicateItemException e) {
            return new CommandResult(MESSAGE_DUPLICATE_ITEM);
        }

    }

}
