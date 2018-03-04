package GraphTheory;

import java.util.LinkedList;
import java.util.Stack;

public abstract class Graph {

    private int size, edges, flip;
    private LinkedList<Integer> vertices[];
    private boolean connect;

    public Graph(){
        vertices = new LinkedList[10];
        size = 0;

        for(int i = 0; i<10; i++){
            this.vertices[i] = new LinkedList<>();
        }
    }

    public int vertices(){
        return size;
    }

    public int edges(){
        return edges;
    }

    public Iterable<Integer> getConnections(int vertex) {
        return vertices[vertex];
    }

    public boolean connected(int src, int dest){
        return false;
    }

    public Stack<Integer> getPath(int src, int dest){
        return null;
    }

}
