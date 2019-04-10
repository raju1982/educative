package hashTable;

public class HashTableImpl {
    private final int size = 15;
    private Node[] data = new Node[size];

    public void put(String key, String value) {
        int hash = getHash(key);
        Node node = new Node(key, value);
        if (data[hash] == null) {
            data[hash] = node;
        } else {
            Node tmp = data[hash];
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    public String get(String key){
        int hash = getHash(key);
        Node tmp = data[hash];
        if(tmp == null){
            return null;
        }
        else{
            while(tmp != null){
                if(tmp.key == key){
                    return tmp.value;
                }
                tmp = tmp.next;
            }
            return null;
        }
    }


    public int getHash(String key) {
        //index will always stay between 0 and tableSize - 1.
        return key.hashCode() % size;
    }

    class Node {
        String key;
        String value;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        HashTableImpl hashTable = new HashTableImpl();

        hashTable.put("20", "200");
        hashTable.put("30", "300");
        hashTable.put("40", "400");

        System.out.println( hashTable.get("40"));
        System.out.println( hashTable.get("50"));

    }

}


