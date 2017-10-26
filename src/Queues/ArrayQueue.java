package Queues;

import java.util.*;

/**
 * Created by 131111 on 9/5/2017.
 */
public class ArrayQueue{

    private double[] arr;
    private int beg, count;

    public ArrayQueue(int size){
        arr = new double[size];
        count = 0;
        beg = 0;
    }

    public double dequeue(){
        if(isEmpty()){
            return 0.0;
        }
        double temp = arr[beg];
        beg = (beg +1) % arr.length;
        count--;
        return temp;
    }

    public boolean enqueue(double d){
        if(isFull()){
            return false;
        }
        count++;
        arr[(beg+count-1)%arr.length] = d;
        return true;
    }

    public double peek(){
        return arr[beg];
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public boolean isFull(){
        return size() == arr.length;
    }

    public int size() {
        return count;
    }

    public String toString(){
       return Arrays.toString(arr);
    }

    @Deprecated
    void setQueue(double[] init){
        arr = init;
    }

    void clear(){
        beg = 0;
        count = 0;
    }

}
