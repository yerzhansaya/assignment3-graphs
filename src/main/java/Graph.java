import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Integer>> adjacencyList;
    private List<Edge> edges;

    public Graph() {
        vertices = new LinkedHashMap<>();
        adjacencyList = new LinkedHashMap<>();
        edges = new ArrayList<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (!vertices.containsKey(from) || !vertices.containsKey(to)) {
            System.out.println("Invalid edge: " + from + " -> " + to);
            return;
        }

        adjacencyList.get(from).add(to);

        Vertex source = vertices.get(from);
        Vertex destination = vertices.get(to);
        edges.add(new Edge(source, destination));

        // For an undirected graph, you could also add:
        // adjacencyList.get(to).add(from);
    }

    public void printGraph() {
        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");

            for (int neighbor : adjacencyList.get(vertex)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }

    public void bfs(int start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Start vertex does not exist.");
            return;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        // BFS starts from the selected vertex and explores neighbors level by level.
        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Start vertex does not exist.");
            return;
        }

        Set<Integer> visited = new HashSet<>();

        // DFS starts from the selected vertex and explores as deeply as possible.
        dfsHelper(start, visited);

        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (int neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited);
            }
        }
    }

    public List<Integer> bfsOrder(int start) {
        List<Integer> order = new ArrayList<>();

        if (!adjacencyList.containsKey(start)) {
            return order;
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            order.add(current);

            for (int neighbor : adjacencyList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        return order;
    }

    public List<Integer> dfsOrder(int start) {
        List<Integer> order = new ArrayList<>();

        if (!adjacencyList.containsKey(start)) {
            return order;
        }

        Set<Integer> visited = new HashSet<>();
        dfsOrderHelper(start, visited, order);

        return order;
    }

    private void dfsOrderHelper(int current, Set<Integer> visited, List<Integer> order) {
        visited.add(current);
        order.add(current);

        for (int neighbor : adjacencyList.get(current)) {
            if (!visited.contains(neighbor)) {
                dfsOrderHelper(neighbor, visited, order);
            }
        }
    }
}