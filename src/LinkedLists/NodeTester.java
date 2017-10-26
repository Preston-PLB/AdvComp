package LinkedLists;

public class NodeTester {

    public static void main(String[] args){
        Node steve = new Node(new Actor("steve"));
        Node aaron = new Node(new Actor("Aaron"));
        Node john = new Node(new Actor("John"));
        Node alli = new Node(new Actor("Alli"));
        Node mason = new Node(new Actor("Mason"));

        Node head = new Node();

        steve.setNext(head);
        head = steve;
        aaron.setNext(head);
        head = aaron;
        john.setNext(head);
        head = john;
        alli.setNext(head);
        head = alli;
        mason.setNext(head);
        head = mason;

        Node h = head;
        while(h.getNext() != null){
            System.out.println(h + ",");
            h = h.getNext();
        }

        System.out.println(head.get());

    }

}
