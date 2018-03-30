package com.gowtham;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Map;
import java.util.Arrays;
import java.util.HashMap;

public class DjkstraShortestPath {

	public static class Node {

		private String name;

		private LinkedList<Node> shortestPath = new LinkedList<>();

		private Integer distance = Integer.MAX_VALUE;

		private Map<Node, Integer> adjacentNodes = new HashMap<>();

		public Node(String name) {
			this.name = name;
		}

		public void addDestination(Node destination, int distance) {
			adjacentNodes.put(destination, distance);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Map<Node, Integer> getAdjacentNodes() {
			return adjacentNodes;
		}

		public void setAdjacentNodes(Map<Node, Integer> adjacentNodes) {
			this.adjacentNodes = adjacentNodes;
		}

		public Integer getDistance() {
			return distance;
		}

		public void setDistance(Integer distance) {
			this.distance = distance;
		}

		public List<Node> getShortestPath() {
			return shortestPath;
		}

		public void setShortestPath(LinkedList<Node> shortestPath) {
			this.shortestPath = shortestPath;
		}

	}

	public static class Graph {

		private Set<Node> nodes = new HashSet<>();

		public void addNode(Node nodeA) {
			nodes.add(nodeA);
		}

		public Set<Node> getNodes() {
			return nodes;
		}

		public void setNodes(Set<Node> nodes) {
			this.nodes = nodes;
		}
	}

	/*
	 * public static Graph calculateShortestPathFromSource(Graph graph, Node
	 * source) {
	 * 
	 * source.setDistance(0);
	 * 
	 * Set<Node> settledNodes = new HashSet<>(); Set<Node> unsettledNodes = new
	 * HashSet<>(); unsettledNodes.add(source);
	 * 
	 * while (unsettledNodes.size() != 0) { Node currentNode =
	 * getLowestDistanceNode(unsettledNodes);
	 * unsettledNodes.remove(currentNode); for (Entry<Node, Integer>
	 * adjacencyPair : currentNode.getAdjacentNodes().entrySet()) { Node
	 * adjacentNode = adjacencyPair.getKey(); Integer edgeWeigh =
	 * adjacencyPair.getValue();
	 * 
	 * if (!settledNodes.contains(adjacentNode)) {
	 * CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
	 * unsettledNodes.add(adjacentNode); } } settledNodes.add(currentNode); }
	 * return graph; }
	 * 
	 * private static void CalculateMinimumDistance(Node evaluationNode, Integer
	 * edgeWeigh, Node sourceNode) { Integer sourceDistance =
	 * sourceNode.getDistance(); if (sourceDistance + edgeWeigh <
	 * evaluationNode.getDistance()) { evaluationNode.setDistance(sourceDistance
	 * + edgeWeigh); LinkedList<Node> shortestPath = new
	 * LinkedList<>(sourceNode.getShortestPath()); shortestPath.add(sourceNode);
	 * evaluationNode.setShortestPath(shortestPath); } }
	 * 
	 * private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
	 * Node lowestDistanceNode = null; int lowestDistance = Integer.MAX_VALUE;
	 * for (Node node : unsettledNodes) { int nodeDistance = node.getDistance();
	 * if (nodeDistance < lowestDistance) { lowestDistance = nodeDistance;
	 * lowestDistanceNode = node; } } return lowestDistanceNode; }
	 */

	public static Graph calculateShortestPathFromSource(Graph graph, Node source) {

		source.setDistance(0);

		Set<Node> settledNodes = new HashSet<>();
		Set<Node> unsettledNodes = new HashSet<>();
		unsettledNodes.add(source);

		while (unsettledNodes.size() != 0) {
			Node currentNode = getLowestDistanceNode(unsettledNodes);
			unsettledNodes.remove(currentNode);
			for (Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
				Node adjacentNode = adjacencyPair.getKey();
				Integer edgeWeigh = adjacencyPair.getValue();

				if (!settledNodes.contains(adjacentNode)) {
					CalculateMinimumDistance(adjacentNode, edgeWeigh, currentNode);
					unsettledNodes.add(adjacentNode);
				}
			}
			settledNodes.add(currentNode);
		}
		return graph;
	}

	private static void CalculateMinimumDistance(Node evaluationNode, Integer edgeWeigh, Node sourceNode) {
		Integer sourceDistance = sourceNode.getDistance();
		if (sourceDistance + edgeWeigh < evaluationNode.getDistance()) {
			evaluationNode.setDistance(sourceDistance + edgeWeigh);
			LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
			shortestPath.add(sourceNode);
			evaluationNode.setShortestPath(shortestPath);
		}
	}

	private static Node getLowestDistanceNode(Set<Node> unsettledNodes) {
		Node lowestDistanceNode = null;
		int lowestDistance = Integer.MAX_VALUE;
		for (Node node : unsettledNodes) {
			int nodeDistance = node.getDistance();
			if (nodeDistance < lowestDistance) {
				lowestDistance = nodeDistance;
				lowestDistanceNode = node;
			}
		}
		return lowestDistanceNode;
	}

	public static void main(String[] args) {
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");

		nodeA.addDestination(nodeB, 10);
		nodeA.addDestination(nodeC, 15);

		nodeB.addDestination(nodeD, 12);
		nodeB.addDestination(nodeF, 15);

		nodeC.addDestination(nodeE, 10);

		nodeD.addDestination(nodeE, 2);
		nodeD.addDestination(nodeF, 1);

		nodeF.addDestination(nodeE, 5);

		Graph graph = new Graph();

		graph.addNode(nodeA);
		graph.addNode(nodeB);
		graph.addNode(nodeC);
		graph.addNode(nodeD);
		graph.addNode(nodeE);
		graph.addNode(nodeF);

		graph = calculateShortestPathFromSource(graph, nodeA);

		List<Node> shortestPathForNodeB = Arrays.asList(nodeA);
		List<Node> shortestPathForNodeC = Arrays.asList(nodeA);
		List<Node> shortestPathForNodeD = Arrays.asList(nodeA, nodeB);
		List<Node> shortestPathForNodeE = Arrays.asList(nodeA, nodeB, nodeD);
		List<Node> shortestPathForNodeF = Arrays.asList(nodeA, nodeB, nodeD);

		for (Node node : graph.getNodes()) {
			switch (node.getName()) {
			case "B": {
				for (Node a : node.getShortestPath()) {
					System.out.println("From A-B nodes names: " + a.getName() + "values : " + a.getDistance());
				}

				break;
			}
			case "C":
				for (Node a : node.getShortestPath()) {
					System.out.println("FROM A-C nodes names: " + a.getName() + "values : " + a.getDistance());
				}
				break;
			case "D":
				for (Node a : node.getShortestPath()) {
					System.out.println("FROM A-D nodes names: " + a.getName() + "values : " + a.getDistance());
				}
				break;
			case "E":
				for (Node a : node.getShortestPath()) {
					System.out.println("FROM A-E nodes names: " + a.getName() + "values : " + a.getDistance());
				}
				break;
			case "F":
				for (Node a : node.getShortestPath()) {
					System.out.println("FROM A-F nodes names: " + a.getName() + "values : " + a.getDistance());
				}
				break;
			}
		}
	}
}
