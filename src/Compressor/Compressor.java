package Compressor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Compressor {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("compressionTest.txt"));

        HashMap<Character, Integer> frequencyData = new HashMap<>();

        while(s.hasNext()){
            char[] chars = s.next().toCharArray();
            for(char c: chars) {
                if (frequencyData.containsKey(c)) {
                    frequencyData.put(c, frequencyData.get(c) + 1);
                } else {
                    frequencyData.put(c, 1);
                }
            }
        }

        PriorityQueue<BinarySearchTree> trees = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> pair: frequencyData.entrySet()){
            trees.add(new BinarySearchTree(new CodeChar(pair.getKey(), pair.getValue())));
        }

        while(trees.size() > 1){
            BinarySearchTree a = trees.poll();
            BinarySearchTree b = trees.poll();
            BinarySearchTree c = new BinarySearchTree();

        }

        System.out.println(trees.peek());
    }

}
