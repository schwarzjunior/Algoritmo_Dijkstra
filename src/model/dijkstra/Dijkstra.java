package model.dijkstra;

import model.grafo.Aresta;
import model.grafo.Grafo;
import model.grafo.Vertice;

import java.util.*;

public class Dijkstra {
    private List<Aresta> arestas;
    private Set<Vertice> visitados;
    private Set<Vertice> naoVisitados;
    private Map<Vertice, Vertice> anteriores;
    private Map<Vertice, Double> distancias;

    public Dijkstra(Grafo grafo) {
        this.arestas = new ArrayList<Aresta>(grafo.getArestas());
        this.visitados = new HashSet<Vertice>();
        this.naoVisitados = new HashSet<Vertice>();
        this.anteriores = new HashMap<Vertice, Vertice>();
        this.distancias = new HashMap<Vertice, Double>();
    }

    public Dijkstra(List<Aresta> arestas, Set<Vertice> visitados, Set<Vertice> naoVisitados, Map<Vertice, Vertice> anteriores, Map<Vertice, Double> distancias) {
        this.arestas = arestas;
        this.visitados = visitados;
        this.naoVisitados = naoVisitados;
        this.anteriores = anteriores;
        this.distancias = distancias;
    }

    public LinkedList<Vertice> executar(Vertice origem, Vertice destino) {
        naoVisitados.add(origem);
        distancias.put(origem, 0d);

        while (naoVisitados.size() > 0) {
            Vertice vertice = getMinimo(naoVisitados);
            visitados.add(vertice);
            naoVisitados.remove(vertice);
            procurarDistanciasMinimas(vertice);
        }

        if (anteriores.get(destino) == null) {
            return null;
        }

        LinkedList<Vertice> caminho = new LinkedList<Vertice>();
        Vertice passo = destino;

        caminho.add(passo);

        while (anteriores.get(passo) != null) {
            passo = anteriores.get(passo);
            caminho.add(passo);
        }

        Collections.reverse(caminho);
        return caminho;
    }

    private Vertice getMinimo(Set<Vertice> vertices) {
        Vertice minimo = null;
        for (Vertice vertice : vertices) {
            if (minimo == null || (getMenorDistancia(vertice) < getMenorDistancia(minimo))) {
                minimo = vertice;
            }
        }
        return minimo;
    }

    private double getMenorDistancia(Vertice destino) {
        Double distancia = distancias.get(destino);
        return (distancia == null ? Double.MAX_VALUE : distancia);
    }

    private void procurarDistanciasMinimas(Vertice vertice) {
        List<Vertice> verticesAdjaventes = getVizinhos(vertice);
        for (Vertice destino : verticesAdjaventes) {
            if (getMenorDistancia(destino) > (getMenorDistancia(vertice) + getDistancia(vertice, destino))) {
                distancias.put(destino, getMenorDistancia(vertice) + getDistancia(vertice, destino));
                anteriores.put(destino, vertice);
                naoVisitados.add(destino);
            }
        }
    }

    private double getDistancia(Vertice vertice, Vertice destino) {
        for (Aresta aresta : arestas) {
            if (aresta.getOrigem().equals(vertice) && aresta.getDestino().equals(destino)) {
                Double custo = (aresta.getCusto() == 0d ? 1 : aresta.getCusto() * 1000d);
                return aresta.getDistancia() * custo;
            }
        }
        throw new RuntimeException("Erro misterioso");
    }

    private List<Vertice> getVizinhos(Vertice vertice) {
        List<Vertice> vizinhos = new ArrayList<Vertice>();
        for (Aresta aresta : arestas) {
            if (aresta.getOrigem().equals(vertice) && !isVisitado(aresta.getDestino())) {
                vizinhos.add(aresta.getDestino());
            }
        }
        return vizinhos;
    }

    private boolean isVisitado(Vertice vertice) {
        return visitados.contains(vertice);
    }
}
