package Compressor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Compressor {

    public static void main(String[] args) throws FileNotFoundException {
        BitInputStream bs = new BitInputStream(new File("compressionTest.txt"));

        HashMap<Character, Integer> frequencyData = new HashMap<>();

        int i = 0;
        int total = 0;
        while(true){
           try{
              i = bs.read();
           } catch (IOException ioe){
               ioe.printStackTrace();
           }
           if(i == -1){
               break;
           }
           if(!frequencyData.containsKey((char)i)){
               frequencyData.put((char)i, 1);
           }else{
               frequencyData.put((char)i, frequencyData.get((char)i)+1);
           }
           total++;
        }

        bs.close();

        PriorityQueue<BinarySearchTree> trees = new PriorityQueue<>();
        for(Map.Entry<Character, Integer> pair: frequencyData.entrySet()){
            trees.add(new BinarySearchTree(new CodeChar(pair.getKey(), pair.getValue())));
        }

        while(trees.size() > 1){
            BinarySearchTree a = trees.poll();
            BinarySearchTree b = trees.poll();
            BinarySearchTree c = new BinarySearchTree(a, b);

            trees.add(c);
        }

        BitOutputStream bos = new BitOutputStream("compressed.pleb");
        BinarySearchTree bst = trees.peek();
        HashMap<Character, String> codes = bst.getCodes();
        HashMap<String, Character> sedoc = new HashMap<>();

        for(Map.Entry<Character, String> pair: codes.entrySet()){
            sedoc.put(pair.getValue(), pair.getKey());
        }

        bs =  new BitInputStream(new File("compressionTest.txt"));
        i = 0;
        bos.writeBits(32, total);

        while(true){
            try{
                i = bs.read();
                if(i == -1){
                    break;
                }
                String code = codes.get((char)i);
                bos.writeBits(code.length(), Integer.parseInt(code, 2));
            } catch (IOException ioe){
                ioe.printStackTrace();
            }

        }
        bos.close();

        BitInputStream unc = new BitInputStream(new File("compressed.pleb"));
        BitOutputStream un = new BitOutputStream("unCompressed.txt");
        int x, max = 22;
        try {
            max = unc.readBits(32);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "";
        while(max != 0){
            try{
                x = unc.readBits(1);
                if(x == -1){
                    break;
                }
                str += x;
                if(sedoc.containsKey(str)){
                    un.write((int)sedoc.get(str));
                    str = "";
                    max--;
                }
            } catch (IOException ioe){
                ioe.printStackTrace();
            }
        }

        unc.close();
        un.close();
    }

}
