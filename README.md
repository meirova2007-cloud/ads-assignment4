# Bonus Task — Dijkstra’s Algorithm Implementation
## Overview
As a bonus extension to the original graph traversal project, Dijkstra’s Algorithm was implemented to calculate the shortest paths in a weighted graph.

This addition demonstrates how graph traversal concepts can be extended into more advanced graph algorithms used in real-world applications.

---

# What is Dijkstra’s Algorithm?

Dijkstra’s Algorithm is the shortest path algorithm used for weighted graphs with non-negative edge weights.

The algorithm finds:
- the minimum distance
- from one starting vertex
- to all other vertices in the graph

Unlike BFS and DFS, Dijkstra considers edge weights when choosing the best path.

---

# Real-World Applications

Dijkstra’s Algorithm is commonly used in:
- GPS navigation systems
- Google Maps
- transportation networks
- internet routing
- network optimization

---

# Graph Changes for Bonus Task

## 1. Weighted Edges

The `Edge` class was modified to include a `weight` field.

### Added field:

```java
private int weight;
```

This allows every edge to store:
- distance
- cost
- path weight

---

## 2. Updated Adjacency List

The graph structure was upgraded from a simple adjacency list to a weighted adjacency list.

### Before:

```java
Map<Integer, List<Integer>>
```

### After:

```java
Map<Integer, List<Neighbor>>
```

The new structure stores:
- connected vertex
- edge weight

This change was necessary because Dijkstra’s Algorithm requires weighted edges.

---

## 3. Neighbor Helper Class

A helper class named `Neighbor` was added inside `Graph.java`.

### Purpose

The class stores:
- adjacent vertex
- edge weight

### Structure

```java
class Neighbor {

    int vertex;
    int weight;

    public Neighbor(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }
}
```

This class simplifies weighted graph representation inside the adjacency list.

---

# Dijkstra Algorithm Implementation

The following method was implemented:

```java
void dijkstra(int start)
```

The method:
- receives a starting vertex
- calculates shortest distances
- prints shortest path values for all reachable vertices

---

# How the Algorithm Works

The algorithm follows these steps:

1. Set all distances to infinity
2. Set starting vertex distance to 0
3. Find the unvisited vertex with minimum distance
4. Mark the vertex as visited
5. Update distances of neighboring vertices
6. Repeat until all reachable vertices are processed

---

# Example

## Weighted Graph

```text
0 --4-- 1
0 --2-- 2
1 --5-- 3
2 --8-- 3
```

## Starting Vertex

```text
0
```

## Output

```text
To vertex 0 = 0
To vertex 1 = 4
To vertex 2 = 2
To vertex 3 = 9
```

Explanation:
- shortest path from 0 to 1 = 4
- shortest path from 0 to 2 = 2
- shortest path from 0 to 3 = 9

---

# Data Structures Used

The implementation uses:
- weighted adjacency list
- arrays
- loops
- visited array

### Arrays Used

```java
int[] distance
boolean[] visited
```

### distance[]

Stores the shortest known distance from the starting vertex.

### visited[]

Tracks which vertices were already processed.

---

# Complexity Analysis

The implementation uses loops instead of a priority queue.

## Time Complexity

\[
O(V^2)
\]

Where:
- `V` = number of vertices

The algorithm repeatedly searches for the minimum-distance vertex using loops, which increases overall complexity.

---

# Conclusion

The bonus implementation successfully added:
- weighted graph support
- Dijkstra shortest path algorithm
- weighted adjacency list representation
- shortest distance calculations

The final project now demonstrates:
- BFS traversal
- DFS traversal
- shortest path analysis using Dijkstra’s Algorithm

This significantly improved the functionality and complexity of the original graph traversal system.

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