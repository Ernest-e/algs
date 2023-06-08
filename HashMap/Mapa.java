package algs.HashMap;

public class Mapa<K,V> {
    int sizeOfArr = 16;
    OneWayList<K, V>[] nodes = new OneWayList [sizeOfArr];



    public V put(K key, V value){
        Node<K,V> newNode = new Node<>();
        newNode.value = value;
        newNode.key = key;

        int indx = Math.abs(key.hashCode() % sizeOfArr);

        if (nodes[indx] == null){
            nodes[indx] = new OneWayList<K,V>();
            nodes[indx].add(key, value);
            return null;
        } else if (nodes[indx] != null){
            V oldVal = nodes[indx].rewriteValByKey(key, value);
            if (oldVal!=null){
                return oldVal;
            } else {
                nodes[indx].add(key, value);
                return null;
            }
        } else return null;
    }

    public V get(K key){
        int indx = Math.abs(key.hashCode() % sizeOfArr);
        if (nodes[indx] != null){
            V value = nodes[indx].getValByKey(key);
            return value;
        } else return null;
    }

    public V remove(K key){
        int indx = Math.abs(key.hashCode() % sizeOfArr);
        if (nodes[indx] != null){
            V value = nodes[indx].removeByKey(key);
            return value;
        } else return null;
    }

    public int size(){
        int res = 0;
        for (int i = 0; i < sizeOfArr; i++){
            if (nodes[i] != null){
                res += nodes[i].sizeOfList();
            }
        }
        return res;
    }

    public boolean containsKey(K key){
        int indx = Math.abs(key.hashCode() % sizeOfArr);
        if (nodes[indx] != null){
            boolean res = nodes[indx].containsKeyInList(key);
            return res;
        } else return false;

    }

    public boolean containsValue(V value){
        boolean res = false;
        for (int i = 0; i < sizeOfArr; i++){
            if (nodes[i] != null){
                res = nodes[i].containsValueInList(value);
                if (res == true){
                    return res;
                }
            }
        }
        return res;
    }



}
