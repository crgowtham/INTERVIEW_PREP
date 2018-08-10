package com.gowtham;

public class CloneGraph {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode graph) {
		if (graph == null)
			return null;
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		return DFS(graph, map);
	}

	private UndirectedGraphNode DFS(UndirectedGraphNode graph, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
		if (map.containsKey(graph)) {
			return map.get(graph);
		}
		UndirectedGraphNode graphCopy = new UndirectedGraphNode(graph.label);
		map.put(graph, graphCopy);
		for (UndirectedGraphNode neighbor : graph.neighbors) {
			graphCopy.neighbors.add(DFS(neighbor, map));
		}
		return graphCopy;
	}

}
