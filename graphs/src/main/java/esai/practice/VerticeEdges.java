package esai.practice;

/**
 * Created by egolesor on 15.08.16.
 */
public class VerticeEdges {

    final int  fromEdge, toEdnge;

    public VerticeEdges(int fromEdge, int toEdnge) {
        this.fromEdge = fromEdge;
        this.toEdnge = toEdnge;
    }

    int isFrom(int edgeNumber){
        int retNumber = -1;
        if(edgeNumber==fromEdge){
            retNumber = toEdnge;
        }else if(edgeNumber==toEdnge){
            retNumber = fromEdge;
        }
        return retNumber;
    }
}
