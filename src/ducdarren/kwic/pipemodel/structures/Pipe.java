package ducdarren.kwic.pipemodel.structures;

import java.util.LinkedList;
import java.util.Queue;

public class Pipe<T> {

    private Queue<T> buffer;
    private T data;
    
    public Pipe(T data) {
        this.data = data;
        this.buffer = new LinkedList<T>();
    }
    
    public boolean addToQueue(T obj) {
        if(obj == null) {
            throw new IllegalArgumentException("could not add null object!");
        }
        
        buffer.add(obj);
        return true;
    }
    
    public T getData() {
        return this.data;
    }
}
