package algo.search;

import algo.data.Graph;

public class DepthFirstSearch {
	private boolean[] marked;
	private int count;
	
	public DepthFirstSearch(Graph G, int s) {
		marked = new boolean[G.getVertex()];
		dfs(G, s);
	}
	
	// depth first search from v
	private void dfs(Graph G, int v) {
		count++;
		marked[v] = true;
		for(int w : G.adj(v)) {
			if(!marked[w])
				dfs(G, w);
		}
		
	}
}

