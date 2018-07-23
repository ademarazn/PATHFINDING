package Dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to perform the calculations of Dijkstra.
 * @author Ademar Zório Neto
 */
public class Dijkstra {

    private final List<Cidade> cidades;

    public Dijkstra(List<Cidade> cidades) {
        this.cidades = cidades;
    } // END Dijkstra constructor

    public String execute(Cidade origem, Cidade destino)throws IllegalArgumentException {
        if (origem == null) {
            throw new IllegalArgumentException("Origem não encontrada");
        }
        
        if (destino == null) {
            throw new IllegalArgumentException("Destino não encontrado");
        }
        
        // dist[s]←0 (distance to source vertex is zero)
        origem.setDistancia(0D);

        // S←∅ (S, the set of visited vertices is initially empty)
        List<Cidade> s = new ArrayList<>();

        // Q←V (Q, the queue initially contains all vertices)
        List<Cidade> q = cidades;

        // while Q≠∅ (while the queue is not empty)
        while (!q.isEmpty()) {
            // do u←mindistance(Q,dist) (select the element of Q with the min. distance)
            Cidade u = minDistance(q);

            // S←S∪{u} (add u to list of visited vertices)
            s.add(u);
            q.remove(u);

            // for all v ∈ neighbors[u]
            for (Cidade v : u.getVizinhos().keySet()) {
                // do if dist[v] > dist[u] + w(u, v) (if new shortest path found)
                if (v.getDistancia() > u.getDistancia() + w(u, v)) {
                    // then d[v]←d[u] + w(u, v)	(set new value of shortest path)
                    v.setDistancia(u.getDistancia() + w(u, v));
                    v.setMenorCaminho(u);
                }
            }
        }

        Double distMenorCaminho = destino.getDistancia();
        String rotaMenorCaminho = getMenorCaminho(destino);
        
        return String.format("Menor caminho encontrado de %s até %s: %s\n%s", 
                origem, destino, distMenorCaminho, rotaMenorCaminho);
    } // END execute
    
    private String getMenorCaminho(Cidade destino) {
        StringBuilder caminho = new StringBuilder(destino.toString());
        Cidade passo = destino;
        
        while ((passo = passo.getMenorCaminho()) != null) {
            caminho.insert(0, " - ").insert(0, passo);
        }
        
        return caminho.toString();
    } // END getMenorCaminho

    public Cidade minDistance(List<Cidade> cidades) {
        return cidades.stream().min((v1, v2) -> v1.getDistancia().compareTo(v2.getDistancia())).get();
    } // END minDistance

    public Double w(Cidade u, Cidade v) {
        return u.getVizinhos().get(v);
    } // END w

    public Cidade getCidadePorNome(String nome) {
        for (Cidade cidade : cidades) {
            if (cidade.getNome().equalsIgnoreCase(nome)) {
                return cidade;
            }
        }
        
        return null;
    } // END getCidadePorNome
    
} // END class Dijkstra
