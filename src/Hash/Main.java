package Hash;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 131111 on 11/6/2017.
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("redux.txt"));
        HashTable ht = new HashTable(10);
        while(s.hasNextLine()){
            String[] raw = s.nextLine().split(" ");
            ht.put(Integer.parseInt(raw[0]), raw[1]);
        }
        System.out.println(ht);
    }

}
