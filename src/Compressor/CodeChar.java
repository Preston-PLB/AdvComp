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

    public CodeChar(char c, int freq){
        this.c = c;
        this.freq = freq;
        filler = false;
    }

    public CodeChar(int freq){
        c = null;
        this.freq = freq;
        filler = true;
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

    @Override
    public String toString() {
        return c+" "+freq;
    }
}
