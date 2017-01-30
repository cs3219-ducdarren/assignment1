package ducdarren.kwic.pipemodel.structures;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Pipe<T> {

    private Queue<T> buffer = new LinkedList<T>();
    
    public boolean addToQueue(T obj) {
        if(obj == null) {
            throw new IllegalArgumentException("could not add null object!");
        }
        
        buffer.add(obj);
        return true;
    }
}
