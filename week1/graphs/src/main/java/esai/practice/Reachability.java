package esai.practice;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class Reachability
{
    private final LinkedList<VerticeEdges> graph;

    private final ArrayList<VerticeEdges> sortedGraph = new ArrayList<VerticeEdges>();

    public Reachability(LinkedList<VerticeEdges> graph) {
        this.graph = graph;
    }

    public boolean reach(int x, int y) {
        sortThatShit(x);
        int reached = x;
        boolean isReachable = false;
        for (VerticeEdges verticeEdge : sortedGraph){
            int got = verticeEdge.isFrom(reached);
            if(got!=-1){
                reached = got;
            }
            if(got == y){
                isReachable=true;
                break;
            }
        }
        return isReachable;
    }
    //not sorted list
    public void sortThatShit(int from){
        VerticeEdges got;
        int findMe = from;
        while (!graph.isEmpty()){
            got = findInTheGraph(findMe);
            if(got!=null){
                sortedGraph.add(got);
                graph.remove(got);
                findMe = got.isFrom(findMe);
            }
        }
    }

    private VerticeEdges findInTheGraph(int findMe) {
        VerticeEdges found = null;
        for (VerticeEdges verticeEdge : graph){

            if(verticeEdge.isFrom(findMe)!=-1){
                found = verticeEdge;
                break;
            }
        }
        return found;
    }

}
