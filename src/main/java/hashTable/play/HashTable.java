package hashTable.play;

public class HashTable {

    Node[] data;
    Integer size;

    HashTable(Integer size){
        data = new Node[size];
        this.size = size;
    }

    void put(Integer key, Integer value){
        //use modulus
        int hash = key%size;

        if(data[hash] == null){
            data[hash] = new Node(key, value);
        }
        else{
            Node node = data[hash];

            while(node.nextNode!=null){
                node = node.nextNode;
            }

            node.setNextNode(new Node(key, value));
        }
    }


    Integer get(Integer key){
        int hash = key%size;
        if(data[hash] == null){
            return null;
        }
        else{
            Node node = data[hash];
            while(node != null){
                if(node.getKey() == key){
                    return node.getValue();
                }
                node = node.getNextNode();
            }

        }
        return null;
    }

    public static void main(String[] atr){
        HashTable hashTable = new HashTable(10);

        hashTable.put(20, 200);
        hashTable.put(30, 300);
        hashTable.put(40, 400);

        System.out.println( hashTable.get(40));
        System.out.println( hashTable.get(50));
    }

}


class Node{
    Integer key;
    Integer value;
    Node nextNode;

    Node(Integer key, Integer value){
        this.key = key;
        this.value = value;
    }

    Integer getKey(){
        return key;
    }

    Integer getValue(){
        return value;
    }

    void setNextNode(Node nextNode){
        this.nextNode = nextNode;
    }

    Node getNextNode(){
        return nextNode;
    }

}