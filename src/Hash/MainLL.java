package Hash;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 131111 on 12/13/2017.
 */
public class MainLL {

    public static void main(String[] args) throws IOException {
        ArrayList<String> raw = new ArrayList<>();
        ArrayList<String> success = new ArrayList<>();
        ArrayList<String> fail = new ArrayList<>();
        Scanner s = new Scanner(new File("namesMain.txt"));
        FileWriter fw = new FileWriter("out.csv");
        PrintWriter pw = new PrintWriter(fw);

        pw.print("Load factor, Avg. insertion time, Total insert collisions, Percent of collisions per insert, Avg search time, Collisions per search, Avg fail time, Collisions per fail\n");
        while(s.hasNextLine()) {
            raw.add(s.nextLine().trim());
        }
        s = new Scanner(new File("namesWin.txt"));
        while(s.hasNextLine()) {
            success.add(s.nextLine().trim());
        }
        s = new Scanner(new File("namesFail.txt"));
        while(s.hasNextLine()) {
            fail.add(s.nextLine().trim());
        }
        HashTableLL[] tables = new HashTableLL[5];

        tables[0] = new HashTableLL(findNextPrime(5000000));
        tables[1] = new HashTableLL(findNextPrime(1000000));
        tables[2] = new HashTableLL(findNextPrime(62500));
        tables[3] = new HashTableLL(findNextPrime(55555));
        tables[4] = new HashTableLL(findNextPrime(50000));

        for(int i = 0; i<5; i++){
            long buildStart = System.currentTimeMillis();
            for(String string: raw){
                String[] str = string.split("\t");
                String[] vals = {str[2], str[3], str[4]};
                tables[i].put(new Name(str[0], str[1]), vals);
            }
            long buildTime = System.currentTimeMillis()-buildStart;

            long succStart = System.currentTimeMillis();
            for(String string: success){
                String[] str = string.split("\t");
                tables[i].get(new Name(str[0], str[1]));
            }
            long succTime = System.currentTimeMillis()-succStart;
            int succCollids = tables[i].getFetchExistCollisions()+tables[i].getFetchVoidCollisions();

            long unsuccStart = System.currentTimeMillis();
            for(String string: fail){
                String[] str = string.split("\t");
                tables[i].get(new Name(str[0], str[1]));
            }
            long unsuccTime = System.currentTimeMillis()-unsuccStart;
            int unsuccCollids = (tables[i].getFetchExistCollisions()+tables[i].getFetchVoidCollisions())-succCollids;

            pw.print("temp,");
            pw.printf("%10.6f,",(double)buildTime/500000);
            pw.printf("%d,",tables[i].getInsertCollisions());
            pw.printf("%10.2f%%,",tables[i].getInsertCollisions()/500000/100.0);
            pw.printf("%10.4f,",succTime/10000.0);
            pw.printf("%10.4f,",succCollids/10000.0);
            pw.printf("%10.4f,",unsuccTime/10000.0);
            pw.printf("%10.4f",unsuccCollids/10000.0);
            pw.printf("\n");
        }
        pw.close();
        fw.close();
    }

    private static int findNextPrime(int p){
        int i = p;
        while(true){
            if(isPrime(i)){
                return i;
            }
            i++;
        }
    }

    private static boolean isPrime(int i) {
        if(i == 2){
            return false;
        }
        if(i % 2 == 0){
            return false;
        }
        for(int x = 3; x<Math.sqrt(i); x+=2){
            if(i % x == 0){
                return false;
            }
        }
        return true;
    }

}
