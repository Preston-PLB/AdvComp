package GraphTheory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ChildsPlay {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("play2.dat"));

        int tc = s.nextInt();

        for(int i = 0; i<tc; i++){
            int max = s.nextInt();
            int sets = s.nextInt();
            int knocks = s.nextInt();

            OrderedGraph og = new OrderedGraph(max);
            for(int x = 0; x<sets; x++){
                og.addEdge(s.nextInt()-1, s.nextInt()-1);
            }

        }
    }

}
