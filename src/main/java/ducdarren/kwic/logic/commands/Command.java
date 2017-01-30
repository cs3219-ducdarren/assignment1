package ducdarren.kwic.logic.commands;

import java.util.ArrayList;

/**
 * Abstract Class for all Commands
 * Inner command's logic
 * Execute method
 */

public abstract class Command {
   
    public abstract CommandResult execute();
    
}
