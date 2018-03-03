package PlayGround;

import Compressor.BitInputStream;
import GraphTheory.DepthFirstPaths;
import GraphTheory.UnorderedGraph;
import Hash.HashTableLL;
import Hash.Name;
import LinkedLists.LinkedListStack;
import Tree.Heap.Heap;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;

public class Test {

    public static void main(String[] args){
        UnorderedGraph ug = new UnorderedGraph(6);
        ug.addEdge(0, 1);
        ug.addEdge(1, 2);
        ug.addEdge(2, 3);
        ug.addEdge(4, 5);
        DepthFirstPaths dpp = new DepthFirstPaths(ug, 2);
        System.out.println(dpp.hasPathTo(5));
    }
}
