package Tree.Heap;

import java.util.Arrays;

public class Heap {

    private int[] arr;
    private int size;

    public Heap(){
        arr = new int[33];
        size = 0;
    }

    public Heap(int size){
        arr = new int[size];
        size = 0;
    }

    private boolean hasLeft(int index){
        return 2*index+1 < size;
    }
    private boolean hasRight(int index){
        return 2*index+2 < size;
    }
    private boolean hasParent(int index){
        if(index == 3){
            return true;
        }
        return (index-1)/2 > 0;
    }

    private int getRightI(int index){
        return 2*index+2;
    }
    private int getLeftI(int index){
        return 2*index+1;
    }
    private int getParentI(int index){
        return (index-1)/2;
    }

    private int getRight(int index){
        return arr[2*index+2];
    }
    private int getLeft(int index){
        return arr[2*index+1];
    }
    private int getParent(int index){
        return arr[getParentI(index)];
    }

    public int getSize(){
        return size;
    }

    private void swap(int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    public int peek(){
        return arr[0];
    }

    public int pop(){
        if(size == 0){
            return -5;
        }
        int out = arr[0];
        arr[0] = arr[size-1];
        arr[size-1] = -69;
        size--;
        minify(0);
        return out;
    }

    public void insert(int value){
        if(size == 0){
            arr[0] = value;
        }else{
            int temp = size;
            arr[temp] = value;
            while(temp > 0 && arr[temp] < arr[getParentI(temp)]){
                swap(temp, getParentI(temp));
                temp = getParentI(temp);
            }
        }
        size++;
    }

    public boolean topIsUnique(){
        return arr[0] != arr[1] && arr[0] != arr[2];
    }

    private void minify(int i){
        int l = getLeftI(i);
        int r = getRightI(i);
        int small = i;
        if(l < size && arr[l] < arr[i]){
            small = l;
        }else if(r < size && arr[r] < arr[i]){
            small = r;
        }
        if(small != i){
            swap(i, small);
            minify(small);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr)+" size = "+size;
    }
}
