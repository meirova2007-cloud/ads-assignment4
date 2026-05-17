import java.util.Random;
public class Experiment {
    public void runTraversals(Graph g) {
        long bfsStart = System.nanoTime();
        g.bfs(0);
        long bfsEnd = System.nanoTime();
        long dfsStart = System.nanoTime();
        g.dfs(0);
        long dfsEnd = System.nanoTime();
        long bfsTime = bfsEnd - bfsStart;
        long dfsTime = dfsEnd - dfsStart;
        System.out.println("BFS Time: " + bfsTime + " ns");
        System.out.println("DFS Time: " + dfsTime + " ns");
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
            if (from != to) {
                graph.addEdge(from, to);
            }
        }
        return graph;
    }
    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        for (int size : sizes) {
            System.out.println("\n============================");
            System.out.println("Graph Size: " + size);
            System.out.println("============================");
            Graph graph = createGraph(size);
            if (size == 10) {
                graph.printGraph();
            }
            runTraversals(graph);
        }
    }
    public void printResults() {
        System.out.println("\nPerformance testing completed.");
    }
}