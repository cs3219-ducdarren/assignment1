package ducdarren.kwic.pipemodel;

import java.util.Arrays;
import java.util.LinkedList;

import ducdarren.kwic.pipemodel.structures.Filter;
import ducdarren.kwic.pipemodel.structures.Pipe;

public class CircularShifter extends Filter<LinkedList<LinkedList<String>>, LinkedList<LinkedList<String>>> {

    public CircularShifter(Pipe<LinkedList<LinkedList<String>>> in, Pipe<LinkedList<LinkedList<String>>> out) {
        super(in, out);
    }

    @Override
    protected void transform(Pipe<LinkedList<LinkedList<String>>> in, Pipe<LinkedList<LinkedList<String>>> out) {
        int outIndex = 0;
        for(int i = 0; i < in.getData().size(); i++) {
            for(int j = 0; j < in.getData().get(i).size(); j++) {
                String toShift = in.getData().get(i).getFirst();
                in.getData().get(i).removeFirst();
                in.getData().get(i).addLast(toShift);
                out.getData().add(deepCopy(in.getData().get(i)));
                outIndex++;
            }
        }
    }
    
    private LinkedList<String> deepCopy(LinkedList<String> list) {
        LinkedList<String> copy = new LinkedList<String>();
        for(int i = 0; i < list.size(); i++) {
            copy.add(list.get(i));
        }
        return copy;
    }
    
    public static void main(String[] args) {
        String input = "Gone with the Wind";
        LinkedList<String> line = new LinkedList<>(Arrays.asList(input.split(" ")));
        LinkedList<LinkedList<String>> inPipe = new LinkedList<>();
        inPipe.add(line);
        LinkedList<LinkedList<String>> outPipe = new LinkedList<>();
        
        Pipe<LinkedList<LinkedList<String>>> in = new Pipe<>(inPipe);
        Pipe<LinkedList<LinkedList<String>>> out = new Pipe<>(outPipe);
        
        CircularShifter cs = new CircularShifter(in, out);
        cs.run();
        System.out.println(cs.getOutPipe().getData());
    }
    
}
