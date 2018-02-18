package PlayGround;

import Compressor.BitInputStream;
import Hash.HashTableLL;
import Hash.Name;
import LinkedLists.LinkedListStack;
import Tree.Heap.Heap;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

public class Test {

    public static void main(String[] args){
        BitInputStream bs = new BitInputStream(new File("compressionTest.txt"));

        for(int i = 0; i<100; i++){
            try {
                System.out.print((char)bs.read());
            }catch (IOException ie){
                ie.printStackTrace();
            }
        }
    }
}
