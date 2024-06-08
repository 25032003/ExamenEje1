public class GrafoImpl implements Grafo {
    private int numNodos;
    private int[][] matrizAdyacencia;

    public GrafoImpl(int numNodos) {
        this.numNodos = numNodos;
        matrizAdyacencia = new int[numNodos][numNodos];
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                if (i == j) {
                    matrizAdyacencia[i][j] = 0;
                } else {
                    matrizAdyacencia[i][j] = Integer.MAX_VALUE; // Representa infinito
                }
            }
        }
    }

    @Override
    public void agregarArista(int origen, int destino, int peso) {
        matrizAdyacencia[origen][destino] = peso;
        matrizAdyacencia[destino][origen] = peso; // Para grafo no dirigido
    }

    @Override
    public int getNumNodos() {
        return numNodos;
    }

    @Override
    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }
}
