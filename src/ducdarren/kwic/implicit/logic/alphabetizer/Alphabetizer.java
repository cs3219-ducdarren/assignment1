package ducdarren.kwic.implicit.logic.alphabetizer;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import ducdarren.kwic.implicit.model.TitlesWrapper;

public class Alphabetizer implements Observer{

  public void update(Observable source, Object data){
    TitlesWrapper circularsList = (TitlesWrapper) source;
    LinkedList<String> currentList = circularsList.getAllTitles();
    Collections.sort(currentList);
    circularsList.setData(currentList);
  }
}
