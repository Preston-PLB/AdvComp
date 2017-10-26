package Stacks;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by 131111 on 8/21/2017.
 */
 class ArrayStack<E> {

    private E[] main;
    private int top = -1;
    
    @SuppressWarnings("unchecked")
    ArrayStack (Class<E> type, int size){
        main = (E[])Array.newInstance(type, size);
    }

    void push(E value) {
        if(top < main.length-1){
            top++;
            main[top] = value;
        }
    }
    
    E pop() {
        if(!isEmpty()){
            E temp = main[top];
            top--;
            return temp;
        }
        return null;
    }
    
    E peek() {
        if(!isEmpty()){
            return main[top];
        }
        return null;
    }
    
    int size() {
        return top+1;
    }
    
    boolean isEmpty() {
        return size() == 0;
    }
    
    boolean isFull() {
        return size() >= main.length;
    }
    
    void clear() {
        top = -1;
    }

    public String toString(){
        return Arrays.toString(main);
    }
}
