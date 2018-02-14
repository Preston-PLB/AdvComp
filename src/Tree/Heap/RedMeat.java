package Tree.Heap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class RedMeat {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("goat.dat"));

        int tc = s.nextInt();

        for(int i = 0; i<tc; i++){
            int numOGoats = s.nextInt();
            ArrayList<Goat> goats = new ArrayList<>();
            for(int g = 0; g<numOGoats; g++) {
                int cl = s.nextInt();
                Goat goat = new Goat(cl);

                int[] cycle = new int[cl];
                for (int x = 0; x < cl; x++) {
                    cycle[x] = s.nextInt();
                }

                goat.setMilkCycle(cycle);

                goats.add(goat);
            }

            int day = 0;
            int eat = 0;

            while(goats.size() > 0){
                day++;
                Heap heap = new Heap(goats.size());
                for(Goat g: goats){
                    heap.insert(g.getMilk());
                }

                if(heap.topIsUnique()){
                    int low = heap.pop();
                    for(int x = goats.size()-1; x>=0; x--){
                        if(goats.get(x).getMilk() == low){
                            goats.remove(x);
                            eat = day;
                        }
                    }
                }else{
                    if(day == 1000){
                        break;
                    }
                }

                for(Goat g: goats){
                    g.cycleMilk();
                }
            }

            System.out.println(numOGoats - goats.size()+" "+eat);

        }
    }

}
