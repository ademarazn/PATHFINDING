package Dijkstra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ademar Zório Neto
 * @since Classe criada em 22/07/2018
 */
public class Util {

    public static List<Cidade> getCidadesFromFile(File file, boolean showCidades) throws Exception {
        try {
            List<Cidade> cidades = new LinkedList<>();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            List<String> linhas = new LinkedList<>();
            String linhaTexto;
            
            while ((linhaTexto = bufferedReader.readLine()) != null) {
                linhas.add(linhaTexto);
            }
            
            linhas.forEach(linha -> {
                String[] palavras = linha.split(" ");
                Cidade a = new Cidade(palavras[0]);
                Cidade b = new Cidade(palavras[1]);
                Double distancia = Double.parseDouble(palavras[2]);
                
                if (cidades.contains(a)) {
                    a = cidades.get(cidades.indexOf(a));
                }
                
                if (cidades.contains(b)) {
                    b = cidades.get(cidades.indexOf(b));
                }
                
                a.addVizinho(b, distancia);
                b.addVizinho(a, distancia);
                
                if (!cidades.contains(a)) {
                    cidades.add(a);
                }
                
                if (!cidades.contains(b)) {
                    cidades.add(b);
                }
            });
            
            if (showCidades) {
                System.out.println("Qtd de cidades: " + cidades.size());
                cidades.stream().map((c) -> {
                    System.out.println("\n" + c.getNome());
                    
                    return c;
                }).forEachOrdered((cid) -> {
                    cid.getVizinhos().keySet().forEach(vizinho -> {
                        System.out.println(vizinho.getNome() + " - " + cid.getVizinhos().get(vizinho));
                    });
                });
                System.out.println("\n");
            }
            
            return cidades;
        } catch (IOException | NumberFormatException e) {
            throw new Exception("Util: getCidadesFromFile: " + e);
        }
    } // END getCidadesFromFile
    
} // END class Util
