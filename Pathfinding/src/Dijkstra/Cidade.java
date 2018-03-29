package Dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Class that is used to instantiate a new "Cidade" object, 
 * i.e. each node in graph.
 * @author Ademar Zório
 */
public class Cidade {
    private String nome;
    private List<Cidade> menorCaminho = new LinkedList<>();
    private Double distancia = Double.MAX_VALUE;
    private Map<Cidade, Double> vizinhos = new HashMap<>();

    public Cidade(String nome) {
        this.nome = nome;
    } // END Cidade constructor

    public void addVizinho(Cidade cidade, Double distancia) {
        vizinhos.put(cidade, distancia);
    } // END addVizinho

    public String getNome() {
        return nome;
    } // END getNome

    public void setNome(String nome) {
        this.nome = nome;
    } // END setNome

    public List<Cidade> getMenorCaminho() {
        return menorCaminho;
    } // END getMenorCaminho

    public void setMenorCaminho(List<Cidade> menorCaminho) {
        this.menorCaminho = menorCaminho;
    } // END setMenorCaminho

    public Double getDistancia() {
        return distancia;
    } // END getDistancia

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    } // END setDistancia

    public Map<Cidade, Double> getVizinhos() {
        return vizinhos;
    } // END getVizinhos

    public void setVizinhos(Map<Cidade, Double> vizinhos) {
        this.vizinhos = vizinhos;
    } // END setVizinhos
} // END class Cidade
