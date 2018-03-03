package GraphTheory;

public interface Graph {

    int vertices();
    int edges();
    Iterable<Integer> getConnections(int vertex);

}
