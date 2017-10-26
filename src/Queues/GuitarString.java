package Queues;

/**
 * Created by 131111 on 9/6/2017.
 */
public class GuitarString {

    private ArrayQueue ring;
    private int tics = 0;
    private int size;

    public GuitarString(double frequency){
        size = (int)Math.ceil(44100/frequency);
        ring = new ArrayQueue(size);
    }

    public GuitarString(double[] init){
        ring = new ArrayQueue(0);
        ring.setQueue(init);
    }

    void pluck(){
        ring.clear();
        while(!ring.isFull()){
            ring.enqueue(Math.random()-.5);
        }
    }

    void tic(){
        tics++;
//        System.out.println(ring.size());
        double a = ring.dequeue();
        double b = ring.peek();
        double result = (a+b)*.994*.5;
//        System.out.println(ring.size());
        ring.enqueue(result);
//        System.out.println(ring);
    }

    void cycle(){
        ring.enqueue(ring.dequeue());
    }
    int time(){
        return tics;
    }
    
    double sample(){
        if(!ring.isEmpty()){
            return ring.peek();
        }else{

            return 0;
        }

    }

    @Override
    public String toString() {
        return ring.toString();
    }
}
