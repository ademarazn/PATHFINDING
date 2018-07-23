package ademarazn;

import ademarazn.algorithm.Dijkstra;
import ademarazn.util.ShortestPath;
import ademarazn.util.Graph;
import ademarazn.util.DataFile;
import java.io.File;
import java.io.IOException;

/**
 * @author Ademar Zório Neto
 */
public class Test {

    private static final String FILE = "cidades.txt";
    private static final String SOURCE = "Ourinhos";
    private static final String TARGET = "Bauru";

    public static void main(String[] args) {
        try {
            Graph graph = new DataFile(new File(FILE)).getGraph();
            Dijkstra dijkstra = new Dijkstra(graph);
            ShortestPath shortestPath = dijkstra.execute(SOURCE, TARGET);
            System.out.println(shortestPath);
        } catch (IOException | IllegalArgumentException e) {
            System.err.println(e);
        }
    } // END main

} // END Test class
