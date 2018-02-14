package PlayGround;

import Hash.HashTableLL;
import Hash.Name;
import LinkedLists.LinkedListStack;
import Tree.Heap.Heap;

import java.math.BigInteger;

public class Test {

    public static void main(String[] args){
        Heap heap = new Heap(5);
        heap.insert(5);
        heap.insert(2);
        heap.insert(6);
        heap.insert(22);
        heap.insert(4);

        System.out.println(heap);
    }
}
