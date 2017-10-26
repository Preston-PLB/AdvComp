package Stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 131111 on 8/25/2017.
 */
public class Balance {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("out/production/RPN/Test.txt"));
        int terms = s.nextInt();
        s.nextLine();
        for(int i = 0; i<terms; i++){
            String raw = s.nextLine();
            ArrayStack<Character> opens = new ArrayStack<>(Character.class, 100);
            char[] array = raw.toCharArray();
            boolean works = true;
            for(char c: array){
                if(c == '(' || c == '['){
                    opens.push(c);
                }else{
                    if(opens.isEmpty()){
                        works = false;
                        opens.pop();
                        break;
                    }
                    if((c == ')' && (opens.peek().equals(')') || opens.peek().equals('[') || opens.peek().equals(']'))) || (c == ']' && (opens.peek().equals(')') || opens.peek().equals('(') || opens.peek().equals(']')))){
                        works = false;
                        opens.pop();
                        break;
                    }else{
                        opens.pop();
                    }
                }
            }
            if(!opens.isEmpty()){
                works = false;
            }
            String out = works ? "Yes" : "No";
            System.out.println(out);
        }
    }

}
