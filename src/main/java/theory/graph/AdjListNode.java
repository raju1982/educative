package theory.graph;

public class AdjListNode {
    private int value;
    private int weight;

    public AdjListNode(int v, int weight){
        this.value = v;
        this.weight = weight;
    }

    public int getWeight(){
        return weight;
    }

    public int getValue(){
        return value;
    }
}