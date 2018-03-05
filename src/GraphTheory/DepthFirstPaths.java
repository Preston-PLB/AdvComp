package GraphTheory;

import java.util.List;
import java.util.Stack;

public class DepthFirstPaths {
    private boolean[] visited;
    private int[] edgeTo;
    private boolean[] knocked;
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

    public boolean[] getVisited(){
        return visited;
    }

    public boolean hasPathTo(int vertex){
        validate(vertex);
        return visited[vertex];
    }

    public Stack<Integer> getPathTo(int vertex){
        validate(vertex);
        if(!visited[vertex]){
            return null;
        }
        Stack<Integer> out = new Stack<>();
        for(int i = vertex; i != src; i = edgeTo[i]){
            out.push(i);
        }
        out.push(src);
        return out;
    }



    private void validate(int vertex){
        int vertices = visited.length;
        if(vertex < 0 || vertex >= vertices){
            throw new IllegalArgumentException("Vertex "+ vertex + " is not between 0 and " + (vertices-1));
        }
    }
}
