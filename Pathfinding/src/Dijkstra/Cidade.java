package Dijkstra;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Class that is used to instantiate a new "Cidade" object, 
 * i.e. each node in graph.
 * @author Ademar Zório Neto
 */
public class Cidade {
    
    private String nome;
    private Cidade menorCaminho;
    private Double distancia = Double.POSITIVE_INFINITY;
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

    public Cidade getMenorCaminho() {
        return menorCaminho;
    } // END getMenorCaminho

    public void setMenorCaminho(Cidade menorCaminho) {
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

    @Override
    public int hashCode() {
        return 23 * 7 + Objects.hashCode(this.nome);
    } // END hashCode

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        final Cidade other = (Cidade) obj;
        
        return Objects.equals(this.nome, other.nome);
    } // END equals

    @Override
    public String toString() {
        return this.nome;
    } // END toString
    
} // END class Cidade
