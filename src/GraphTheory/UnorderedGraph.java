package GraphTheory;

import java.util.LinkedList;

/**
 * Created by 131111 on 3/1/2018.
 */
public class UnorderedGraph {

    private int size;
    private LinkedList<Integer> larry[];

    @SuppressWarnings("unchecked")
    public UnorderedGraph(){
        larry = new LinkedList[10];

        for(int i = 0; i<10 ;i++){
            larry[i] = new LinkedList<>();
        }
    }

    @SuppressWarnings("unchecked")
    public UnorderedGraph(int vertices){
        larry = new LinkedList[vertices];
        size = vertices;

        for(int i = 0; i<vertices ;i++){
            larry[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest){
        larry[src].addFirst(dest);
        larry[dest].addFirst(src);
    }

    public boolean connects(int src, int dest, int index){
        if(larry[src].get(index) == dest){
            return true;
        }else{
            if(index+1 == larry[src].size()){
                return connects(larry[src].get(index), dest, 0);
            }else{
                return connects(src, dest, index+1);
            }
        }
    }

}
