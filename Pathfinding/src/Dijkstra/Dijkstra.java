package Dijkstra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to perform the calculations of Dijkstra.
 * @author Ademar Zório
 */
public class Dijkstra {
    private static final String ORIGEM = "Bauru";
    private static final String DESTINO = "Ourinhos";

    private Double menorCaminho;
    String caminho;

    public void execute(List<Cidade> cidades, Cidade origem, Cidade destino) {
        // dist[s]←0 (distance to source vertex is zero)
        cidades.get(cidades.indexOf(origem)).setDistancia(0.0);

        // S←∅ (S, the set of visited vertices is initially empty)
        List<Cidade> s = new ArrayList<>();

        // Q←V (Q, the queue initially contains all vertices)
        List<Cidade> q = cidades;
        caminho = "\n";

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
                }
            }

            if (!u.getNome().equals(origem.getNome())) {
                caminho = caminho + " - " + u.getNome();
            } else {
                caminho = caminho + u.getNome();
            }
            
            if (u.getNome().equals(destino.getNome())) {
                break;
            }

        }

        menorCaminho = destino.getDistancia();

        if (origem.getVizinhos().get(destino) != null) {
            System.out.println("\n\nMenor caminho encontrado: " + menorCaminho + "\n" + origem.getNome() + " - " + destino.getNome());
        } else {
            System.out.println("\n\nMenor caminho encontrado: " + menorCaminho + caminho);
        }
    } // END dijkstra

    public Cidade minDistance(List<Cidade> q) {
        int mindistIndex;
        
        if (!q.isEmpty()) {
            mindistIndex = 0;
        } else {
            return null;
        }
        
        for (int i = 1; i < q.size(); i++) {
            if (q.get(i).getDistancia() < q.get(mindistIndex).getDistancia()) {
                mindistIndex = i;
            }
        }
        
        return q.get(mindistIndex);
    } // END minDistance

    public Double w(Cidade u, Cidade v) {
        return u.getVizinhos().get(v);
    } // END w

    public Cidade getCidadeNome(List<Cidade> cidades, String nome) {
        for (Cidade cidade : cidades) {
            if (cidade.getNome().equalsIgnoreCase(nome)) {
                return cidade;
            }
        }
        
        return null;
    } // END getCidadeNome

    public Double getMenorCaminho() {
        return menorCaminho;
    } // END getMenorCaminho
    
    public static void main(String[] args) {
        List<Cidade> cidades = new LinkedList<>();
        Dijkstra dijkstra = new Dijkstra();
        
        try {
            BufferedReader arquivo = new BufferedReader(
                    new FileReader(new File("cidades.txt"))
            );
            List<String> linhas = new LinkedList<>();
            
            do {
                linhas.add(arquivo.readLine());
            } while (linhas.get(linhas.size() - 1) != null);
            
            linhas.remove(linhas.size() - 1);
            linhas.forEach((linha) -> {
                String[] palavras = linha.split(" ");
                
                for (String palavra : palavras) {
                    try {
                        Double distancia = Double.parseDouble(palavra);
                        Cidade a = dijkstra.getCidadeNome(cidades, palavras[0]);
                        Cidade b = dijkstra.getCidadeNome(cidades, palavras[1]);
                        a.addVizinho(b, distancia);
                        b.addVizinho(a, distancia);
                    } catch (NumberFormatException e) {
                        // Erro de conversão, então não é número
                        Cidade cidade = new Cidade(palavra);
                        boolean contem = false;
                        
                        for (Cidade c : cidades) {
                            if (c.getNome().equalsIgnoreCase(palavra)) {
                                contem = true;
                            }
                        }
                        
                        if (!contem) {
                            cidades.add(cidade);
                        }
                    }
                }
            });

            Cidade origem = dijkstra.getCidadeNome(cidades, ORIGEM);
            Cidade destino = dijkstra.getCidadeNome(cidades, DESTINO);
            
            for (Cidade cid : cidades) {
                System.out.println("\n" + cid.getNome());
                
                for (Cidade vizinho : cid.getVizinhos().keySet()) {
                    System.out.println(vizinho.getNome() + " - " + cid.getVizinhos().get(vizinho));
                }
            }
            
            System.out.println("Qtd de cidades: " + cidades.size());
            dijkstra.execute(cidades, origem, destino);
        } catch (FileNotFoundException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    } // END main
} // END class Dijkstra
