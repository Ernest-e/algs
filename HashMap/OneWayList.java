package algs.HashMap;

public class OneWayList<K,V> {
    Node<K,V> head;

    public void add (K key, V value){
        Node <K,V> newNode = new Node<K,V>();
        newNode.value = value;
        newNode.key = key;
        if (head != null){
            newNode.next = head;
            head = newNode;
        } else {
            head = newNode;
            head.next = null;
        }
    }


    
    public V rewriteValByKey (K key, V value){
        Node<K,V> currentNode = head;
        while(currentNode!=null){
            if (currentNode.key == key) {
                V oldValue = currentNode.value;
                currentNode.value = value;
                return oldValue;
            
            }
            currentNode = currentNode.next;
        }
        return null;

    }

    public V getValByKey(K key){
        Node<K,V> currentNode = head;
        while(currentNode!=null){
            if (currentNode.key == key){
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public V removeByKey(K key){
        Node<K,V> currentNode = head;
        while(currentNode!=null){
            if (currentNode.next.key == key){
                currentNode.next = currentNode.next.next;
                return currentNode.next.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }


    public int sizeOfList(){
        int counter = 0;
        Node<K,V> currentNode = head;
        while(currentNode != null){
            counter++;
            currentNode = currentNode.next;
        }
        return counter;
    }

    public boolean containsKeyInList (K key){
        Node<K,V> currentNode = head;
        while(currentNode!=null){
            if (currentNode.key == key) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public boolean containsValueInList (V value){
        Node<K,V> currentNode = head;
        while(currentNode!=null){
            if (currentNode.value == value) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;

    }

  

}
