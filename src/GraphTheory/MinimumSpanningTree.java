package GraphTheory;

import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinimumSpanningTree extends WeightedGraph{

    private WeightedGraph base;
    private final int V;

    public MinimumSpanningTree(){
        super();
        base = new WeightedGraph(10);
        V = base.vertices();
    }

    public MinimumSpanningTree(WeightedGraph wg){
        super(wg.vertices());
        base = wg;
        V = base.vertices();
        createTree();
    }

    private void createTree(){
        PriorityQueue<Vertex> smallest = new PriorityQueue<>();
        Vertex[] vertices = new Vertex[V];
        int[] parent = new int[V];

        for(int i = 0; i<V; i++){
            Vertex v = new Vertex(i, 0xfffffff);
            smallest.add(v);
            vertices[i] = v;
        }

        smallest.peek().weight = 0;

        while(!smallest.isEmpty()){
            Vertex v = smallest.poll();
            int x = 0;
            for(int i: base.getConnections(v.index)){
                LinkedList<Integer> w = base.getWeights(v.index);
                if(smallest.contains(vertices[i]) && vertices[i].weight > w.get(x)){
                    vertices[i].weight = w.get(x);
                    parent[i] = v.index;
                    resetPQ(smallest);
                }
                x++;
            }
        }

        for(int i = 0; i<V; i++){
            this.addEdge(i, parent[i], vertices[i].weight);
        }
    }

    private void resetPQ(PriorityQueue<Vertex> priorityQueue){
        priorityQueue.add(priorityQueue.poll());
    }

    public WeightedGraph getMst(){
        return this;
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
