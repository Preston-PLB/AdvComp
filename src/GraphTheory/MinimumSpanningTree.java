package GraphTheory;

import java.util.LinkedList;

public class MinimumSpanningTree {

    private WeightedGraph base;
    private WeightedGraph mst;
    private final int V;

    public MinimumSpanningTree(){
        base = new WeightedGraph(10);
        mst = new WeightedGraph(10);
        V = base.vertices();
    }

    public MinimumSpanningTree(WeightedGraph wg){
        base = wg;
        mst = new WeightedGraph(base.vertices());
        V = base.vertices();
        createTree();
    }

    private void createTree(){
        int[] c = new int[base.vertices()];
        boolean[] e = new boolean[base.vertices()];

        for(int i = 0; i<V; i++){
            c[i] = 0x77777777;
            e[i] = false;
        }

        c[0] = 0;
        e[0] = false;

        for(int i = 0; i<V-1; i++){
            int u = minEdge(c, e);
            e[i] = true;

            LinkedList<Integer> weights = base.getWeights(u);

            for(int x = 0; x<V; x++){
                if(weights.get(x) != 0 && !e[x] && weights.get(x) < c[x]){
                    c[x] = weights.get(x);
                    mst.addEdge(x, u, weights.get(x));
                    mst.addEdge(u, x, weights.get(x));
                }
            }
        }

    }

    private int minEdge(int[] c, boolean[] e){
        int min = 0x7777777;
        int index = -1;

        for(int i = 0; i<V; i++){
            if(c[i] < min && !e[i]){
                min = c[i];
                index = i;
            }
        }
        return index;
    }

    public WeightedGraph getMst(){
        return mst;
    }
}
