public class DijkstraImpl implements Dijkstra {
    private Grafo grafo;

    public DijkstraImpl(Grafo grafo) {
        this.grafo = grafo;
    }

    @Override
    public void encontrarCaminoMasCorto(int nodoInicial) {
        int numNodos = grafo.getNumNodos();
        int[][] matrizAdyacencia = grafo.getMatrizAdyacencia();
        int[] distancias = new int[numNodos];
        boolean[] visitados = new boolean[numNodos];

        for (int i = 0; i < numNodos; i++) {
            distancias[i] = Integer.MAX_VALUE;
            visitados[i] = false;
        }

        distancias[nodoInicial] = 0;

        for (int i = 0; i < numNodos - 1; i++) {
            int nodoMinimo = obtenerDistanciaMinima(distancias, visitados);
            visitados[nodoMinimo] = true;

            for (int j = 0; j < numNodos; j++) {
                if (!visitados[j] && matrizAdyacencia[nodoMinimo][j] != Integer.MAX_VALUE &&
                        distancias[nodoMinimo] != Integer.MAX_VALUE &&
                        distancias[nodoMinimo] + matrizAdyacencia[nodoMinimo][j] < distancias[j]) {
                    distancias[j] = distancias[nodoMinimo] + matrizAdyacencia[nodoMinimo][j];
                }
            }
        }

        mostrarResultados(distancias);
    }

    private int obtenerDistanciaMinima(int[] distancias, boolean[] visitados) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distancias.length; i++) {
            if (!visitados[i] && distancias[i] <= min) {
                min = distancias[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void mostrarResultados(int[] distancias) {
        System.out.println("Nodo\tDistancia desde el nodo inicial");
        for (int i = 0; i < distancias.length; i++) {
            System.out.println(i + "\t\t" + (distancias[i] == Integer.MAX_VALUE ? "Infinito" : distancias[i]));
        }
    }
}
