package org.revian.BigO;

import org.junit.jupiter.api.Test;
import org.revian.MyGraph;

import java.util.Random;
//Interpreting Results
//
//For each test:
//   1.	Observe the execution time as the input size increases.
//	 2.	Confirm that:
//        •	AddNode and ContainsNode times grow linearly with the number of nodes (O(1)).
//        •	AddEdge times scale linearly with the number of edges (O(1) per edge insertion).
//        •	ContainsEdge and GetNeighbors scale proportionally to the degree of nodes (O(d)).
class MyGraphBigOTest {

    @Test
    void testAddNodeBigO() {
        MyGraph<Integer> graph = new MyGraph<>(false);

        int[] sizes = {1000, 10000, 100000, 1000000};
        for (int size : sizes) {
            long startTime = System.nanoTime();

            for (int i = 0; i < size; i++) {
                graph.addNode(i);
            }

            long endTime = System.nanoTime();
            System.out.printf("AddNode Time for %d nodes: %d ns%n", size, endTime - startTime);
        }
    }

    @Test
    void testAddEdgeBigO() {
        MyGraph<Integer> graph = new MyGraph<>(false);

        int numNodes = 10000;
        for (int i = 0; i < numNodes; i++) {
            graph.addNode(i);
        }

        int[] edges = {1000, 10000, 100000, 500000};
        Random random = new Random();
        for (int edgeCount : edges) {
            long startTime = System.nanoTime();

            for (int i = 0; i < edgeCount; i++) {
                int from = random.nextInt(numNodes);
                int to = random.nextInt(numNodes);
                if (from != to) {
                    graph.addEdge(from, to);
                }
            }

            long endTime = System.nanoTime();
            System.out.printf("AddEdge Time for %d edges: %d ns%n", edgeCount, endTime - startTime);
        }
    }

    @Test
    void testContainsNodeBigO() {
        MyGraph<Integer> graph = new MyGraph<>(false);

        int numNodes = 1000000;
        for (int i = 0; i < numNodes; i++) {
            graph.addNode(i);
        }

        int[] lookups = {1000, 10000, 100000};
        Random random = new Random();
        for (int lookupCount : lookups) {
            long startTime = System.nanoTime();

            for (int i = 0; i < lookupCount; i++) {
                graph.containsNode(random.nextInt(numNodes));
            }

            long endTime = System.nanoTime();
            System.out.printf("ContainsNode Time for %d lookups: %d ns%n", lookupCount, endTime - startTime);
        }
    }

    @Test
    void testContainsEdgeBigO() {
        MyGraph<Integer> graph = new MyGraph<>(false);

        int numNodes = 10000;
        for (int i = 0; i < numNodes; i++) {
            graph.addNode(i);
        }

        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int from = random.nextInt(numNodes);
            int to = random.nextInt(numNodes);
            if (from != to) {
                graph.addEdge(from, to);
            }
        }

        int[] lookups = {1000, 10000, 100000};
        for (int lookupCount : lookups) {
            long startTime = System.nanoTime();

            for (int i = 0; i < lookupCount; i++) {
                int from = random.nextInt(numNodes);
                int to = random.nextInt(numNodes);
                graph.containsEdge(from, to);
            }

            long endTime = System.nanoTime();
            System.out.printf("ContainsEdge Time for %d lookups: %d ns%n", lookupCount, endTime - startTime);
        }
    }

    @Test
    void testGetNeighborsBigO() {
        MyGraph<Integer> graph = new MyGraph<>(false);

        int numNodes = 10000;
        for (int i = 0; i < numNodes; i++) {
            graph.addNode(i);
        }

        Random random = new Random();
        for (int i = 0; i < 100000; i++) {
            int from = random.nextInt(numNodes);
            int to = random.nextInt(numNodes);
            if (from != to) {
                graph.addEdge(from, to);
            }
        }

        int[] lookups = {1000, 10000, 100000};
        for (int lookupCount : lookups) {
            long startTime = System.nanoTime();

            for (int i = 0; i < lookupCount; i++) {
                graph.getNeighbors(random.nextInt(numNodes));
            }

            long endTime = System.nanoTime();
            System.out.printf("GetNeighbors Time for %d lookups: %d ns%n", lookupCount, endTime - startTime);
        }
    }
}
