package model.grafo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Vertice> vertices;
    private List<Aresta> arestas;

    public Grafo() {
        this.vertices = new ArrayList<Vertice>();
        this.arestas = new ArrayList<Aresta>();
    }

    public Grafo(List<Vertice> vertices, List<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void insertVertice(Vertice vertice) {
        vertices.add(vertice);
    }

    public void insertVertice(int id, double latitude, double longitude, String descricao) {
        vertices.add(new Vertice(id, latitude, longitude, descricao));
    }

    public Vertice getVerticeById(int id) {
        for (Vertice v : vertices) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public void insertAresta(Aresta aresta) {
        arestas.add(aresta);
    }

    public void insertAresta(int verticeOrigemId, int verticeDestinoId, double custo) {
        Vertice origem = getVerticeById(verticeOrigemId);
        Vertice destino = getVerticeById(verticeDestinoId);
        arestas.add(new Aresta(origem, destino, custo));
    }
}
