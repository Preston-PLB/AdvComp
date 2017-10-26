package Stacks;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trains {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("out/production/RPN/Test.txt"));

        while(true){
            int size = s.nextInt();
            if(size == 0){
                break;
            }
            ArrayStack<Integer> train = new ArrayStack<>(Integer.class, size);
            int index = 0;
            int temp;
            while(true){
                if(index < size){
                    temp = s.nextInt();
                    if(temp == 0){
                        System.out.println();
                        break;
                    }
                    train.push(temp);
                    index++;
                }
                else{
                    String out = willIt(train) ? "Yes" : "No";
                    System.out.println(out);
                    index = 0;
                    train.clear();
                }
            }
        }
    }

    private static boolean willIt(ArrayStack<Integer> train){
        int size = train.size();
        int max = train.size();
        ArrayStack<Integer> station = new ArrayStack<>(Integer.class, size);
        for(int i = 0; i < size; i++){
            station.push(train.pop());
            int s = station.peek();
            if(s == max){
                station.pop();
                max--;
                while(!station.isEmpty() && station.peek() == max){
                    station.pop();
                    max--;
                }
            }
        }
        return station.isEmpty();
    }
}
