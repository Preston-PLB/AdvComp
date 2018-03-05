package GraphTheory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChildsPlay {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("playJudgeCase1.dat"));

        int tc = s.nextInt();

        for(int i = 0; i<tc; i++){
            int max = s.nextInt();
            int sets = s.nextInt();
            int knocks = s.nextInt();

            OrderedGraph og = new OrderedGraph(max);
            boolean[] knocked = new boolean[og.vertices()];
            for(int x = 0; x<sets; x++){
                int t1 = s.nextInt(), t2 = s.nextInt();
                og.addEdge(t1-1, t2-1);
            }
            for(int x = 0; x<knocks; x++){
                int temp = s.nextInt();
                knocked = knock(temp-1, knocked, og);
            }
            int k = 0;
            for(boolean b: knocked){
                if(b){
                    k++;
                }
            }
            System.out.println(k);
        }
    }

    private static boolean[] knock(int src, boolean[] knocked, OrderedGraph og){
        DepthFirstPaths dfp = new DepthFirstPaths(og, src);
        boolean[] temp = dfp.getVisited();
        for(int i = 0; i<temp.length; i++){
            if(temp[i]){
                knocked[i] = true;
            }
        }
        return knocked;
    }

}
