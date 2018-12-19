package controller;

import model.dijkstra.Dijkstra;
import model.grafo.Grafo;
import model.grafo.Vertice;
import persistence.LeitorXML;

import java.util.LinkedList;
import java.util.Scanner;

public class AppDijkstra {

    public static void main(String[] args) {

        LeitorXML leitor = new LeitorXML();
        leitor.fazerParsing();

        Grafo grafo = leitor.grafo;

        System.out.println("Qtd Vertices: " + grafo.getVertices().size());
        System.out.println("Qtd Arestas: " + grafo.getArestas().size());

        Scanner scanner = new Scanner(System.in);

        System.out.println("ID do Vertice de origem: ");
        int origem = scanner.nextInt();
        System.out.println("ID do Vertice de destino: ");
        int destino = scanner.nextInt();

        scanner.close();

        Dijkstra dijkstra = new Dijkstra(grafo);
        LinkedList<Vertice> caminho = dijkstra.executar(
                grafo.getVerticeById(origem),
                grafo.getVerticeById(destino)
        );

        System.out.println("");
        if (caminho == null) {
            System.out.println("Rota inexistente!");
        } else {
            int passo = 0;
            for (Vertice v : caminho) {
                passo++;
                System.out.println("Passo " + passo + " -> "
                        + "[ "
                        + "ID: " + v.getId()
                        + "    |    Descricao: " + v.getDescricao()
                        + " ]"
                );
            }
        }

    }
}
