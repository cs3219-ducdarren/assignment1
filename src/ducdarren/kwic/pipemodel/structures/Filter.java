package ducdarren.kwic.pipemodel.structures;

public abstract class Filter<I,O> {

    protected Pipe<I> pipeIn;
    protected Pipe<O> pipeOut;
    
    public Filter(Pipe<I> in, Pipe<O> out) {
        this.pipeIn = in;
        this.pipeOut = out;
    }
    
    public void run() {
        transform(this.pipeIn, this.pipeOut);
    }
    
    protected abstract void transform(Pipe<I> in, Pipe<O> out);
}
