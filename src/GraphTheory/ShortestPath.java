package GraphTheory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ShortestPath {

    private PriorityQueue<Vertex> verticies;
    private HashSet<Vertex> visited;
    private WeightedGraph map;
    private Vertex[] verts;
    private final int V;
    private int src, dest;

    public ShortestPath(WeightedGraph wg, int src, int dest){
        map = wg;
        V = map.vertices();
        verticies = new PriorityQueue<>(V);
        verts = new Vertex[V];
        visited = new HashSet<>();

        this.src = src;
        this.dest = dest;

        for(int i = 0; i<V; i++){
            Vertex v = new Vertex(i, 0x7fffffff);
            verticies.add(v);
            verts[i] = v;
        }

        verts[src].weight = 0;
        resetPQ();

        path();
    }

    private void path(){
        while(!verticies.isEmpty()){
            Vertex small = verticies.poll();
            LinkedList<Integer> connections = map.getConnections(small.index);
            LinkedList<Integer> weights = map.getWeights(small.index);

            for(Integer i: connections){
                if(verticies.contains(verts[i])){
                    if(verts[i].weight > verts[small.index].weight+weights.get(i)){
                        verts[i].weight = verts[small.index].weight+weights.get(i);
                        resetPQ();
                    }
                }
            }
        }
    }

    private void resetPQ(){
        verticies.add(verticies.poll());
    }

    private class Vertex implements Comparable{

        int index;
        int weight;

        public Vertex(int index, int weight){
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Object o) {
            Vertex n = (Vertex)o;
            return weight < n.weight ? -1 : 1;
        }

        @Override
        public int hashCode(){
            return index*weight;
        }

    }

}
