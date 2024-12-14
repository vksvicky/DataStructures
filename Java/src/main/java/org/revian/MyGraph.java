package org.revian;

import java.util.*;

public class MyGraph<T> {
    private final Map<T, List<T>> adjacencyList;
    private final boolean isDirected;

    public MyGraph(boolean isDirected) {
        this.isDirected = isDirected;
        this.adjacencyList = new HashMap<>();
    }

    // Add a node to the graph
    public void addNode(T node) {
        if (node == null) {
            throw new IllegalArgumentException("Node cannot be null");
        }
        adjacencyList.putIfAbsent(node, new ArrayList<>());
    }

    // Add an edge between two nodes
    public void addEdge(T from, T to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Nodes in an edge cannot be null");
        }
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) {
            throw new IllegalArgumentException("Both nodes must exist in the graph");
        }
        adjacencyList.get(from).add(to);
        if (!isDirected) {
            adjacencyList.get(to).add(from);
        }
    }

    // Check if a node exists in the graph
    public boolean containsNode(T node) {
        return adjacencyList.containsKey(node);
    }

    // Check if an edge exists between two nodes
    public boolean containsEdge(T from, T to) {
        if (!adjacencyList.containsKey(from)) {
            return false;
        }
        return adjacencyList.get(from).contains(to);
    }

    // Get all neighbors of a node
    public List<T> getNeighbors(T node) {
        if (!adjacencyList.containsKey(node)) {
            throw new IllegalArgumentException("Node does not exist in the graph");
        }
        return adjacencyList.get(node);
    }

    // Get the size of the graph
    public int size() {
        return adjacencyList.size();
    }
}
