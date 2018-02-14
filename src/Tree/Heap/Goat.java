package Tree.Heap;

import java.util.Arrays;

/**
 * Created by 131111 on 2/14/2018.
 */
public class Goat {

    private int[] milkCycle;
    private int index;

    public Goat(){
        milkCycle = new int[10];
        index = 0;
    }

    public Goat(int cycleSize){
        milkCycle = new int[cycleSize];
        index = 0;
    }

    public void setMilkCycle(int[] milkCycle) {
        this.milkCycle = milkCycle;
    }

    public int getMilk(){
        return milkCycle[index];
    }

    public void cycleMilk(){
        if(index+1 >= milkCycle.length){
            index = 0;
        }else{
            index++;
        }
    }

    public boolean equals(Goat goat){
        for(int i = 0; i<milkCycle.length; i++){
            if(getMilk() != goat.getMilk()){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        return Arrays.toString(milkCycle);
    }

}
