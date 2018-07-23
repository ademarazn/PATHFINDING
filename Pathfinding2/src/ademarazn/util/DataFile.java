package ademarazn.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ademar Zório Neto
 */
public class DataFile {
    
    private static final String SEPARATOR = " ";
    private static final int SOURCE_IDX = 0;
    private static final int TARGET_IDX = 1;
    private static final int DISTANCE_IDX = 2;
    
    private final File file;

    public DataFile(File file) {
        this.file = file;
    } // END DataFile constructor

    private List<String> getLines() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            List<String> lines = new LinkedList<>();
            String line;
            
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            
            return lines;
        } catch (IOException e) {
            throw new IOException("DataFile: getLines: " + e);
        }
    } // END getLines
    
    public Graph getGraph() throws IOException, NumberFormatException {
        List<String> lines = getLines();
        Graph graph = new Graph();
        lines.stream().forEach(line -> {
            Edge edge = getEdge(line);
            Vertex source = graph.getVertex(edge.getSource());
            Vertex target = graph.getVertex(edge.getTarget());
            source.addNeighbor(target);
            target.addNeighbor(source);
            graph.addVertex(source);
            graph.addVertex(target);
            graph.addEdge(edge);
        });
        
        return graph;
    } // END getGraph
    
    private Edge getEdge(String line) throws NumberFormatException {
        try {
            String[] splitedLine = line.split(SEPARATOR);
            Vertex source = new Vertex(splitedLine[SOURCE_IDX]);
            Vertex target = new Vertex(splitedLine[TARGET_IDX]);

            return new Edge(source, target, Double.parseDouble(splitedLine[DISTANCE_IDX]));
        } catch(NumberFormatException e) {
            throw new NumberFormatException("DataFile: getEdge: " + e);
        }
    } // END getEdge
    
} // END DataFile class
