package org.revian;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyGraphTest {

    @Test
    void testAddNodeHappyPath() {
        MyGraph<String> graph = new MyGraph<>(false);
        graph.addNode("A");
        assertTrue(graph.containsNode("A"));
    }

    @Test
    void testAddEdgeHappyPathUndirected() {
        MyGraph<String> graph = new MyGraph<>(false);
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B");
        assertTrue(graph.containsEdge("A", "B"));
        assertTrue(graph.containsEdge("B", "A"));
    }

    @Test
    void testAddEdgeHappyPathDirected() {
        MyGraph<String> graph = new MyGraph<>(true);
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B");
        assertTrue(graph.containsEdge("A", "B"));
        assertFalse(graph.containsEdge("B", "A"));
    }

    @Test
    void testAddEdgeNegativePath() {
        MyGraph<String> graph = new MyGraph<>(false);
        graph.addNode("A");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.addEdge("A", "C"));
        assertEquals("Both nodes must exist in the graph", exception.getMessage());
    }

    @Test
    void testAddNullNode() {
        MyGraph<String> graph = new MyGraph<>(false);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.addNode(null));
        assertEquals("Node cannot be null", exception.getMessage());
    }

    @Test
    void testAddNullEdge() {
        MyGraph<String> graph = new MyGraph<>(false);
        graph.addNode("A");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.addEdge("A", null));
        assertEquals("Nodes in an edge cannot be null", exception.getMessage());
    }

    @Test
    void testGetNeighborsHappyPath() {
        MyGraph<String> graph = new MyGraph<>(false);
        graph.addNode("A");
        graph.addNode("B");
        graph.addEdge("A", "B");
        assertEquals(List.of("B"), graph.getNeighbors("A"));
    }

    @Test
    void testGetNeighborsNonExistentNode() {
        MyGraph<String> graph = new MyGraph<>(false);
        graph.addNode("A");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> graph.getNeighbors("B"));
        assertEquals("Node does not exist in the graph", exception.getMessage());
    }

    @Test
    void testGraphSize() {
        MyGraph<String> graph = new MyGraph<>(false);
        graph.addNode("A");
        graph.addNode("B");
        assertEquals(2, graph.size());
    }
}