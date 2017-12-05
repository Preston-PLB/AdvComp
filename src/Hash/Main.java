package Hash;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by 131111 on 11/6/2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<String> raw = new ArrayList<>();
        ArrayList<String> success = new ArrayList<>();
        ArrayList<String> fail = new ArrayList<>();
        Scanner s = new Scanner(new File("build.txt"));
        FileWriter fw = new FileWriter("out.csv");
        PrintWriter pw = new PrintWriter(fw);

        pw.print("Load factor, Avg. insertion time, Total insert collisions, Percent of collisions per insert, Avg search time, Collisions per search, Avg fail time, Collisions per fail\n");
        while(s.hasNextLine()) {
            raw.add(s.nextLine().trim());
        }
        s = new Scanner(new File("successful.txt"));
        while(s.hasNextLine()) {
            success.add(s.nextLine().trim());
        }
        s = new Scanner(new File("unsuccessful.txt"));
        while(s.hasNextLine()) {
            fail.add(s.nextLine().trim());
        }
        HashTableQuad[] tables = new HashTableQuad[5];

        tables[0] = new HashTableQuad(findNextPrime(5000000));
        tables[1] = new HashTableQuad(findNextPrime(1000000));
        tables[2] = new HashTableQuad(findNextPrime(625000));
        tables[3] = new HashTableQuad(findNextPrime(555555));
        tables[4] = new HashTableQuad(findNextPrime(500000));

        for(int i = 0; i<5; i++){
            long buildStart = System.currentTimeMillis();
            for(String string: raw){
                String index = string.substring(0, string.indexOf(' '));
                String value = string.substring(string.indexOf(' ')+1);
                tables[i].put(Integer.parseInt(index), value);
            }
            long buildTime = System.currentTimeMillis()-buildStart;

            long succStart = System.currentTimeMillis();
            for(String string: success){
                tables[i].get(Integer.parseInt(string.substring(0, string.indexOf(' '))));
            }
            long succTime = System.currentTimeMillis()-succStart;
            int succCollids = tables[i].getFetchExistCollisions()+tables[i].getFetchVoidCollisions();

            long unsuccStart = System.currentTimeMillis();
            for(String string: fail){
                tables[i].get(Integer.parseInt(string.substring(0, string.indexOf(' '))));
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

//            pw.printf("build time: %.6f\n",(double)buildTime/50000);
//            pw.printf("# of collisions: %d\n",tables[i].getInsertCollisions());
//            pw.printf("Avg # of collision: %.2f%%\n",tables[i].getInsertCollisions()/50000/100.0);
//            pw.printf("Collisions per Insert: %.2f\n",(double)tables[i].getInsertCollisions()/50000*100.0);
//            pw.printf("Avg search time and # of collisions per item: %.4f -- %.4f\n",succTime/1000.0,succCollids/1000.0);
//            pw.printf("Avg fail time and # of collisions per item: %.4f -- %.4f\n",unsuccTime/1000.0,unsuccCollids/1000.0);
//            pw.printf("\n");
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
