import java.util.List;

/**
 * Created by vinija on 11/23/16.
 */
public class Graph {

    final private List<Vertex> vertexList;
    final private List<Edge> edgeList;

    public Graph(List<Vertex> vertices, List<Edge> edges){
        vertexList=vertices;
        edgeList=edges;
    }

    public List<Vertex> getVertexList(){
        return vertexList;
    }

    public List<Edge> getEdgeList(){
        return edgeList;
    }

}
