package Dijkstra;

import java.io.File;
import java.util.List;

/**
 * @author Ademar Zório Neto
 * @since Classe criada em 22/07/2018
 */
public class Teste {
    
    private static final String ARQUIVO = "cidades.txt";
    private static final String ORIGEM = "Bauru";
    private static final String DESTINO = "Ourinhos";
    
    public static void main(String[] args) {
        try {
            List<Cidade> cidades = Util.getCidadesFromFile(new File(ARQUIVO), false);
            Dijkstra dijkstra = new Dijkstra(cidades);
            Cidade origem = dijkstra.getCidadePorNome(ORIGEM);
            Cidade destino = dijkstra.getCidadePorNome(DESTINO);
            String menorCaminho = dijkstra.execute(origem, destino);
            System.out.println(menorCaminho);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    } // END main
    
} // END class Teste
