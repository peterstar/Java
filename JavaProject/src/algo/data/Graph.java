package algo.data;

public class Graph {
	int vertex;
	int edge;
	Bag<Integer>[] adj;
		
	public int getEdge() {
		return edge;
	}
	
	public int getVertex() {
		return vertex;
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
}

class GraphOne {
	// symbol table: key = string vertex, value = set of neighboring vertices
	private ST<String, SET<String>> st;	
	private int edge;
		
	public int getEdge() {
		return edge;
	}
	
	public int getVertexSize() {
		return st.size();
	}
}