public class Experiment {

    public void runTraversals(Graph g) {
        System.out.println("BFS traversal:");
        g.bfs(0);

        System.out.println("DFS traversal:");
        g.dfs(0);
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};

        System.out.println("Performance Results");
        System.out.println("-------------------");
        System.out.println("Vertices | BFS Time(ns) | DFS Time(ns)");

        for (int size : sizes) {
            Graph graph = createGraph(size);

            long bfsStart = System.nanoTime();
            graph.bfsOrder(0);
            long bfsEnd = System.nanoTime();

            long dfsStart = System.nanoTime();
            graph.dfsOrder(0);
            long dfsEnd = System.nanoTime();

            long bfsTime = bfsEnd - bfsStart;
            long dfsTime = dfsEnd - dfsStart;

            System.out.println(size + "        | " + bfsTime + "       | " + dfsTime);
        }
    }

    public void printResults() {
        System.out.println("BFS and DFS were tested on graphs with 10, 30, and 100 vertices.");
        System.out.println("Both algorithms have time complexity O(V + E).");
        System.out.println("As graph size increases, execution time usually increases because more vertices and edges are visited.");
    }

    private Graph createGraph(int size) {
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
}