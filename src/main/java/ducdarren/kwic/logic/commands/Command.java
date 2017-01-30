package ducdarren.kwic.logic.commands;

import java.util.ArrayList;
import ducdarren.kwic.model.Model;

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
