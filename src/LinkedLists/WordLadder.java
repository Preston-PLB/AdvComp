package LinkedLists;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class WordLadder {

    static HashSet<String> dict;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner inputScanner = new Scanner(new File("input.txt"));
        Scanner dictionaryScanner = new Scanner(new File("dictionary.txt"));
        HashSet<String> dictionary = new HashSet<>();

        while(dictionaryScanner.hasNextLine()){
            String line = dictionaryScanner.nextLine().trim();
            if(!line.equals("")){
                dictionary.add(line);
            }
        }
        dict = (HashSet<String>)dictionary.clone();

        while(inputScanner.hasNext()){
            String start = inputScanner.next();
            String finish = inputScanner.next();

            LinkedListStack stack = isWordLadder(start, finish);

            String out;
            if(stack != null){
                out = stack.pop()+"]";
                while(stack.size()>0){
                    out = stack.pop()+", "+out;
                }
                out = "["+out;
            }else{
                out = "There is no word ladder between "+ start + " and " + finish +"!";
            }
            System.out.println(out);
            dict = (HashSet<String>)dictionary.clone();
        }

    }

    private static LinkedListStack isWordLadder(String start, String finish){
        if(!dict.contains(start) || !dict.contains(finish)){
            return null;
        }
        LinkedListQueue ladders = new LinkedListQueue();
        LinkedListStack starterStack = new LinkedListStack();
        starterStack.push(start);
        ladders.enqueue(starterStack);

        while(!dict.isEmpty() && ladders.size() > 0){
            LinkedListStack stack = (LinkedListStack) ladders.dequeue();
            if(stack.peek().equals(finish)){
                return stack;
            }
            LinkedListStack similar = findSimilar((String)stack.peek());
            while(similar.size()>0){
                LinkedListStack temp = stack.copy();
                temp.push(similar.pop());
                ladders.enqueue(temp);
            }
        }
        return null;
    }

    private static LinkedListStack findSimilar(String word) {
        int length = word.length();
        dict.remove(word);
        LinkedListStack s = new LinkedListStack();
        LinkedListStack out = new LinkedListStack();

        for(int i = 0; i<length; i++){
            for(int x = 0; x<26; x++ ) {
                if (i == length - 1) {
                    s.push(word.substring(0, i) + String.valueOf((char)(97 + x)));
                } else {
                    s.push(word.substring(0, i) + String.valueOf((char)(97 + x)) + word.substring(i + 1));
                }
            }
        }
        while(s.size()>0){
            String str = (String)s.pop();
            if(dict.contains(str)){
                out.push(str);
                dict.remove(out);
            }
        }
        return out;
    }

    private static boolean isOneDifferent(String str, String word) {
        int length = word.length();
        boolean diff = false;
        for(int i=0; i<length; i++){
            if(str.charAt(i) != word.charAt(i)){
                if(!diff){
                    diff = true;
                }else{
                    return false;
                }
            }
        }
        return diff;
    }

}
