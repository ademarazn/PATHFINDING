package ademarazn.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ademar Zório Neto
 */
public class Graph {

    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
    } // END Graph default constructor

    public Graph(List<Vertex> vertices, List<Edge> edges) {
        this.vertices = vertices;
        this.edges = edges;
    } // END Graph constructor
    
    public List<Vertex> getVertices() {
        return this.vertices;
    } // END getVertices
    
    public boolean containsVertex(Vertex vertex) {
        return this.vertices.contains(vertex);
    } // END containsVertex
    
    public Vertex getVertex(Vertex vertex) {
        return this.vertices.stream().filter(v -> v.equals(vertex)).findFirst().orElse(vertex);
    } // END getVertex
    
    public Vertex getVertexByName(String name) {
        return this.vertices.stream().filter(v -> v.getName().equals(name)).findFirst().orElse(null);
    } // END getVertex

    public void setVertices(List<Vertex> vertices) {
        this.vertices = vertices;
    } // END setVertices
    
    public void addVertex(Vertex vertex) {
        if (!containsVertex(vertex)) {
            this.vertices.add(vertex);
        }
    } // END addVertex
    
    public boolean containsEdge(Edge edge) {
        return this.edges.contains(edge);
    } // END containsEdge
    
    public Edge getEdge(Edge edge) {
        return this.edges.stream().filter(e -> e.equals(edge)).findFirst().orElse(null);
    } // END getEdge

    public List<Edge> getEdges() {
        return this.edges;
    } // END getEdges

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    } // END setEdges
    
    public void addEdge(Edge edge) {
        if (!containsEdge(edge)) {
            this.edges.add(edge);
        }
    } // END addEdge
    
} // END Graph class
