package GraphTheory;

public class DepthFirstPaths {
    private boolean[] visited;
    private int[] edgeTo;
    private final int src;

    public DepthFirstPaths(Graph g, int source){
        src = source;
        edgeTo = new int[g.vertices()];
        visited = new boolean[g.vertices()];
        validate(source);
        dfs(g, source);
    }

    private void dfs(Graph graph, int vertex){
        visited[vertex] = true;
        for(int i: graph.getConnections(vertex)){
            if(!visited[i]){
                edgeTo[i] = vertex;
                dfs(graph, i);
            }
        }
    }

    public boolean hasPathTo(int vertex){
        validate(vertex);
        return visited[vertex];
    }

    private void validate(int vertex){
        int vertices = visited.length;
        if(vertex < 0 || vertex >= vertices){
            throw new IllegalArgumentException("Vertex "+ vertex + " is not between 0 and " + (vertices-1));
        }
    }
}
