public class Main {
    public static void main(String[] args) {
        Graph smallGraph = createGraph(10);
        Graph mediumGraph = createGraph(30);
        Graph largeGraph = createGraph(100);

        System.out.println("Small Graph Structure:");
        smallGraph.printGraph();

        System.out.println("\nSmall Graph Traversals:");
        System.out.println("BFS traversal:");
        smallGraph.bfs(0);

        System.out.println("DFS traversal:");
        smallGraph.dfs(0);

        System.out.println("\nPerformance Results");
        System.out.println("-------------------");
        System.out.println("Graph Size | Vertices | BFS Time(ns) | DFS Time(ns)");

        measurePerformance("Small", smallGraph, 10);
        measurePerformance("Medium", mediumGraph, 30);
        measurePerformance("Large", largeGraph, 100);

        System.out.println("\nAnalysis:");
        System.out.println("BFS and DFS were tested on graphs with 10, 30, and 100 vertices.");
        System.out.println("Both algorithms have time complexity O(V + E).");
        System.out.println("As the graph size increases, execution time usually increases.");
    }

    private static Graph createGraph(int size) {
        Graph graph = new Graph();

        for (int i = 0; i < size; i++) {
            graph.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {
            graph.addEdge(i, i + 1);
        }

        for (int i = 0; i < size - 2; i += 2) {
            graph.addEdge(i, i + 2);
        }

        return graph;
    }

    private static void measurePerformance(String name, Graph graph, int vertices) {
        long bfsStart = System.nanoTime();
        graph.bfsOrder(0);
        long bfsEnd = System.nanoTime();

        long dfsStart = System.nanoTime();
        graph.dfsOrder(0);
        long dfsEnd = System.nanoTime();

        long bfsTime = bfsEnd - bfsStart;
        long dfsTime = dfsEnd - dfsStart;

        System.out.println(name + "      | " + vertices + "       | " + bfsTime + "       | " + dfsTime);
    }
}