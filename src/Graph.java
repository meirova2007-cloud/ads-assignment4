import java.util.*;
class Neighbor {
    int vertex;
    int weight;
    public Neighbor(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Neighbor>> adjacencyList;
    public Graph() {
        vertices = new HashMap<>();
        adjacencyList = new HashMap<>();
    }
    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjacencyList.putIfAbsent(
                v.getId(),
                new ArrayList<>()
        );
    }
    public void addEdge(int from, int to, int weight) {
        if (!vertices.containsKey(from)
                || !vertices.containsKey(to)) {
            System.out.println(
                    "One of the vertices does not exist."
            );
            return;
        }
        adjacencyList.get(from)
                .add(new Neighbor(to, weight));
        adjacencyList.get(to)
                .add(new Neighbor(from, weight));
    }
    public void printGraph() {
        System.out.println("\nAdjacency List:");
        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");
            for (Neighbor neighbor
                    : adjacencyList.get(vertex)) {
                System.out.print(
                        "(" +
                                neighbor.vertex +
                                ", weight=" +
                                neighbor.weight +
                                ") "
                );
            }
            System.out.println();
        }
    }
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.offer(start);
        System.out.print("\nBFS Traversal: ");
        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");
            for (Neighbor neighbor
                    : adjacencyList.get(current)) {
                int nextVertex = neighbor.vertex;
                if (!visited.contains(nextVertex)) {
                    visited.add(nextVertex);
                    queue.offer(nextVertex);
                }
            }
        }
        System.out.println();
    }
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("\nDFS Traversal: ");
        dfsHelper(start, visited);
        System.out.println();
    }
    private void dfsHelper(
            int current,
            Set<Integer> visited
    ) {
        visited.add(current);
        System.out.print(current + " ");
        for (Neighbor neighbor
                : adjacencyList.get(current)) {
            int nextVertex = neighbor.vertex;
            if (!visited.contains(nextVertex)) {
                dfsHelper(nextVertex, visited);
            }
        }
    }
    public void dijkstra(int start) {
        int size = vertices.size();
        int[] distance = new int[size];
        boolean[] visited = new boolean[size];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        for (int i = 0; i < size - 1; i++) {
            int current =
                    getMinDistanceVertex(
                            distance,
                            visited
                    );
            if (current == -1) {
                break;
            }
            visited[current] = true;
            for (Neighbor neighbor
                    : adjacencyList.get(current)) {
                int nextVertex = neighbor.vertex;
                int weight = neighbor.weight;
                if (!visited[nextVertex]
                        && distance[current]
                        != Integer.MAX_VALUE
                        && distance[current] + weight
                        < distance[nextVertex]) {
                    distance[nextVertex] =
                            distance[current]
                                    + weight;
                }
            }
        }
        System.out.println(
                "\nDijkstra Shortest Paths from Vertex "
                        + start
        );
        for (int i = 0; i < size; i++) {
            System.out.println(
                    "To vertex "
                            + i
                            + " = "
                            + distance[i]
            );
        }
    }
    private int getMinDistanceVertex(
            int[] distance,
            boolean[] visited
    ) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < distance.length; i++) {
            if (!visited[i]
                    && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    public int getVertexCount() {
        return vertices.size();
    }
}