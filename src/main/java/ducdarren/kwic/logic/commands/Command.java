package src.main.java.ducdarren.kwic.logic.commands;

import src.main.java.ducdarren.kwic.model.LineStorage;;

/**
 * Abstract Class for all Commands
 * Inner command's logic
 * Execute method
 */

public abstract class Command {
   
   protected LineStorage linesInStorage; 

   public abstract CommandResult execute();

   public void setLinesInStorage(LineStorage linesInStorage) {
        this.linesInStorage = linesInStorage;
    }

}
