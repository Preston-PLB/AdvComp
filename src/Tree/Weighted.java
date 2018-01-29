package Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 131111 on 1/25/2018.
 */
public class Weighted {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("righttree.dat"));

        int tc = s.nextInt();
        s.nextLine();

        for(int i = 0; i < tc; i++){
            String line = s.nextLine();
            if(line.length() == 1){
                System.out.println("Tree "+ (i+1)+" is a right-tree");
                continue;
            }
            String temp = line.substring(1);
            if(line.length() == 2){
                System.out.println("Tree "+ (i+1)+" is not a right-tree");
            }
            int left, right, level;
                left = right = 0;
                level = 2;

            while(temp.length() > level){
                String str = temp.substring(0,level/2);
                for(char c: str.toCharArray()){
                    if(c == '1'){
                        left++;
                    }
                }
                temp = temp.substring(level/2+1);
                str = temp.substring(0,level/2);
                for(char c: str.toCharArray()){
                    if(c == '1'){
                        right++;
                    }
                }
                level *= 2;
            }
            String str = temp.substring(0,level/2);
            for(char c: str.toCharArray()){
                if(c == '1'){
                    left++;
                }
            }
            temp = temp.substring(level/2+1);
            str = temp;
            for(char c: str.toCharArray()){
                if(c == '1'){
                    right++;
                }
            }

            if(right >= left){
                System.out.println("Tree "+ (i+1)+" is a right-tree");
            }else{
                System.out.println("Tree "+ (i+1)+" is a not right-tree");
            }

        }
    }

}
