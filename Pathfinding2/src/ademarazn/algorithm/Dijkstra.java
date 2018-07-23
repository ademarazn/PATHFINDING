package ademarazn.algorithm;

import ademarazn.util.ShortestPath;
import ademarazn.util.Vertex;
import ademarazn.util.Graph;
import ademarazn.util.Edge;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to perform the calculations of Dijkstra.
 * 
 * @author Ademar Zório Neto
 */
public class Dijkstra {
    
    private final Graph graph;

    public Dijkstra(Graph graph) {
        this.graph = graph;
    } // END Dijkstra constructor
    
    public ShortestPath execute(String source, String target) throws IllegalArgumentException {
        return execute(graph.getVertexByName(source), graph.getVertexByName(target));
    } // END execute(String, String)
    
    public ShortestPath execute(Vertex source, Vertex target) throws IllegalArgumentException {
        if (source == null) {
            throw new IllegalArgumentException("Source vertex not founded");
        }
        
        if (target == null) {
            throw new IllegalArgumentException("Target vertex not founded");
        }
        
        ShortestPath shortestPath = new ShortestPath(source, target);
        
        // dist[s]←0 (distance to source vertex is zero)
        source.setDistance(0D);

        // S←∅ (S, the set of visited vertices is initially empty)
        List<Vertex> s = new ArrayList<>();

        // Q←V (Q, the queue initially contains all vertices)
        List<Vertex> q = graph.getVertices();

        // while Q≠∅ (while the queue is not empty)
        while (!q.isEmpty()) {
            // do u←mindistance(Q,dist) (select the element of Q with the min. distance)
            Vertex u = minDistance(q);

            // S←S∪{u} (add u to list of visited vertices)
            s.add(u);
            q.remove(u);

            // for all v ∈ neighbors[u]
            for (Vertex v : u.getNeighbors()) {
                // do if dist[v] > dist[u] + w(u, v) (if new shortest path found)
                if (v.getDistance() > u.getDistance()+ weight(u, v)) {
                    // then d[v]←d[u] + w(u, v)	(set new value of shortest path)
                    v.setDistance(u.getDistance()+ weight(u, v));
                    shortestPath.put(v, u);
                }
            }
        }
        
        return shortestPath;
    } // END execute(Vertex, Vertex)

    public Vertex minDistance(List<Vertex> vertices) {
        return vertices.stream().min((v1, v2) -> v1.getDistance().compareTo(v2.getDistance())).get();
    } // END minDistance

    public Double weight(Vertex u, Vertex v) {
        Edge edge = graph.getEdge(new Edge(u, v));
        
        if (edge == null) {
            edge = graph.getEdge(new Edge(v, u));
        }
        
        return edge != null ? edge.getDistance() : 0D;
    } // END weight
    
} // END class Dijkstra
