package esai.practice.eleganc;

import java.util.Stack;

/**
 * Created by egolesor on 21.08.16.
 */
public class GraphTracer {

    private final Edge fromEdge;
    private final Edge toEdge;

    private int traceNumber;

    public <T> GraphTracer(Edge<T> edge1, Edge<T> edge4) {
        this.fromEdge = edge1;
        this.toEdge = edge4;
    }

    public boolean trace(){
        Stack<Edge<String>> lifo = new Stack<>();
        lifo.add(fromEdge);
        Edge<String> currentEdge, tempEdge;
        currentEdge =fromEdge;
        boolean result =false;
        while (!lifo.isEmpty()){
            if(currentEdge.value==toEdge.value){
                result = true;
                break;
            }
            if((tempEdge=currentEdge.nextEdge())!=null){
                lifo.add(currentEdge);
                currentEdge=tempEdge;
                traceNumber++;
            }else {
                currentEdge = lifo.pop();
                traceNumber--;
            }

        }
        return result;
    }

    public int getTraceNumber() {
        return traceNumber;
    }
}
