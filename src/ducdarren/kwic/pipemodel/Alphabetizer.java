package ducdarren.kwic.pipemodel;

import java.util.List;

import ducdarren.kwic.pipemodel.structures.Filter;
import ducdarren.kwic.pipemodel.structures.Pipe;

import java.util.Collections;
import java.util.LinkedList;

public class Alphabetizer extends Filter<LinkedList<LinkedList<String>>, List<String>>{

    public Alphabetizer(Pipe<LinkedList<LinkedList<String>>> in, Pipe<List<String>> out) {
        super(in, out);
    }

    @Override
    protected void transform(Pipe<LinkedList<LinkedList<String>>> in, Pipe<List<String>> out) {
        for(LinkedList<String> line : in.getData()) {
            out.getData().add(String.join(" ", line));
        }
        Collections.sort(out.getData());
    }

}
