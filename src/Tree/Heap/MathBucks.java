package Tree.Heap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MathBucks {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("mathCosts.dat"));

        while(s.hasNextInt()){
            int tc = s.nextInt();
            if(tc == 0){
                break;
            }
            Heap heap = new Heap(tc);
            for(int i = 0; i<tc; i++){
                heap.insert(s.nextInt());
            }

            int cost = 0;

            while(heap.getSize() > 1){
                int temp = heap.pop()+heap.pop();
                cost += temp;
                heap.insert(temp);
            }
            System.out.println(cost);
        }
    }

}
