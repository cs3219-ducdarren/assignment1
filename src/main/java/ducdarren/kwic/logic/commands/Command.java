package main.java.ducdarren.kwic.logic.commands;

import main.java.ducdarren.kwic.model.DataFacade;

/**
 * Abstract Class for all Commands
 * Inner command's logic
 * Execute method
 */

public abstract class Command {
   
   protected DataFacade linesInStorage; 
   protected DataFacade circularsStorage; 

   public abstract CommandResult execute();

   public void setStorages(DataFacade linesInStorage, DataFacade circularsStorage) {
        this.linesInStorage = linesInStorage;
        this.circularsStorage = circularsStorage;
    }

}
