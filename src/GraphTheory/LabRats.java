package GraphTheory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LabRats {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("rats.dat"));

        int tc = s.nextInt();

        for(int t = 0; t<tc; t++){
            int cells = s.nextInt();
            int exit = s.nextInt();
            int time = s.nextInt();

            WeightedGraph map = new WeightedGraph(cells);

            int paths = s.nextInt();
            for(int p = 0; p<paths; p++){
                int a = s.nextInt();
                int b = s.nextInt();
                int weight = s.nextInt();

                map.addEdge(a,b,weight);
            }
            ShortestPath sp = new ShortestPath(map, exit);

            Integer[] times = sp.pathWeights();

            int winners = 0;
            for(int i: times){
                if(i <= time){
                    winners++;
                }
            }
            System.out.println(winners);
        }
    }

}
