import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el número de nodos:");
        int numNodos = scanner.nextInt();

        Grafo grafo = new GrafoImpl(numNodos);

        System.out.println("Ingrese el número de aristas:");
        int numAristas = scanner.nextInt();

        System.out.println("Ingrese las aristas en el formato: origen destino peso");
        for (int i = 0; i < numAristas; i++) {
            int origen = scanner.nextInt();
            int destino = scanner.nextInt();
            int peso = scanner.nextInt();
            grafo.agregarArista(origen, destino, peso);
        }

        System.out.println("Ingrese el nodo inicial:");
        int nodoInicial = scanner.nextInt();

        Dijkstra dijkstra = new DijkstraImpl(grafo);
        dijkstra.encontrarCaminoMasCorto(nodoInicial);

        scanner.close();
    }
}
