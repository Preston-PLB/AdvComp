package GraphTheory;

import java.util.LinkedList;

/**
 * Created by 131111 on 3/1/2018.
 */
public class UnorderedGraph implements Graph {

    private int size, edges;
    private LinkedList<Integer> vertices[];
    private boolean connect;

    @SuppressWarnings("unchecked")
    public UnorderedGraph(){
        vertices = new LinkedList[10];

        for(int i = 0; i<10 ;i++){
            vertices[i] = new LinkedList<>();
        }
    }

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
        return 0;
    }

    @Override
    public Iterable<Integer> getConnections(int vertex) {
        return vertices[vertex];
    }

}
