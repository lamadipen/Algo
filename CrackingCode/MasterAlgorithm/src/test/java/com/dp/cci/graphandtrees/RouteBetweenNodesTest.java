package com.dp.cci.graphandtrees;

import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by dipen on 1/17/2019.
 */
//@RunWith(SpringRunner.class)
public class RouteBetweenNodesTest {

    private RouteBetweenNodes routeBetweenNodes;
    private Graph graph;
    private Node start, end, node1, node2, node3;

    @Before
    public void setup() {
        routeBetweenNodes = new RouteBetweenNodes();

        start = Node.builder().data(10).build();
        node1 = Node.builder().data(11).build();
        node2 = Node.builder().data(9).build();
        node3 = Node.builder().data(7).build();
        end = Node.builder().data(6).build();

        start.setAdjacent(Arrays.asList(new Node[]{node1}));
        node1.setAdjacent(Arrays.asList(new Node[]{node2}));
        node2.setAdjacent(Arrays.asList(new Node[]{node3}));
        node3.setAdjacent(Arrays.asList(new Node[]{end}));

        graph.builder()
                .nodes(Arrays.asList(new Node[]{
                        start,
                        node1,
                        node2,
                        node3,
                        end
                }))
                .build();
    }

    @Test
    public void searchTest_withoutCycle_hasPath(){
        assertTrue(routeBetweenNodes.search(graph, start, end));
    }

    @Test
    public void searchTest_withCycle_hasPath(){
        node2.setAdjacent(Arrays.asList(new Node[]{node3,start}));
        Node node4 = Node.builder().data(20).build();
        node3.setAdjacent(Arrays.asList(new Node[]{node4}));
        node3.setAdjacent(Arrays.asList(new Node[]{end}));
        assertTrue(routeBetweenNodes.search(graph, start, end));
    }

    @Test
    public void searchTest_hasNoPath(){
        node2.setAdjacent(Arrays.asList(new Node[]{}));
        assertFalse(routeBetweenNodes.search(graph, start, end));
    }
}