package PlayGround;

import LinkedLists.LinkedListStack;

import java.math.BigInteger;

public class Test {

    public static void main(String[] args){
        String first = "presotn", last = "baxte";
        char[] arr = (first+last).toCharArray();
        BigInteger hash = new BigInteger("0");
        for(int i = 0; i<arr.length; i++){
            hash = hash.add(new BigInteger(Integer.toString((int)Math.pow(arr[i]-48, 52))));
        }
        System.out.println(Integer.parseInt(hash.mod(new BigInteger("1000000000")).toString()));

    }

}
