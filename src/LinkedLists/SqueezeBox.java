package LinkedLists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by 131111 on 10/19/2017.
 */
public class SqueezeBox {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("squeezebox.dat"));
        while(s.hasNextLine()){
            String line = s.nextLine().trim();
            if(s.hasNextLine()){
                line+=" "+s.nextLine();
            }else{
                break;
            }

            ArrayDeque<Card> deck = new ArrayDeque<>();
            Scanner str = new Scanner(line);
            while(str.hasNext()){
                deck.add(new Card(str.next()));
            }

            ArrayList<LinkedListStack> field = new ArrayList<>();

            while(!deck.isEmpty()){
                LinkedListStack stack = new LinkedListStack();
                stack.push(deck.removeFirst());

               field.add(stack);

               field = playGame(field);
            }
            System.out.print(field.size()+" piles remaining: ");
            for(LinkedListStack lls: field){
                System.out.print(lls.size()+" ");
            }
            System.out.println();
        }
    }

    private static ArrayList<LinkedListStack> playGame(ArrayList<LinkedListStack> field){

        boolean move = false;

        do{
            int buffer = 0;

            ArrayList<LinkedListStack> offset = new ArrayList<>();
            LinkedListStack prev = new LinkedListStack();
            LinkedListStack three = new LinkedListStack();

            Card current;
            Card previous = null;
            Card third = null;
            for(int i = 0; i<field.size(); i++){
                move = false;
                LinkedListStack stack = field.get(i);
                three = buffer > 2 ? offset.get(0) : new LinkedListStack();
                previous = (Card)prev.peek();
                current = (Card)stack.peek();
                third = (Card)three.peek();

                if(current.match(third)){
                    move = true;
                    three.push(stack.pop());
                    if(stack.size() == 0){
                        field.remove(i);
                    }
                    break;
                }
                if(current.match(previous)){
                    move = true;
                    prev.push(stack.pop());
                    if(stack.size() == 0){
                        field.remove(i);
                    }
                    break;
                }
                prev = stack;
                offset.add(stack);
                if(buffer > 2){
                    offset.remove(0);
                }
                buffer++;
            }
        }while(move);

        return field;
    }
}
