package src.main.java.ducdarren.kwic.logic;

import src.main.java.ducdarren.kwic.model.LineStorage;

public class LogicManager {
	
	private final LineStorage linesInStorage;
	private final LineStorage circularsStorage;
	
	public LogicManager(LineStorage linesInStorage, LineStorage circularsStorage) {
        this.linesInStorage = linesInStorage;
        this.circularsStorage = circularsStorage;
    }

}
