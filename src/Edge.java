/**
 * Created by vinija on 11/23/16.
 */
public class Edge {
    final private String id;
    final private Vertex source;
    final private Vertex destination;
    final private int weight;

    public Edge(String id, Vertex source, Vertex destination, int weight){
        this.id=id;
        this.source=source;
        this.destination=destination;
        this.weight = weight;
    }

    public String getId(){
        return id;
    }

    public Vertex getSource(){
        return source;
    }

    public Vertex getDestination(){
        return destination;
    }

    public int getWeight(){
        return weight;
    }

    public String toString(){
        return source+ " " +destination;
    }

}
