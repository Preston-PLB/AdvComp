package Queues;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by 131111 on 9/13/2017.
 */
public class War {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("war.dat"));

        ArrayQueue playerOne;
        ArrayQueue playerTwo;

        while(s.hasNextLine()){
            String line1 = s.nextLine();
            String line2 = s.nextLine();
            playerOne = new ArrayQueue(52);
            playerTwo = new ArrayQueue(52);
            for(int i = 0; i<line1.length(); i+=3){
                char c = line1.charAt(i);
                if((int)c - 48 < 11){
                    playerOne.enqueue((double) c);
                }else{
                    switch(c){
                        case 'T':
                            playerOne.enqueue(10);
                            break;
                        case 'J':
                            playerOne.enqueue(11);
                            break;
                        case 'Q':
                            playerOne.enqueue(12);
                            break;
                        case 'K':
                            playerOne.enqueue(13);
                            break;
                        case 'A':
                            playerOne.enqueue(14);
                            break;
                    }
                }
            }

            for(int i = 0; i<line2.length(); i+=3){
                char c = line2.charAt(i);
                if((int)c - 48 < 11){
                    playerTwo.enqueue((double) c);
                }else{
                    switch(c){
                        case 'T':
                            playerOne.enqueue(10);
                            break;
                        case 'J':
                            playerOne.enqueue(11);
                            break;
                        case 'Q':
                            playerOne.enqueue(12);
                            break;
                        case 'K':
                            playerOne.enqueue(13);
                            break;
                        case 'A':
                            playerOne.enqueue(14);
                            break;
                    }
                }
            }
            int round = 0;

            while(!playerOne.isEmpty() && !playerTwo.isEmpty() && round < 100000){
                round++;
                double a = playerOne.dequeue();
                double b = playerTwo.dequeue();

                if(a > b){
                    playerOne.enqueue(a);
                    playerOne.enqueue(b);
                }else if(a < b){
                    playerTwo.enqueue(a);
                    playerTwo.enqueue(b);
                }else{
                    ArrayQueue list = new ArrayQueue(52);
                    double t1;
                    double t2;
                    double c1;
                    double c2;

                    do{
                        t1 = playerOne.dequeue();
                        t2 = playerTwo.dequeue();
                        c1 = playerOne.dequeue();
                        c2 = playerTwo.dequeue();
                        list.enqueue(t1);
                        list.enqueue(t2);
                        list.enqueue(c1);
                        list.enqueue(c2);
                    }while(c1 == c2);
                    if(c1 > c2){
                        int size = list.size();
                        for(int i = 0; i<size; i++){
                            playerOne.enqueue(list.dequeue());
                        }
                    }else{
                        int size = list.size();
                        for(int i = 0; i<size; i++){
                            playerTwo.enqueue(list.dequeue());
                        }
                    }
                }
            }
            if(round == 100000){
                System.out.println("Tie game stopped at 100000 plays");
            }else{
                String out = playerOne.isEmpty() ? "Player Two Wins!" : "Player One Wins";
                System.out.println(out);
            }
        }
    }

}
