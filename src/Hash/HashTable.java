package Hash;

/**
 * Created by 131111 on 11/6/2017.
 */
public class HashTable {

    private Node[] array;

    public HashTable(){
        array = new Node[101];
    }

    public HashTable(int startSize){
        array = new Node[startSize];
    }

    public Object put(Object key, Object value) {
        Object prev = null;
        Node n = new Node(key, value);
        if(array[hash(key)] != null){
            prev = array[hash(key)];
        }
        array[hash(key)] = n;
        return prev;
    }

    public Object get(Object key){
        return array[hash(key)].value;
    }

    private int hash(Object key){
        int raw = key.hashCode();
        return raw%array.length;
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

    private class Node{
        public Object key, value;

        public Node(){

        }

        public Node(Object key, Object value){
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key.toString()+" "+value.toString();
        }
    }

}
