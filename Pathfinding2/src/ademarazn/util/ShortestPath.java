package ademarazn.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Ademar Zório Neto
 */
public class ShortestPath {
    
    // Shortest path from SOURCE to TARGET:
    //  SOURCE -> ... -> TARGET
    // Distance: 123.4
    private static final String MESSAGE = "Shortest path from %s to %s:\n ";
    private static final String PATH_SEPARATOR = " -> ";
    private static final String DISTANCE_MSG = "\nDistance: ";
    
    private final Map<Vertex, Vertex> shortestPath;
    private final Vertex source;
    private final Vertex target;

    public ShortestPath(Vertex source, Vertex target) {
        this.shortestPath = new HashMap<>();
        this.source = source;
        this.target = target;
    } // END ShortestPath constructor

    /**
     * @param v Key: The "u"'s neighbor vertex.
     * @param u Value: The 
     */
    public void put(Vertex v, Vertex u) {
        this.shortestPath.put(v, u);
    } // END put

    @Override
    public String toString() {
        List<Vertex> path = new LinkedList<>();
        Vertex step = target;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format(MESSAGE, source, target));
        
        while (shortestPath.get(step) != null) {            
            path.add(step);
            step = shortestPath.get(step);
        }
        
        Collections.reverse(path);
        stringBuilder.append(source);
        path.forEach(v -> stringBuilder.append(PATH_SEPARATOR).append(v));
        stringBuilder.append(DISTANCE_MSG).append(target.getDistance());
        
        return stringBuilder.toString();
    } // END toString
    
} // END ShortestPath class
