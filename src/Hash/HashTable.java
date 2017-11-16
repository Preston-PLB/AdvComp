package Hash;

/**
 * Created by 131111 on 11/6/2017.
 */
public class HashTable {

    private int insertCollisions = 0;
    private int fetchExistCollisions = 0;
    private int fetchVoidCollisions = 0;

    private Node[] array;
    private int size;

    public HashTable(){
        array = new Node[101];
        size = 0;
    }

    public HashTable(int startSize){
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
            for(int x = hash; x<array.length; x++){
                if(array[x].key.equals(key)){
                    array[x] = n;
                    return null;
                }
                insertCollisions++;
            }
            for(int x = 0; x<hash; x++){
                if(array[x].key.equals(key)){
                    array[x] = n;
                    return null;
                }
                insertCollisions++;
            }
            return null;
        }
        else{
            for(int i = hash; i < array.length; i++){
                if(array[i] == null){
                    array[i] = n;
                    size++;
                    return null;
                }
                if(array[i].key.equals(key)){
                    array[i] = n;
                    return null;
                }
                if(array[i].deleted){
                    array[i] = n;
                    for(int x = i; x<array.length; x++){
                        if(array[x].key.equals(key)){
                            array[x] = n;
                            return null;
                        }
                        insertCollisions++;
                    }
                    return null;
                }
                insertCollisions++;
            }
            for(int i = 0; i < hash; i++){
                if(array[i] == null){
                    array[i] = n;
                    size++;
                    return null;
                }
                if(array[i].key.equals(key)){
                    array[i] = n;
                    return null;
                }
                if(array[i].deleted){
                    array[i] = n;
                    for(int x = i; x<hash; x++){
                        if(array[x].key.equals(key)){
                            array[x] = n;
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
        if(array[hash].key.equals(key)){
            return array[hash];
        }else{
            for(int i = hash; i < array.length; i++) {
                if(array[i].key.equals(key)){
                    fetchExistCollisions += temp;
                    return array[i];
                }
                temp++;
            }
            for(int i = 0; i < hash; i++){
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
        int raw = key.hashCode();
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
