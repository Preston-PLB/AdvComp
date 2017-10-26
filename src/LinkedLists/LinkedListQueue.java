package LinkedLists;

public class LinkedListQueue {
    private Node head;
    private Node tail;
    private int count;

    public LinkedListQueue(){
        head = null;
        tail = null;
        count = 0;
    }

    public void enqueue(Object o){
        Node node = new Node(o);
        if(head == null){
            head = tail = node;
        }else{
            tail.setNext(node);
            tail = node;
        }
        count++;
    }

    public Object dequeue(){
        if(count > 0){
            Node temp = head;
            head = temp.getNext();
            count--;
            return temp.get();
        }
        return null;
    }

    public Object peek(){
        if(count > 0){
            return head.get();
        }
        return null;
    }

    public int size(){
        return count;
    }

    public void clear(){
        count = 0;
        head = null;
        tail = null;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node h = head;
        while(h != null){
            sb.append(h.get());
            sb.append(", ");
            h = h.getNext();
        }
        return sb.toString();
    }

    public LinkedListQueue copy(){
        Node t = head;
        LinkedListQueue out = new LinkedListQueue();
        while(t != null){
            out.enqueue(t.get());
            t = t.getNext();
        }
        return out;
    }
}
