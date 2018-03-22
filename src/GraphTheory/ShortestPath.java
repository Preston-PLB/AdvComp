package GraphTheory;

import java.util.HashSet;
import java.util.PriorityQueue;

public class ShortestPath {

    private PriorityQueue<Vertex> verticies;
    private HashSet<Vertex> visited;
    private WeightedGraph map;


    public ShortestPath(WeightedGraph ){

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
