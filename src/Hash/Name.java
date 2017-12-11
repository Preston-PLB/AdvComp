package Hash;

import java.math.BigInteger;

/**
 * Created by 131111 on 12/5/2017.
 */
public class Name {

    private String first, last;

    public Name(){
        this.first = "Alexander";
        this.last = "Anderson";
    }

    public Name(String first, String last){
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object o){
        Name n = (Name)o;
        return (n.getFirst().equals(first) && n.getLast().equals(last));
    }

    public String getFirst(){
        return first;
    }

    public String getLast(){
        return last;
    }

    public int hashCode(){
        char[] arr = (first+last).toCharArray();
        BigInteger hash = new BigInteger("0");
        for(int i = 0; i<arr.length; i++){
            hash = hash.add(new BigInteger(Integer.toString(arr[i]*(int)Math.pow(52, i))));
        }
        return Integer.parseInt(hash.mod(new BigInteger("1000000000")).toString());
    }
}
