package esai.practice;


import org.testng.annotations.Test;

import java.util.LinkedList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

/**
 * Unit test for simple App.
 */
public class ReachabilityTest{

    @Test
    public void test1(){
        /*
            4(vertices)4(edges)
            --
            12
            32
            43
            14
            --
            (from)1 (to)4
         */
        LinkedList<VerticeEdges> graph = new LinkedList<VerticeEdges>();
        VerticeEdges verticeEdges = new VerticeEdges(4,3);
        graph.add(verticeEdges);

        verticeEdges = new VerticeEdges(1,2);
        graph.add(verticeEdges);

        verticeEdges = new VerticeEdges(1,4);
        graph.add(verticeEdges);

        verticeEdges = new VerticeEdges(3,2);
        graph.add(verticeEdges);

        Reachability reachability = new Reachability(graph);
        assertTrue(reachability.reach(4,1));

    }
    @Test
    public void test2(){
        /*
            4(vertices)2(edges)
            --
            12
            32
            --
            (from)1 (to)4
         */
        LinkedList<VerticeEdges> graph = new LinkedList<VerticeEdges>();
        VerticeEdges verticeEdges = new VerticeEdges(1,2);
        graph.add(verticeEdges);

        verticeEdges = new VerticeEdges(3,2);
        graph.add(verticeEdges);

        Reachability reachability = new Reachability(graph);
        assertFalse(reachability.reach(1,4));
    }

    @Test
    public void test3(){
        // counting the moves to reach the 4 may not reach at all :O
        LinkedList<VerticeEdges> graph = new LinkedList<VerticeEdges>();
        VerticeEdges verticeEdges = new VerticeEdges(1,2);
        graph.add(verticeEdges);

        verticeEdges = new VerticeEdges(3,2);
        graph.add(verticeEdges);

        Reachability reachability = new Reachability(graph);
        assertEquals(reachability.getConnectedComponents(1,4), 2);
    }

}
