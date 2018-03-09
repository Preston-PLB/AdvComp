package GraphTheory;

import java.util.LinkedList;
import java.util.Stack;

public interface Graph {

    int vertices();

    int edges();

    Iterable<Integer> getConnections(int vertex);

    boolean connected(int src, int dest);

    Stack<Integer> getPath(int src, int dest);

}
