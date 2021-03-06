package ducdarren.kwic.implicit.logic.alphabetizer;
/**
 * @author A0144750J
 * This class handles the sorting in alphabetical order 
 * of circularly shifted titles
 * It is called when there is a ListChangedEvent dispatched by
 * the list of circulars
 * The sorting is case-insensitive
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import ducdarren.kwic.implicit.model.TitlesWrapper;

public class Alphabetizer implements Observer{

  public void update(Observable source, Object data){
    TitlesWrapper circularsList = (TitlesWrapper) source;
    LinkedList<String> currentList = circularsList.getAllTitles();
    Collections.sort(currentList, String.CASE_INSENSITIVE_ORDER);
    circularsList.setData(currentList);
  }
}
