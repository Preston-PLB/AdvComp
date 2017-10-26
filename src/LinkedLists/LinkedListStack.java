package LinkedLists;

public class LinkedListStack {
    private Node head;
    private int count;

    public LinkedListStack(){
        head = null;
        count = 0;
    }

    public void push(Object o){
        Node node = new Node(o);
        node.setNext(head);
        head = node;
        count += 1;
    }

    public Object pop(){
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

    public LinkedListStack copy(){
        Node temp = head;
        LinkedListStack out = new LinkedListStack();
        LinkedListStack t = new LinkedListStack();
        while(temp != null){
            t.push(temp);
            temp = temp.getNext();
        }
        while(t.size()>0){
            out.push(t.pop());
        }
        return out;
    }

}
