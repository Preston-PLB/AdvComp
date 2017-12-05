package Hash;

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

    public int hashCode(){
        char[] arr = (first+last).toCharArray();
        long hash = 0;
        for(int i = 0; i<arr.length; i++){
            hash += Math.pow(((int)(arr[i]))-48, 52);
        }
        return (int)hash%Integer.MAX_VALUE;
    }
}
