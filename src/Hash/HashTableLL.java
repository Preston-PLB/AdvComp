package Hash;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by 131111 on 11/6/2017.
 */
public class HashTableLL {

    private int insertCollisions = 0;
    private int fetchExistCollisions = 0;
    private int fetchVoidCollisions = 0;

    private ArrayDeque<Node>[] array;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTableLL(){
        array = (ArrayDeque<Node>[])Array.newInstance(ArrayDeque.class, 101);
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public HashTableLL(int startSize){
        array = (ArrayDeque<Node>[])Array.newInstance(ArrayDeque.class, startSize);
        size = 0;
    }

    public Object put(Object key, Object value){
        Node pair = new Node(key, value);
        int hash = hash(key);
        if(array[hash] == null){
            array[hash] = new ArrayDeque<>();
            array[hash].add(pair);
            size++;
            return null;
        }
        ArrayDeque<Node> temp = new ArrayDeque<>();

        for(int i = 0; i<array[hash].size(); i++){
            Node n = array[hash].pop();
            if(!n.equals(pair)){
                temp.add(n);
            }
            insertCollisions++;
        }
        temp.add(pair);
        array[hash] = temp;

        return null;
    }

    public Object get(Object key){
        int hash = hash(key);
        if(array[hash] == null){
            return null;
        }
        if(array[hash].size() == 1){
            return array[hash].peek();
        }
        for(Node n: array[hash]){
            if(n.key.equals(key)){
                return n;
            }
            fetchExistCollisions++;
        }
        return false;
    }

    private int hash(Object key){
        int raw = Math.abs(key.hashCode());
        return raw%array.length;
    }

    ArrayDeque[] getArray(){
        return array;
    }

    public int getInsertCollisions(){
        return insertCollisions;
    }

    public int getFetchExistCollisions() {
        return fetchExistCollisions;
    }

    public int getFetchVoidCollisions() {
        return fetchVoidCollisions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(ArrayDeque<Node> ad: array){
            if(ad == null){
                continue;
            }
            for(Node n: ad){
                sb.append(n);
                sb.append(',');
            }
        }
        return sb.toString();
    }

    /*
    *
    * ANOTHER CLASS DUMMY
    *
    * */

    private class Node{
        Object key, value;
        boolean deleted;

        public Node(){

        }

        public Node(Object key, Object value){
            this.key = key;
            this.value = value;
            this.deleted = false;
        }

        @Override
        public String toString() {
            if(deleted){
                return "dummy";
            }
            return key.toString()+" "+value.toString();
        }
    }

}
