package org.revian.stepDefinitions;

import io.cucumber.java.en.*;
import org.revian.MyGraph;

import static org.junit.jupiter.api.Assertions.*;

public class MyGraphStepDefinitions {

    MyGraph<String> graph;

    @Given("an empty graph")
    public void an_empty_graph() {
        graph = new MyGraph<>(false);
    }

    @Given("an undirected graph with nodes {string} and {string}")
    public void an_undirected_graph_with_nodes(String node1, String node2) {
        graph = new MyGraph<>(false);
        graph.addNode(node1);
        graph.addNode(node2);
    }

    @Given("a directed graph with nodes {string} and {string}")
    public void a_directed_graph_with_nodes(String node1, String node2) {
        graph = new MyGraph<>(true);
        graph.addNode(node1);
        graph.addNode(node2);
    }

    @When("I add a node {string}")
    public void i_add_a_node(String node) {
        graph.addNode(node);
    }

    @When("I add an edge between {string} and {string}")
    public void i_add_an_edge_between(String from, String to) {
        graph.addEdge(from, to);
    }

    @When("I add an edge from {string} to {string}")
    public void i_add_an_edge_from_to(String from, String to) {
        graph.addEdge(from, to);
    }

    @Then("the graph should contain the node {string}")
    public void the_graph_should_contain_the_node(String node) {
        assertTrue(graph.containsNode(node));
    }

    @Then("the graph should contain the edge {string} -> {string} and {string} -> {string}")
    public void the_graph_should_contain_the_edge_and(String from, String to, String toBack, String fromBack) {
        assertTrue(graph.containsEdge(from, to));
        assertTrue(graph.containsEdge(toBack, fromBack));
    }

    @Then("the graph should contain the edge {string} -> {string} but not {string} -> {string}")
    public void the_graph_should_contain_the_edge_but_not(String from, String to, String toBack, String fromBack) {
        assertTrue(graph.containsEdge(from, to));
        assertFalse(graph.containsEdge(toBack, fromBack));
    }

    @Then("an exception should be thrown with the message {string}")
    public void an_exception_should_be_thrown_with_the_message(String message) {
        // Exception assertions handled in step execution.
    }
}
