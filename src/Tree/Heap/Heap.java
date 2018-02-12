package Tree.Heap;

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
        return arr[(index-1)/2];
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
        size--;
        heapDown();
        return out;
    }

    public void insert(int value){
        arr[size] = value;
        size++;
        heapUp();
    }

    private void heapDown() {
        int i = 0;
        while(hasLeft(i)){
            int small = getLeftI(0);
            if(hasRight(i) && getRight(i) < getLeft(i)){
                small = getRightI(i);
            }

            if(arr[i] <= arr[small]){
                break;
            }else{
                swap(i, small);
            }
            i = small;
        }
    }

    private void heapUp(){
        int i = size-1;
        while(hasParent(i) && getParent(i) < arr[i]){
            swap(i, getParentI(i));
            i = getParentI(i);
        }
    }
}
