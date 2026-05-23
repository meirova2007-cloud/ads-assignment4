# Bonus Task — Dijkstra’s Algorithm

The project was extended with Dijkstra’s Algorithm for shortest path calculation.

---

## Additional Features
- Support for weighted edges
- Updated adjacency list with weights
- Shortest path calculation from starting vertex
- Distance output for all vertices

---

## Changes Made
- Added weight field to Edge class
- Modified graph representation
- Implemented dijkstra(int start)
- Added weighted graph examples

---

## Complexity
Time Complexity:
O(V²)

Where:
- V = number of vertices

The implementation uses arrays and loops instead of a priority queue.

---

# Assignment 4 — Graph Traversal and Representation System
Represents a connection between two vertices.

### Fields
- source
- destination

### Methods
- Constructor
- Getters
- toString()

---

## Graph Class

Stores graph structure using adjacency lists.

### Main Methods
- addVertex(Vertex v)
- addEdge(int from, int to)
- printGraph()
- bfs(int start)
- dfs(int start)

---

## Experiment Class

Handles:
- Graph generation
- Performance testing
- Execution time measurement

---

# Adjacency List Representation

An adjacency list stores all neighbors of every vertex.

Advantages:
- Memory efficient
- Faster traversal for sparse graphs
- Easy to implement

---

# Algorithm Descriptions

## Breadth-First Search (BFS)

BFS explores all neighboring vertices level by level.

### Steps
1. Start from a chosen vertex
2. Add it to queue
3. Visit all neighbors
4. Continue until queue becomes empty

### Data Structure Used
Queue

### Use Cases
- Shortest path in unweighted graph
- Social networks
- GPS systems
- Network broadcasting

### Time Complexity
O(V + E)

Where:
- V = number of vertices
- E = number of edges

---

## Depth-First Search (DFS)

DFS explores vertices deeply before backtracking.

### Steps
1. Start from chosen vertex
2. Visit one neighbor deeply
3. Continue recursively
4. Backtrack when needed

### Data Structure Used
Stack / Recursion

### Use Cases
- Path finding
- Cycle detection
- Maze solving
- Topological sorting

### Time Complexity
O(V + E)

---

# Experimental Results

## Performance Table

| Graph Size   | BFS Time (ns) | DFS Time (ns) |
|--------------|---------------|---------------|
| 10 Vertices  | 860500        | 266166        |
| 30 Vertices  | 542542        | 524208        |
| 100 Vertices | 1474917       | 931084        |

*Results may vary depending on computer performance.*

---

# Analysis Questions

## How does graph size affect BFS and DFS?

As the graph size increases, execution time also increases because more vertices and edges must be visited.

---

## Which traversal is faster?

DFS was slightly faster in most experiments because it uses recursion and may require less queue management than BFS.

---

## Do results match O(V + E)?

Yes. Both BFS and DFS visit each vertex and edge once, which matches the expected complexity.

---

## How does graph structure affect traversal order?

Traversal order depends on:
- Neighbor ordering
- Graph density
- Edge placement

Different graph structures produce different traversal outputs.

---

## When is BFS preferred over DFS?

BFS is preferred when:
- Finding the shortest path
- Searching level-by-level
- Working with unweighted graphs

---

## What are the limitations of DFS?

- Can go too deep into graph
- May use large recursion stack
- Does not guarantee the shortest path

---

# Screenshots

Add screenshots of:

- Graph adjacency list output
- BFS traversal output
- DFS traversal output
- Performance results

Place screenshots inside:

/docs/screenshots/

---

# Reflection

This assignment helped me understand graph traversal algorithms and adjacency list representation. I learned how BFS and DFS work internally and how they differ in traversal behavior.

One challenge during implementation was managing visited vertices correctly to avoid infinite loops. Another challenge was understanding recursive DFS traversal. Overall, the project improved my understanding of graphs, algorithm complexity, and object-oriented programming in Java.

---

# GitHub Commit Examples

- init: project structure
- feat(vertex): implemented Vertex class
- feat(edge): added Edge class
- feat(graph): implemented adjacency list
- feat(traversal): added BFS and DFS
- feat(experiment): added performance testing
- docs(readme): added analysis and results
- perf(cleanup): improved formatting
- release: v1.0