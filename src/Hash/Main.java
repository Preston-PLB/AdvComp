package Hash;

import java.io.*;
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
        FileWriter fw = new FileWriter("out.txt");
        PrintWriter pw = new PrintWriter(fw);
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
        HashTable[] tables = new HashTable[5];

        tables[0] = new HashTable(10007);
        tables[1] = new HashTable(2003);
        tables[2] = new HashTable(1259);
        tables[3] = new HashTable(1117);
        tables[4] = new HashTable(1001);

        for(int i = 0; i<5; i++){
            long buildStart = System.currentTimeMillis();
            for(String string: raw){
                String[] temp = string.split(" ");
                tables[i].put(Integer.parseInt(temp[0]), temp[1]);
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
            long unsuccTime = System.currentTimeMillis()-succStart;
            int unsuccCollids = (tables[i].getFetchExistCollisions()+tables[i].getFetchVoidCollisions())-succCollids;

            pw.printf("build time: %.6f\n",(double)buildTime/50000);
            pw.printf("# of collisions: %d\n",tables[i].getInsertCollisions());
            pw.printf("Avg # of collision: %.2f%%\n",tables[i].getInsertCollisions()/50000/100.0);
            pw.printf("Collisions per Insert: %.2f\n",(double)tables[i].getInsertCollisions()/50000*100.0);
            pw.printf("Avg search time and # of collisions per item: %.4f -- %.4f\n",succTime/1000.0,succCollids/1000.0);
            pw.printf("Avg fail time and # of collisions per item: %.4f -- %.4f\n",unsuccTime/1000.0,unsuccCollids/1000.0);
            pw.printf("\n");
        }
        pw.close();
        fw.close();
    }

}
