package GraphTheory;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class ShortestPath {

    private PriorityQueue<Vertex> vertices;
    private WeightedGraph map;
    private Vertex[] verts;
    private final int V;

    public ShortestPath(WeightedGraph wg, int src){
        map = wg;
        V = map.vertices();
        vertices = new PriorityQueue<>(V);
        verts = new Vertex[V];

        for(int i = 0; i<V; i++){
            Vertex v = new Vertex(i, 0x7fffffff);
            vertices.add(v);
            verts[i] = v;
        }

        verts[src].weight = 0;
        resetPQ();

        path();
    }

    public Integer[] pathWeights(){
        Integer[] out = new Integer[V];

        for(int i = 0; i<V; i++){
            out[i] = verts[i].weight;
        }

        return out;
    }

    private void path(){
        while(!vertices.isEmpty()){
            Vertex small = vertices.poll();
            LinkedList<Integer> connections = map.getConnections(small.index);
            LinkedList<Integer> weights = map.getWeights(small.index);

            for(Integer i: connections){
                if(vertices.contains(verts[i])){
                    if(weights.size() > i && verts[i].weight > verts[small.index].weight+weights.get(i)){
                        verts[i].weight = verts[small.index].weight+weights.get(i);
                        resetPQ();
                    }
                }
            }
        }
    }

    private void resetPQ(){
        vertices.add(vertices.poll());
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

    }

}
