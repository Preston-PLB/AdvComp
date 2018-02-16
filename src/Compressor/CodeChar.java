package Compressor;

public class CodeChar {

    private Character c;
    private int freq;
    private boolean filler;

    public CodeChar(){
        c = null;
        freq = 0;
        filler = true;
    }

    public CodeChar(char c){
        this.c = c;
        freq = 1;
        filler = false;
    }

    public void increment(){
        freq++;
    }

    public int getFreq(){
        return freq;
    }

    public void setFreq(int freq){
        this.freq = freq;
    }

    public Character getChar() {
        return c;
    }

    public boolean isFiller(){
        return filler;
    }
}
