package GraphTheory;

import java.util.LinkedList;
import java.util.Stack;

public class WeightedGraph implements Graph{

    private int size, edges;
    private LinkedList<Integer> vertices[];
    private LinkedList<Integer> weights[];

    public WeightedGraph(int vertices){
        this.vertices = new LinkedList[vertices];
        this.weights = new LinkedList[vertices];
        size = vertices;
        edges = 0;

        for(int i = 0; i<vertices ;i++){
            this.vertices[i] = new LinkedList<>();
            this.weights[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest, int weight){
        vertices[src].addFirst(dest);
        weights[src].addFirst(weight);
        edges++;
    }

    @Override
    public int vertices() {
        return size;
    }

    @Override
    public int edges() {
        return edges;
    }

    @Override
    public LinkedList<Integer> getConnections(int vertex) {
        return vertices[vertex];
    }

    public LinkedList<Integer> getWeights(int vertex) {
        return weights[vertex];
    }

    @Override
    public boolean connected(int src, int dest) {
        DepthFirstPaths dfp = new DepthFirstPaths(this, src);
        return dfp.hasPathTo(dest);
    }

    @Override
    public Stack<Integer> getPath(int src, int dest) {
        DepthFirstPaths dfp = new DepthFirstPaths(this, src);
        return dfp.getPathTo(dest);
    }
}
