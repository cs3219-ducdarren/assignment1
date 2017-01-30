package src.main.java.ducdarren.kwic.logic.commands;

import src.main.java.ducdarren.kwic.model.LineStorage;;

/**
 * Abstract Class for all Commands
 * Inner command's logic
 * Execute method
 */

public abstract class Command {
   
   protected LineStorage linesInStorage; 
   protected LineStorage circularsStorage; 

   public abstract CommandResult execute();

   public void setStorages(LineStorage linesInStorage, LineStorage circularsStorage) {
        this.linesInStorage = linesInStorage;
        this.circularsStorage = circularsStorage;
    }

}
