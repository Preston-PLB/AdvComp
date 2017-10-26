package LinkedLists;

/**
 * Created by 131111 on 9/29/2017.
 */
public class LinkedList {
    private Node head;
    private int count;

    public LinkedList(){
        head = null;
        count = 0;
    }

    void add(Node node){
        node.setNext(head);
        head = node;
        count += 1;
    }

    public Node get(int index){
        if(index > count){
            return null;
        }
        Node temp = head;
        for(int i = 0; i<index; i++){
            temp = temp.getNext();
        }
        return temp;
    }

    public int size(){
        return count;
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
}
