package esai.practice.eleganc;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by egolesor on 21.08.16.
 */
public class EdgeTest {


    @Test
    public void ifEdgesAreAdded(){
        Edge<String> edge = new Edge<>("1");

        edge.addVerticals(new Edge<>("2"));
        edge.addVerticals(new Edge<>("3"));
        edge.addVerticals(new Edge<>("4"));
        edge.addVerticals(new Edge<>("5"));
        edge.addVerticals(new Edge<>("6"));

        assertEquals(edge.verticals.size(), 5);
    }

    @Test
    public void edgeIterationWorks(){
        Edge<String> edge = new Edge<>("1");

        edge.addVerticals(new Edge<>("2"));
        edge.addVerticals(new Edge<>("3"));
        edge.addVerticals(new Edge<>("4"));
        edge.addVerticals(new Edge<>("5"));
        edge.addVerticals(new Edge<>("6"));

        assertEquals(edge.nextEdge().value, "2");
        assertEquals(edge.nextEdge().value, "3");
        assertEquals(edge.nextEdge().value, "4");
        assertEquals(edge.nextEdge().value, "5");
        assertEquals(edge.nextEdge().value, "6");
    }

    /**
     *
     */
    @Test
    public void edgePath(){
        Edge<String> edge1 = new Edge<>("1");
        Edge<String> edge2 = new Edge<>("2");
        Edge<String> edge3 = new Edge<>("3");
        Edge<String> edge4 = new Edge<>("4");

        edge1.addVerticals(edge2);
        edge2.addVerticals(edge3);
        edge3.addVerticals(edge4);

        GraphTracer tracer = new GraphTracer(edge1, edge4);
        assertTrue(tracer.trace());
    }

    @Test
    public void edgePath1(){
        Edge<Integer> edge1= new Edge<>(1);
        Edge<Integer> edge2= new Edge<>(2);
        Edge<Integer> edge3= new Edge<>(3);
        Edge<Integer> edge4= new Edge<>(4);
        Edge<Integer> edge5= new Edge<>(5);
        Edge<Integer> edge6= new Edge<>(6);
        Edge<Integer> edge7= new Edge<>(7);
        Edge<Integer> edge8= new Edge<>(8);
        Edge<Integer> edge9= new Edge<>(9);
        Edge<Integer> edge10= new Edge<>(10);

        edge1.addVerticals(edge2);

        edge2.addVerticals(edge3);
        edge2.addVerticals(edge4);
        edge2.addVerticals(edge5);

        edge1.addVerticals(edge6);
        edge6.addVerticals(edge7);
        edge6.addVerticals(edge8);
        edge6.addVerticals(edge10);
        edge8.addVerticals(edge9);


        GraphTracer tracer = new GraphTracer(edge1, edge10);
        assertTrue(tracer.trace());
        assertEquals(tracer.getTraceNumber(), 2);
    }

    @Test
    public void edgePath2(){
        Edge<Integer> edge1= new Edge<>(1);
        Edge<Integer> edge2= new Edge<>(2);
        Edge<Integer> edge3= new Edge<>(3);
        Edge<Integer> edge4= new Edge<>(4);
        Edge<Integer> edge5= new Edge<>(5);
        Edge<Integer> edge6= new Edge<>(6);
        Edge<Integer> edge7= new Edge<>(7);
        Edge<Integer> edge8= new Edge<>(8);
        Edge<Integer> edge9= new Edge<>(9);
        Edge<Integer> edge10= new Edge<>(10);

        edge1.addVerticals(edge2);

        edge2.addVerticals(edge3);
        edge2.addVerticals(edge4);
        edge2.addVerticals(edge5);

        edge1.addVerticals(edge6);
        edge6.addVerticals(edge7);
        edge6.addVerticals(edge8);
        edge8.addVerticals(edge9);


        GraphTracer tracer = new GraphTracer(edge1, edge10);
        assertFalse(tracer.trace());
    }

    @Test
    public void oneNode1000Child(){
        Edge<Integer> edge = new Edge<>(Integer.valueOf(1));
        Edge<Integer> edgesss = new Edge<>(Integer.valueOf(1000));

        for(int counter=2; counter<1000; counter++){
            edge.addVerticals(new Edge<>(Integer.valueOf(counter)));
        }
        edge.addVerticals(edgesss);
        GraphTracer tracer = new GraphTracer(edge, edgesss);
        assertTrue(tracer.trace());
    }

    @Test
    public void traceto1000(){
        Edge<Integer> edge = new Edge<>(Integer.valueOf(1));
        Edge<Integer> newEdge, currentEdge;
        currentEdge = edge;
        Edge<Integer> edgesss = new Edge<>(Integer.valueOf(1000));

        for(int counter=2; counter<1000; counter++){
            newEdge = new Edge<>(Integer.valueOf(counter));
            currentEdge.addVerticals(newEdge);
            currentEdge = newEdge;
        }
        edge.addVerticals(edgesss);
        GraphTracer tracer = new GraphTracer(edge, edgesss);
        assertTrue(tracer.trace());
    }
    @Test
    public void tracetoEvil(){
        Edge<Integer> edge = new Edge<>(Integer.valueOf(1));
        Edge<Integer> newEdge, currentEdge;
        currentEdge = edge;
        final int EVILNUMBER = 1000;
        Edge<Integer> edgesss = new Edge<>(Integer.valueOf(EVILNUMBER));

        for(int counter=2; counter<EVILNUMBER; counter++){
            newEdge = new Edge<>(Integer.valueOf(counter));
            currentEdge.addVerticals(newEdge);
            currentEdge = newEdge;
        }
        edge.addVerticals(edgesss);
        GraphTracer tracer = new GraphTracer(edge, edgesss);
        assertTrue(tracer.trace());
    }


}
