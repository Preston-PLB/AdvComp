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
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double calcPrecent(){
        return freq/total;
    }

    @Override
    public int compareTo(Object o) {
        Tree t = (Tree)o;
        return name.compareTo(t.name);
    }

    @Override
    public String toString() {
        return name+" "+cheeky(calcPrecent(), 4);
    }

    private double cheeky(double raw, int length){
        return (raw*Math.pow(10,length))/Math.pow(10, length);
    }
}
