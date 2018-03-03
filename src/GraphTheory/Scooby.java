package GraphTheory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by 131111 on 3/1/2018.
 */
public class Scooby {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("scooby.dat"));

        int tc = s.nextInt();
        s.nextLine();
        for(int i = 0; i<tc; i++){
            String line = s.nextLine();
            String test = s.nextLine();
            String[] connections = line.split(" ");
            int index = 0;
            boolean works = false;
            TreeMap<Character, Integer> treeMap = new TreeMap<>();


            for(char c: line.toCharArray()){
                if(!treeMap.containsKey(c)){
                    treeMap.put(c, index);
                    index++;
                }
            }
            if(treeMap.containsKey(test.charAt(0)) && treeMap.containsKey(test.charAt(1))){
                UnorderedGraph ug = new UnorderedGraph(index);
                for(String str: connections){
                    ug.addEdge(treeMap.get(str.charAt(0)), treeMap.get(str.charAt(1)));
                }

                DepthFirstPaths dfp = new DepthFirstPaths(ug, treeMap.get(test.charAt(0)));
                works = dfp.hasPathTo(treeMap.get(test.charAt(1)));
            }

            if(works){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }

}
