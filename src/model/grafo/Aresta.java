package model.grafo;

public class Aresta {
    private static final double RAIO = 6372.795477598;
    private static final double PI = 3.1415;
    private Vertice origem;
    private Vertice destino;
    private double custo;
    private double distancia;

    public Aresta(Vertice origem, Vertice destino, double custo) {
        this.origem = origem;
        this.destino = destino;
        this.custo = custo;
        this.distancia = calcularDistancia(
                origem.getLatitude(), origem.getLongitude(),
                destino.getLatitude(), destino.getLongitude()
        );
    }

    public Vertice getOrigem() {
        return origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public double getCusto() {
        return custo;
    }

    public double getDistancia() {
        return distancia;
    }

    /**
     * Calcula e retorna a distancia (em metros) entre dois pontos geograficos.
     *
     * @param latitudeA  Latitude do ponto A.
     * @param longitudeA Longitude do ponto A.
     * @param latitudeB  Latitude do ponto B.
     * @param longitudeB Longitude do ponto B.
     * @return A distancia (em metros) entre os dois pontos geograficos.
     */
    private static double calcularDistancia(double latitudeA, double longitudeA, double latitudeB, double longitudeB) {
        double latA = latitudeA * PI / 180.0;
        double lonA = longitudeA * PI / 180.0;
        double latB = latitudeB * PI / 180.0;
        double lonB = longitudeB * PI / 180.0;

        double dLat = latB - latA;
        double dLon = lonB - lonA;

        double d = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                * Math.cos(latA) * Math.cos(latB)
                * Math.sin(dLon) / 2 * Math.sin(dLon) / 2;
        double e = 2 * Math.atan2(Math.sqrt(d), Math.sqrt(1 - d));

        return Math.round(RAIO * e * 1000 * 1000 * 1000);
    }
}
