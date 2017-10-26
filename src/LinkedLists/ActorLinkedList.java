package LinkedLists;

public class ActorLinkedList {
    private Actor head;
    private int count;

    public ActorLinkedList(){
        head = null;
        count = 0;
    }

    void add(Actor actor){
        //actor.setNext(head);
        head = actor;
        count += 1;
    }

    public Actor get(int index){
        if(index > count){
            return null;
        }
        Actor temp = head;
        for(int i = 0; i<index; i++){
            //temp = temp.getNext();
        }
        return temp;
    }

    public int size(){
        return count;
    }
}
