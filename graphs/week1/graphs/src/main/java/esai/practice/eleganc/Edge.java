package esai.practice.eleganc;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by egolesor on 21.08.16.
 */
public class Edge<TYPE> {

    final TYPE value;

    public Edge(TYPE value) {
        this.value = value;
    }

    Set<Edge<TYPE>> verticals = new LinkedHashSet();

    Iterator<Edge<TYPE>> edgeIterator;



    public void addVerticals(Edge<TYPE> newEdge){
        verticals.add(newEdge);
        edgeIterator = verticals.iterator();
    }

    public Edge<TYPE> nextEdge(){
        if(edgeIterator!=null && edgeIterator.hasNext()){
            return edgeIterator.next();
        }
        return null;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
