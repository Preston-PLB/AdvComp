package Hash;

/**
 * Created by 131111 on 11/6/2017.
 */
public class HashTableQuad {

    private int insertCollisions = 0;
    private int fetchExistCollisions = 0;
    private int fetchVoidCollisions = 0;

    private Node[] array;
    private int size;

    public HashTableQuad(){
        array = new Node[101];
        size = 0;
    }

    public HashTableQuad(int startSize){
        array = new Node[startSize];
        size = 0;
    }

    public Object put(Object key, Object value){
        if(size == array.length){
            return null;
        }
        int hash = hash(key);
        Node n = new Node(key, value);
        if(array[hash] == null){
            array[hash] = n;
            size++;
            return null;
        }
        if(array[hash].deleted){
            array[hash] = n;
            for(int x = 0; x<9002; x++){
                int pos = (int)(hash+Math.pow(x,2))%array.length;
                if(array[pos].key.equals(key)){
                    array[pos] = n;
                    return null;
                }
                insertCollisions++;
            }
        }
        else{
            for(int i = 0; i<9002; i++){
                int pos = (int)(hash+Math.pow(i,2))%array.length;
                if(array[pos] == null){
                    array[pos] = n;
                    size++;
                    return null;
                }
                if(array[pos].key.equals(key)){
                    array[pos] = n;
                    return null;
                }
                if(array[pos].deleted){
                    array[pos] = n;
                    for(int x = 0; x<9002; x++){
                        int pos2 = (int)(hash+Math.pow(x,2))%size;
                        if(array[pos2].key.equals(key)){
                            array[pos2] = n;
                            return null;
                        }
                        insertCollisions++;
                    }
                    return null;
                }
                insertCollisions++;
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
            for(int i =0; i<9002; i++) {
                int pos = (int)(hash+Math.pow(i,2))%size;
                if(array[pos] == null){
                    return null;
                }
                if(array[pos].key.equals(key)){
                    fetchExistCollisions += temp;
                    return array[pos];
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
