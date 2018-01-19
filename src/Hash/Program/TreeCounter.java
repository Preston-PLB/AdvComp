package Hash.Program;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TreeCounter {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("trees.dat"));

        s.next();
        s.next();

        HashMap<String, Tree> trees = new HashMap<>();
        ArrayList<Tree> sortedTrees = new ArrayList<>();
        while(s.hasNextLine()){
            String str = s.nextLine().trim();
            if(trees.containsKey(str)){
                trees.get(str).incFreq();
            }else{
                trees.put(str, new Tree(str));
            }
        }
        for(Map.Entry<String, Tree> set: trees.entrySet()){
            sortedTrees.add(set.getValue());
        }
        Collections.sort(sortedTrees);
        for(Tree t: sortedTrees){
            System.out.println(t);
        }
    }

}
