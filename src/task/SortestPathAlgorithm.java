package task;

import java.util.Arrays;

public class SortestPathAlgorithm {

  private static void addGraph(int[][] graph, int src, int dest) {
    graph[src][dest] = 1;
    graph[dest][src] = 1;
  }

  public static void main(String[] args) {
    int v = 5;// total no of languages;

    int[][] graph = new int[v][v];
    /**
     * Assume language mapping as 0:Telugu, 1:Hindi, 2:English, 3:Urdu, 4:Bangali; here we have
     * taken 5 translators;
     */
    addGraph(graph, 0, 1); // Telugu-Hindi
    addGraph(graph, 0, 4); // Telugu-Bangali
    addGraph(graph, 1, 2); // Hindi-English
    addGraph(graph, 2, 3); // English-Urdu
    addGraph(graph, 3, 4); // Urdu-Bangali
    int source=0;
    int destination=3;

    int noOfTranslator=findSortestPath(graph, source, destination);
    System.out.println("No of translator required to convert from "+source+" to "+destination+ " is -> "+noOfTranslator);
  }

  //Dijsktra Algorithm
  private static int findSortestPath(int[][] graph, int src, int dest) {
    int V=graph.length;
    int[] dist = new int[V];
    boolean[] sptSet = new boolean[V];
    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(sptSet, false);
    dist[src] = 0;
    for (int count = 0; count < V - 1; count++) {
      int u = minDistance(dist, sptSet);
      sptSet[u] = true;
      for (int v = 0; v < V; v++) {
        if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
            && dist[u] + graph[u][v] < dist[v]) {
          dist[v] = dist[u] + graph[u][v];
        }
      }
    }
    return dist[dest];
  }

  private static int minDistance(int[] dist, boolean[] sptSet) {
    int V=dist.length;
    int min = Integer.MAX_VALUE;
    int index = -1;
    for (int i = 0; i < V; i++) {
      if (!sptSet[i] && dist[i] <= min) {
        min = dist[i];
        index = i;
      }
    }
    return index;
  }

}
