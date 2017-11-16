package Hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 131111 on 11/6/2017.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> raw = new ArrayList<>();
        ArrayList<String> success = new ArrayList<>();
        ArrayList<String> fail = new ArrayList<>();
        Scanner s = new Scanner(new File("build.txt"));
        while(s.hasNextLine()) {
            raw.add(s.nextLine().trim());
        }
        HashTable sparse = new HashTable(10007);
        HashTable split = new HashTable(2003);
        HashTable tight = new HashTable(1259);
        HashTable dense = new HashTable(1117);
        HashTable full = new HashTable(1001);

        long buildStart = System.nanoTime();
        for(String string: raw){
            String[] temp = string.split(" ");
            sparse.put(Integer.parseInt(temp[0]), temp[1]);
        }
        long buildTime = System.nanoTime()-buildStart;

        System.out.println((double)buildTime/1000000.0/1000);
        System.out.println(sparse.getInsertCollisions());
        System.out.println((double)sparse.getInsertCollisions()/1000*100.0);
    }

}
