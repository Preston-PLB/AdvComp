package LinkedLists;

import java.util.Comparator;

/**
 * Created by 131111 on 9/29/2017.
 */
public class Node {
    private Object data;
    private Node next;

    public Node(){
        data = null;
        next = null;
    }

    public Node(Object data){
        this.data = data;
    }

    public Object get() {
        return data;
    }

    public void set(String data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    @Override
    public String toString() {
        return get().toString();
    }
}
