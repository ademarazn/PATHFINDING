package ademarazn.util;

import java.util.Objects;

/**
 * @author Ademar Zório Neto
 */
public class Edge {

    private Vertex source;
    private Vertex target;
    private Double distance;

    public Edge(Vertex source, Vertex target) {
        this.source = source;
        this.target = target;
    } // END Egde(Vertex, Vertex) constructor
    
    public Edge(Vertex source, Vertex target, Double distance) {
        this.source = source;
        this.target = target;
        this.distance = distance;
    } // END Egde(Vertex, Vertex, Double) constructor

    public Vertex getSource() {
        return this.source;
    } // END getSource

    public void setSource(Vertex source) {
        this.source = source;
    } // END setSource

    public Vertex getTarget() {
        return this.target;
    } // END getTarget

    public void setTarget(Vertex target) {
        this.target = target;
    } // END setTarget

    public Double getDistance() {
        return this.distance;
    } // END getDistance

    public void setDistance(Double distance) {
        this.distance = distance;
    } // END setDistance

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.source);
        hash = 79 * hash + Objects.hashCode(this.target);
        
        return hash;
    } // END hashCode

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        final Edge other = (Edge) obj;
        
        if (!Objects.equals(this.source, other.source)) {
            return false;
        }
        
        return Objects.equals(this.target, other.target);
    } // END equals

} // END Edge class
