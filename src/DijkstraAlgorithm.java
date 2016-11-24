import java.util.*;

/**
 * Created by vinija on 11/23/16.
 */
public class DijkstraAlgorithm {

    final private List<Vertex> nodes;
    final private List<Edge> edges;
     private Set<Vertex> unsettledNodes;
     private Set<Vertex> settledNodes;
    private Map<Vertex,Vertex> predecessor;
     private Map<Vertex,Integer> distance;

    public DijkstraAlgorithm(Graph graph){

        this.nodes = new ArrayList<Vertex>(graph.getVertexList());
        this.edges = new ArrayList<Edge>(graph.getEdgeList());

    }

    public void execute(Vertex source){
        settledNodes = new HashSet<Vertex>();
        unsettledNodes = new HashSet<Vertex>();

        distance = new HashMap<Vertex,Integer>();
        predecessor= new HashMap<Vertex,Vertex>();

        distance.put(source,0);
        unsettledNodes.add(source);

        while ( unsettledNodes.size() > 0) {
            Vertex node = getMinimum( unsettledNodes);
            settledNodes.add(node);
            unsettledNodes.remove(node);
            findMinimalDistances(node);
        }
    }

    private void findMinimalDistances(Vertex node) {
        List<Vertex> adjacentNodes = getNeighbors(node);
        for (Vertex target : adjacentNodes) {
            if (getShortestDistance(target) > getShortestDistance(node)
                    + getDistance(node, target)) {
                distance.put(target, getShortestDistance(node)
                        + getDistance(node, target));
                predecessor.put(target, node);
                unsettledNodes.add(target);
            }
        }

    }

    private int getDistance(Vertex node, Vertex target) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)
                    && edge.getDestination().equals(target)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Should not happen");
    }

    private List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<Vertex>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)
                    && !isSettled(edge.getDestination())) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private Vertex getMinimum(Set<Vertex> vertexes) {
        Vertex minimum = null;
        for (Vertex vertex : vertexes) {
            if (minimum == null) {
                minimum = vertex;
            } else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                    minimum = vertex;
                }
            }
        }
        return minimum;
    }

    private boolean isSettled(Vertex vertex) {
        return settledNodes.contains(vertex);
    }

    private int getShortestDistance(Vertex destination) {
        Integer d = distance.get(destination);
        if (d == null) {
            return Integer.MAX_VALUE;
        } else {
            return d;
        }
    }

    /*
     * This method returns the path from the source to the selected target and
     * NULL if no path exists
     */
    public LinkedList<Vertex> getPath(Vertex target) {
        LinkedList<Vertex> path = new LinkedList<Vertex>();
        Vertex step = target;
        // check if a path exists
        if (predecessor.get(step) == null) {
            return null;
        }
        path.add(step);
        while (predecessor.get(step) != null) {
            step = predecessor.get(step);
            path.add(step);
        }
        // Put it into the correct order
        Collections.reverse(path);
        return path;
    }
    

}
