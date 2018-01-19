package Hash.Program;

public class Tree implements Comparable{
    private String name;
    private int freq;

    private static double total;

    public Tree(String name){
        this.name = name;
        freq = 1;
        total++;
    }

    public int getFreq() {
        return freq;
    }

    public void incFreq() {
        freq++;
        total++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calcPrecent(){
        return freq/total*100;
    }

    @Override
    public int compareTo(Object o) {
        Tree t = (Tree)o;
        return name.compareTo(t.name);
    }

    @Override
    public String toString() {
        return name+" "+Math.round(calcPrecent()*10000)/10000.0;
    }
}
