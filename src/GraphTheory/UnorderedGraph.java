package GraphTheory;

import java.util.LinkedList;

/**
 * Created by 131111 on 3/1/2018.
 */
public class UnorderedGraph extends Graph {

    private int size, edges;
    private LinkedList<Integer> vertices[];
    private boolean connect;

    @SuppressWarnings("unchecked")
    public UnorderedGraph(int vertices){
        this.vertices = new LinkedList[vertices];
        size = vertices;
        edges = 0;

        for(int i = 0; i<vertices ;i++){
            this.vertices[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest){
        vertices[src].addFirst(dest);
        vertices[dest].addFirst(src);
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
    public Iterable<Integer> getConnections(int vertex) {
        return vertices[vertex];
    }

    @Override
    public boolean connected(int src, int dest){
        DepthFirstPaths dfp = new DepthFirstPaths(this, src);
        return dfp.hasPathTo(dest);
    }
}
