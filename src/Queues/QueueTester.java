package Queues;

import LinkedLists.LinkedListQueue;

/**
 * Created by 131111 on 9/5/2017.
 */
public class QueueTester {

    public static void main(String[] args){
        LinkedListQueue aq = new LinkedListQueue();

        for(int i = 0; i< 5; i ++){
            aq.enqueue(i);
        }

        for(int i = 0; i<5; i++){
            aq.enqueue(((Integer)aq.dequeue())+5);
            System.out.println(aq);
        }
    }

}
