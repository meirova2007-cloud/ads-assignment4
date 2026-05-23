import java.util.Random;
public class Experiment {
    public void runTraversals(Graph g) {
        long bfsStart = System.nanoTime();
        g.bfs(0);
        long bfsEnd = System.nanoTime();
        long dfsStart = System.nanoTime();
        g.dfs(0);
        long dfsEnd = System.nanoTime();
        long dijkstraStart = System.nanoTime();
        g.dijkstra(0);
        long dijkstraEnd = System.nanoTime();
        long bfsTime = bfsEnd - bfsStart;
        long dfsTime = dfsEnd - dfsStart;
        long dijkstraTime =
                dijkstraEnd - dijkstraStart;
        System.out.println(
                "\nBFS Time: "
                        + bfsTime
                        + " ns"
        );
        System.out.println(
                "DFS Time: "
                        + dfsTime
                        + " ns"
        );
        System.out.println(
                "Dijkstra Time: "
                        + dijkstraTime
                        + " ns"
        );
    }
    public Graph createGraph(int size) {
        Graph graph = new Graph();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            graph.addVertex(new Vertex(i));
        }
        for (int i = 0; i < size * 2; i++) {
            int from = random.nextInt(size);
            int to = random.nextInt(size);
            int weight =
                    random.nextInt(10) + 1;
            if (from != to) {
                graph.addEdge(
                        from,
                        to,
                        weight
                );
            }
        }
        return graph;
    }
    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        for (int size : sizes) {
            System.out.println(
                    "\n=========================="
            );
            System.out.println(
                    "Graph Size: " + size
            );
            System.out.println(
                    "=========================="
            );
            Graph graph =
                    createGraph(size);
            if (size == 10) {
                graph.printGraph();
            }
            runTraversals(graph);
        }
    }
    public void printResults() {
        System.out.println(
                "\nPerformance testing completed."
        );
    }
}