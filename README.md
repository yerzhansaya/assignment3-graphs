# Assignment 4: Graph Traversal and Representation System

## Project Overview

This project implements a graph traversal and representation system in Java using an adjacency list structure.

A graph is a data structure made of:

- Vertices (nodes)
- Edges (connections between nodes)

The project demonstrates two important graph traversal algorithms:

- Breadth-First Search (BFS)
- Depth-First Search (DFS)

The program creates and tests graphs of different sizes:

- Small graph: 10 vertices
- Medium graph: 30 vertices
- Large graph: 100 vertices

The execution time of BFS and DFS is measured using:

```java
System.nanoTime();
```

The purpose of the project is to understand graph structures, graph traversal algorithms, adjacency list representation, and algorithm performance analysis.

---

# Graph Structure

The graph is represented using an adjacency list.

An adjacency list stores each vertex together with a list of all neighboring vertices connected to it.

Example:

```text
0 -> 1 2
1 -> 2
2 -> 3 4
```

This means:

- Vertex `0` is connected to vertices `1` and `2`
- Vertex `1` is connected to vertex `2`
- Vertex `2` is connected to vertices `3` and `4`

The graph in this project is implemented as a directed graph.

---

# Overview of BFS and DFS

## Breadth-First Search (BFS)

BFS explores the graph level by level.

It first visits all neighbors of the starting vertex before moving deeper into the graph.

BFS uses a queue data structure.

---

## Depth-First Search (DFS)

DFS explores the graph by going as deep as possible before backtracking.

DFS uses recursion or a stack data structure.

---

# Class Descriptions

## Vertex Class

The `Vertex` class represents a node in the graph.

### Fields

- `id` — unique identifier of the vertex

### Methods

- Constructor
- `getId()`
- `toString()`

The class is used to create and manage graph vertices.

---

## Edge Class

The `Edge` class represents a connection between two vertices.

### Fields

- `source`
- `destination`

### Methods

- Constructor
- Getter methods
- `toString()`

The class is used to represent graph edges.

---

## Graph Class

The `Graph` class represents the graph structure.

The graph uses an adjacency list representation:

```java
Map<Integer, List<Integer>> adjacencyList;
```

### Methods

- `addVertex(Vertex v)`
- `addEdge(int from, int to)`
- `printGraph()`
- `bfs(int start)`
- `dfs(int start)`

The class stores graph vertices and edges and performs graph traversal operations.

---

## Experiment Class

The `Experiment` class handles testing and analysis.

### Methods

- `runTraversals(Graph g)`
- `runMultipleTests()`
- `printResults()`

This class performs experiments on graphs with different sizes and compares BFS and DFS performance.

---

# Algorithm Descriptions

# Breadth-First Search (BFS)

BFS visits graph vertices level by level.

It starts from the selected vertex and visits all immediate neighbors before visiting deeper vertices.

## BFS Step-by-Step Process

1. Create a queue
2. Create a visited set
3. Add the starting vertex to the queue
4. Mark the starting vertex as visited
5. Remove a vertex from the queue
6. Visit all unvisited neighboring vertices
7. Add neighbors to the queue
8. Repeat until the queue becomes empty

## BFS Use Cases

BFS is commonly used for:

- Finding shortest paths in unweighted graphs
- Network traversal
- Level-order traversal
- Social network analysis

## BFS Time Complexity

```text
O(V + E)
```

Where:

- `V` = number of vertices
- `E` = number of edges

BFS visits every vertex and edge at most once.

---

# Depth-First Search (DFS)

DFS explores the graph deeply before backtracking.

It visits one path completely before moving to another path.

## DFS Step-by-Step Process

1. Start from the selected vertex
2. Mark the current vertex as visited
3. Visit the current vertex
4. Recursively visit unvisited neighbors
5. Backtrack when no unvisited neighbors remain

## DFS Use Cases

DFS is commonly used for:

- Path finding
- Cycle detection
- Topological sorting
- Maze solving
- Connected component analysis

## DFS Time Complexity

```text
O(V + E)
```

Where:

- `V` = number of vertices
- `E` = number of edges

DFS also visits every vertex and edge at most once.

---

# Experimental Results

The program was tested using three graph sizes:

- 10 vertices
- 30 vertices
- 100 vertices

## Execution Time Comparison

| Graph Size | Vertices | BFS Time (ns) | DFS Time (ns) |
|---|---:|---:|---:|
| Small | 10 | 14500 | 7900 |
| Medium | 30 | 61300 | 22100 |
| Large | 100 | 110100 | 70700 |

---

# Observations and Patterns

As graph size increased, execution time also increased because both BFS and DFS had to visit more vertices and edges.

DFS was faster than BFS in these experiments. This happened because DFS uses recursive depth traversal, while BFS maintains an additional queue structure.

Both algorithms demonstrated behavior consistent with the expected complexity:

```text
O(V + E)
```

The traversal order depended on graph structure and edge connections.

---

# Analysis Questions

## How does graph size affect BFS and DFS performance?

As the graph size increases, BFS and DFS require more time because more vertices and edges must be processed.

---

## Which traversal is faster in your experiments?

DFS was faster in the experiments performed in this project.

---

## Do results match the expected complexity O(V + E)?

Yes. The execution times increased as the number of vertices and edges increased, which matches the expected time complexity of `O(V + E)`.

---

## How does graph structure affect traversal order?

Graph structure determines the order in which vertices are visited.

BFS visits vertices level by level, while DFS explores one branch deeply before backtracking.

Different edge connections can produce different traversal orders.

---

## When is BFS preferred over DFS?

BFS is preferred when searching for the shortest path in an unweighted graph or when exploring nearby vertices first.

---

## What are the limitations of DFS?

DFS may use a large amount of recursion for deep graphs and can cause stack overflow in very large graphs.

DFS also does not always find the shortest path in an unweighted graph.

---

# Screenshots

## Graph Structure Output

![Graph Structure](graph-structure.png)

---

## BFS Traversal Output

![BFS Output](bfs-output.png)

---

## DFS Traversal Output

![DFS Output](dfs-output.png)

---

## Performance Results

![Performance Results](performance-results.png)

---

# Reflection

In this assignment, I learned how graphs are represented using adjacency lists and how graph traversal algorithms work. I learned the differences between BFS and DFS and how they explore graph structures differently.

BFS explores graphs level by level using a queue, while DFS explores deeply using recursion. I also learned how algorithm performance changes as graph size increases.

One challenge during implementation was understanding recursion in DFS and ensuring vertices were not visited multiple times. Another challenge was measuring execution time accurately using `System.nanoTime()`.

Overall, this assignment improved my understanding of graph algorithms, object-oriented programming, and algorithm complexity analysis.

---
```

---

# Repository Structure

```text
assignment3-graphs/
├── src/
│   ├── Vertex.java
│   ├── Edge.java
│   ├── Graph.java
│   ├── Experiment.java
│   └── Main.java
├── docs/
│   ├── screenshots/
├── README.md
└── .gitignore
```

---

