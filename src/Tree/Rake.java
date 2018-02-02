package Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by 131111 on 1/31/2018.
 */
public class Rake {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("rake.dat"));

        while(s.hasNextLine()){
            String line = s.nextLine();
            if(line.equals("-1")){
                return;
            }

            HashMap<Integer, Integer> columns = new HashMap<>();

            char[] chars = line.replaceAll("-1", "-").replaceAll(" ", "").toCharArray();

            int column = 0;
            boolean left = true;

            for(char c: chars){
                if(c == '-'){
                    if(!left){
                        left = true;
                    }else{
                        column++;
                        left = false;
                    }
                }else{
                    if(left){
                        if(!columns.containsKey(column)){
                            columns.put(column, c-48);
                        }else{
                            columns.put(column, columns.get(column)+(c-48));
                        }
                        column -= 1;
                    }else{
                        if(!columns.containsKey(column)){
                            columns.put(column, c-48);
                        }else{
                            columns.put(column, columns.get(column)+(c-48));
                        }
                        column += 1;
                    }
                }
            }
            for(Integer i: columns.values()){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

}
