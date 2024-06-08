public interface Grafo {
    void agregarArista(int origen, int destino, int peso);
    int getNumNodos();
    int[][] getMatrizAdyacencia();
}
