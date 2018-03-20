package GraphTheory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Pavers {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("pavers.dat"));

        int tc = s.nextInt();


        for(int x = 0; x<tc; x++){
            int price = s.nextInt();
            int buildings = s.nextInt();
            int streets = s.nextInt();

            WeightedGraph map = new WeightedGraph(buildings);

            for(int i = 0; i<streets; i++){
                int a = s.nextInt()-1;
                int b = s.nextInt()-1;
                int c = s.nextInt();

                map.addEdge(a,b,c);
                map.addEdge(b,a,c);
            }

            MinimumSpanningTree mst = new MinimumSpanningTree(map);
            WeightedGraph optimizedMap = mst.getMst();

            int cost = 0;

            for(int i = 0; i<optimizedMap.vertices(); i++){
                Iterable<Integer> list = optimizedMap.getWeights(i);
                for(Integer l: list){
                    cost+=l*price;
                }
            }
            System.out.println(cost);
        }
    }

}
