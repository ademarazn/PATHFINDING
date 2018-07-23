package ademarazn.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class that is used to instantiate a new "Vertex" object, i.e. each node in
 * graph.
 *
 * @author Ademar Zório Neto
 */
public class Vertex {

    private final String name;
    private Double distance;
    private List<Vertex> neighbors;

    public Vertex(String name) {
        this.name = name;
        this.neighbors = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    } // END Vertex constructor

    public String getName() {
        return this.name;
    } // END getName

    public void addNeighbor(Vertex vertex) {
        if (!this.neighbors.contains(vertex)) {
            this.neighbors.add(vertex);
        }
    } // END addNeighbor

    public void addAllNeighbors(List<Vertex> neighbors) {
        neighbors.forEach(neighbor -> addNeighbor(neighbor));
    } // END addALlNeighbors

    public Double getDistance() {
        return this.distance;
    } // END getDistance

    public void setDistance(Double distance) {
        this.distance = distance;
    } // END setDistance

    public List<Vertex> getNeighbors() {
        return this.neighbors;
    } // END getNeighbors

    public void setNeighbors(List<Vertex> neighbors) {
        this.neighbors = neighbors;
    } // END setNeighbors

    @Override
    public int hashCode() {
        return 79 * 5 + Objects.hashCode(this.name);
    } // END hashCode

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        final Vertex other = (Vertex) obj;

        return Objects.equals(this.name, other.name);
    } // END equals

    @Override
    public String toString() {
        return this.name;
    } // END toString

} // END class Vertex
