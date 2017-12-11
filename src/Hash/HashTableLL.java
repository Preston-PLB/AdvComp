package Hash;

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
        array = new ArrayDeque[101];
        size = 0;
    }

    @SuppressWarnings("unchecked")
    public HashTableLL(int startSize){
        array = new ArrayDeque[startSize];
        size = 0;
    }

    public Object put(Object key, Object value){
        int hash = hash(key);
        if(array[hash] == null){
            array[hash] = new ArrayDeque<>();
            array[hash].add(new Node(key, value));
            size++;
            return null;
        }
        array[hash].add(new Node(key, value));
        ArrayDeque<Node> temp = new ArrayDeque<>();
        for(int i = 0; i<array[hash].size()-1; i++){

        }
        return null;
    }

    public Object remove(Object key){
        int hash = hash(key);
        if(size == 0){
            return null;
        }
        Node n = array[hash];
        if(n.key.equals(key)){
            n.deleted = true;
            size--;
            Object temp = n.value;
            array[hash] = new Node();
            array[hash].deleted = true;
            return temp;

        }else{
            for(int i = hash; i < array.length; i++){
                if(array[i] == null){
                    return null;
                }
                if(array[i].key.equals(key)){
                    array[i].deleted = true;
                    size--;
                    return array[i].value;
                }
            }
            for(int i = 0; i < hash; i++){
                if(array[i] == null){
                    return null;
                }
                if(array[i].key.equals(key)){
                    array[i].deleted = true;
                    size--;
                    return array[i].value;
                }
            }
        }
        return null;
    }

    public Object get(Object key){
        int temp = 0;
        if(size == 0){
            return null;
        }
        int hash = hash(key);
        if(array[hash] == null){
            return null;
        }
        if(array[hash].key.equals(key)){
            return array[hash];
        }else{
            for(int i = hash; i < array.length; i++) {
                if(array[i] == null){
                    return null;
                }
                if(array[i].key.equals(key)){
                    fetchExistCollisions += temp;
                    return array[i];
                }
                temp++;
            }
            for(int i = 0; i < hash; i++){
                if(array[i] == null){
                    return null;
                }
                if(array[i].key.equals(key)){
                    fetchExistCollisions += temp;
                    return array[i];
                }
                temp++;
            }
        }
        fetchVoidCollisions += temp;
        return null;
    }

    private int hash(Object key){
        int raw = Math.abs(key.hashCode());
        return raw%array.length;
    }

    Node[] getArray(){
        return  array;
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
        for(Node n: array){
            if(n != null) {
                sb.append(n);
                sb.append(", ");
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
