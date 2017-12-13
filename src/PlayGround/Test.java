package PlayGround;

import Hash.HashTableLL;
import Hash.Name;
import LinkedLists.LinkedListStack;

import java.math.BigInteger;

public class Test {

    public static void main(String[] args){
        HashTableLL ht = new HashTableLL(17);
        ht.put(11, "dum dum dum");
        ht.put(22, "tehge");
        ht.put(0,  "fart");
        ht.put(17, "poop");

        System.out.println(ht);
    }
}
