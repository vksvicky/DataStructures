# Data Structures

This document lists various **data structures** used in computer science, categorized into **linear**, **non-linear**, **hash-based**, **specialized**, and **graph-based** structures.

---

| **Data Structure** | **Available in** | **Description** |
|:--|:--|--|
|  **Array** | [&check;] Java <br/>[&check;] Scala <br/>[&check;] Python <br/>[&check;] C# | A collection of elements identified by index or key, typically of the same type. |
|  **Stack** | [&check;] Java <br/>[&check;] Scala <br/>[&check;] Python <br/>[&check;] C# | A collection that follows the Last In First Out (LIFO) principle. |
|  **Queue** | [&check;] Java <br/>[&check;] Scala <br/>[&check;] Python <br/>[&check;] C# | A collection that follows the First In First Out (FIFO) principle. |
| **Linked List** | [&check;] Java <br/>[&check;] Scala <br/>[&check;] Python <br/>[&check;] C# | A linear collection of elements where each element points to the next. |
| **Deque** | [&check;] Java <br/>[&check;] Scala <br/>[&check;] Python <br/>[&check;] C# | A double-ended queue where elements can be added or removed from both ends. |
| **Hash Map** | [&check;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A collection of key-value pairs where each key is unique and maps to a value. |
| **Set** | [&check;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A collection of unique elements with no duplicates. |
| **Priority Queue** | [&check;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A queue where each element has a priority, and elements are dequeued <br/>in priority order. |
| **Heap** | [&check;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A binary tree-based data structure where the parent node is ordered with <br/>respect to its children (min or max heap). |
| **Trie** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A tree-like data structure used to store strings, with nodes representing characters. |
| **Graph** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A collection of nodes (vertices) and edges (connections between nodes). |
| **Tree** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A hierarchical structure with nodes connected by edges, with a single root. |
| **Disjoint Set <br/>(Union-Find)** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A data structure to manage a partition of a set into disjoint subsets.         |
| **Bloom Filter** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A space-efficient probabilistic data structure used to test whether an element is a member of a set. || **Hash Table** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A data structure that implements an associative array, where each key maps to a value using a hash function. |
| **Bitset** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A data structure that compactly stores a sequence of bits, often used for set operations. |
| **Skip List** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A probabilistic data structure for fast search, insertion, and deletion. |
| **B-tree** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A self-balancing tree data structure that maintains sorted data and allows searches, insertions, and deletions in logarithmic time. |
| **Interval Tree** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A tree data structure used to store intervals, supporting fast searching for overlapping intervals. |
| **Segment Tree** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A tree data structure for storing intervals or segments, supporting efficient range queries and updates. |
| **Fenwick Tree <br/>(Binary Indexed Tree)** | [&cross;] Java <br/>[&cross;] Scala <br/>[&cross;] Python <br/>[&cross;] C# | A data structure that provides efficient methods for prefix sum queries and updates. |

---

## 1. Linear Data Structures

Linear data structures organize data in a sequential manner.

- **Array**
  - Fixed-size structure used to store elements of the same type.
  
- **Linked List**
  - A collection of nodes, where each node contains data and a reference to the next node.
  - Types:
    - **Singly Linked List**
    - **Doubly Linked List**
    - **Circular Linked List**

- **Stack**
  - Follows the **LIFO** (Last In, First Out) principle.
  
- **Queue**
  - Follows the **FIFO** (First In, First Out) principle.
  - Types:
    - **Simple Queue**
    - **Circular Queue**
    - **Priority Queue**
    - **Deque (Double-ended Queue)**

- **Deque (Double-ended Queue)**
  - A linear structure that allows adding and removing elements from both ends.

---

## 2. Non-linear Data Structures

Non-linear data structures do not organize data sequentially, and elements can have hierarchical relationships.

- **Tree**
  - A hierarchical structure with nodes connected by edges.
  - Types:
    - **Binary Tree**
    - **Binary Search Tree (BST)**
    - **AVL Tree (Balanced BST)**
    - **Red-Black Tree**
    - **Heap (Min-Heap, Max-Heap)**
    - **Trie**
    - **Segment Tree**
    - **Fenwick Tree (Binary Indexed Tree)**

- **Graph**
  - A collection of nodes (vertices) and edges connecting them.
  - Types:
    - **Directed Graph (Digraph)**
    - **Undirected Graph**
    - **Weighted Graph**
    - **Unweighted Graph**
    - **Cyclic and Acyclic Graphs**
    - **Tree Graph**
    - **Adjacency Matrix**
    - **Adjacency List**
    - **Graph Search Algorithms**: DFS, BFS

---

## 3. Hash-based Data Structures

These data structures use a hash function for quick data retrieval.

- **Hash Table (Hash Map)**
  - A key-value pair structure where the key is hashed to determine the index.
  - Types:
    - **Open Addressing**: Linear Probing, Quadratic Probing, Double Hashing
    - **Chaining**

- **Hash Set**
  - A set that uses hashing to ensure uniqueness and supports fast lookups.

---

## 4. Specialized Data Structures

These structures are designed for specific applications or optimizations.

- **Bloom Filter**
  - A space-efficient probabilistic structure used to test membership in a set.

- **Disjoint Set (Union-Find)**
  - Tracks a partition of a set into disjoint subsets, supporting union and find operations.

- **Priority Queue**
  - A queue where elements are dequeued in order of priority.

- **B-Tree**
  - A self-balancing tree data structure, commonly used in databases.

- **Skip List**
  - A probabilistic alternative to balanced trees, allowing fast search, insertion, and deletion.

- **Cartesian Tree**
  - A binary tree defined by heap properties and a sequence of elements.

- **Suffix Tree**
  - A compressed trie storing all suffixes of a string, useful for string matching.

- **Suffix Array**
  - An array of integers representing lexicographically sorted suffixes of a string.

- **Interval Tree**
  - A binary search tree for storing intervals and querying overlapping intervals.

- **K-d Tree (K-dimensional Tree)**
  - A space-partitioning tree used for organizing points in a k-dimensional space.

- **Quad Tree**
  - A tree structure used to partition a 2D space into four quadrants.

- **Octree**
  - A 3D extension of a quadtree used for partitioning 3D space into smaller cubes.

- **LRU Cache (Least Recently Used Cache)**
  - A cache that removes the least recently used item when full.

---

## 5. Advanced Tree Structures

- **B+ Tree**
  - A variant of B-tree where all leaf nodes are linked, and only leaves contain data.

- **Trie (Prefix Tree)**
  - A tree-like structure used for storing strings, where nodes represent characters of strings.

- **Segment Tree**
  - A binary tree for storing intervals and performing range queries.

- **Fenwick Tree (Binary Indexed Tree)**
  - A tree structure that supports efficient cumulative sum queries over a range.

- **AVL Tree**
  - A self-balancing binary search tree ensuring balance with height constraints.

- **Red-Black Tree**
  - A balanced binary search tree ensuring balance during insertions and deletions.

---

## 6. Advanced Graph Data Structures

- **Adjacency Matrix**
  - A 2D array used to represent a graph, where matrix entries indicate the presence of edges.

- **Adjacency List**
  - A collection of lists where each list corresponds to a vertex and contains all adjacent vertices.

- **Incidence Matrix**
  - A matrix where rows represent edges and columns represent vertices.

- **Topological Sort**
  - An ordering of vertices in a directed acyclic graph (DAG).

- **Floyd-Warshall Algorithm**
  - An algorithm to find shortest paths in a graph, useful for graphs with negative edge weights.

- **Dijkstra's Algorithm**
  - An algorithm for finding the shortest path between nodes in a graph with non-negative edge weights.

---

## 7. Multi-dimensional Data Structures

- **R-tree**
  - A tree data structure used for indexing multi-dimensional objects, commonly used in spatial databases.

- **Octree**
  - A tree structure used to partition 3D space, typically in graphics or spatial data applications.

---

## 8. Miscellaneous Data Structures

- **Vector**
  - A dynamic array that resizes as elements are added.

- **Deque (Double-Ended Queue)**
  - A queue allowing elements to be added or removed from both ends.

- **Fibonacci Heap**
  - A heap structure supporting efficient decrease-key operations.

- **Circular Buffer**
  - A fixed-size buffer that overwrites the oldest data when full.

- **Trie**
  - A tree-like structure used to store a set of strings or sequences.

---

## Cheatsheet

| **Data Structure**    | **Java**                                  | **Python**                                  | **Scala**                                  | **Time Complexity**                               |
|-----------------------|-------------------------------------------|---------------------------------------------|--------------------------------------------|--------------------------------------------------|
| **Array**             | `int[]`, `ArrayList<T>`, `Vector<T>`      | `list`, `array` (via `array` module)        | `Array`, `List`, `Vector`                  | Access: O(1), Insertion: O(n), Deletion: O(n)    |
| **Stack**             | `Stack<T>`, `Deque<T>`                    | `list` (used as stack), `deque` (collections) | `Stack`, `List`, `Queue`                   | Push/Pop: O(1), Peek: O(1)                       |
| **Queue**             | `Queue<T>`, `LinkedList<T>`, `PriorityQueue<T>` | `queue.Queue`, `deque` (collections)        | `Queue`, `LinkedList`, `PriorityQueue`      | Enqueue/Dequeue: O(1), Peek: O(1)                |
| **Linked List**       | `LinkedList<T>`                           | `collections.deque`, custom linked list     | `List`, `LinkedList`                       | Access: O(n), Insert/Delete: O(1) (at head/tail)|
| **Deque**             | `ArrayDeque<T>`, `LinkedList<T>`          | `collections.deque`                        | `Deque`, `Queue`, `List`                   | Enqueue/Dequeue: O(1), Peek: O(1)                |
| **Hash Map**          | `HashMap<K,V>`, `Hashtable<K,V>`, `LinkedHashMap<K,V>` | `dict`                                     | `Map`, `HashMap`, `TreeMap`                | Insert/Search/Delete: O(1) (average), O(n) (worst) |
| **Set**               | `HashSet<T>`, `LinkedHashSet<T>`, `TreeSet<T>` | `set`                                      | `Set`, `HashSet`, `TreeSet`                | Insert/Search/Delete: O(1) (average), O(n) (worst) |
| **Priority Queue**    | `PriorityQueue<T>`                        | `queue.PriorityQueue`                       | `PriorityQueue`                            | Insert: O(log n), Remove: O(log n), Peek: O(1)  |
| **Heap**              | `PriorityQueue<T>`, `ArrayList<T>`        | `heapq`                                     | `Heap`, `PriorityQueue`                    | Insert: O(log n), Remove: O(log n), Peek: O(1)  |
| **Trie**              | Custom implementation or libraries        | Custom implementation or libraries          | Custom implementation or libraries         | Insert/Search: O(m) (m = length of string)       |
| **Graph**             | `Graph`, custom implementation            | Custom implementation                       | `Graph`, custom implementation             | BFS/DFS: O(V+E), Dijkstra: O(V^2)               |
| **Tree**              | `TreeMap<K,V>`, `TreeSet<T>`              | `binarytree` (external library)             | `Tree`, `BinaryTree`                       | Insert/Search/Delete: O(log n) (balanced)       |
| **Disjoint Set**      | Custom implementation                     | `disjointset` (external library)            | Custom implementation                      | Find/Union: O(α(n)) (α = inverse Ackermann function) |
| **Bloom Filter**      | Custom implementation or libraries        | `pybloom` (external library)               | Custom implementation or libraries         | Insert/Search: O(k) (k = number of hash functions) |
| **Hash Table**        | `Hashtable<K,V>`, `HashMap<K,V>`          | `dict`                                      | `HashMap`, `HashTable`                     | Insert/Search/Delete: O(1) (average), O(n) (worst) |
| **Circular Buffer**   | Custom implementation or libraries        | `collections.deque`                        | Custom implementation                      | Insert/Remove: O(1), Access: O(1)                |
| **Bitset**            | `BitSet`                                  | `bitarray` (external library)               | `BitSet`                                   | Set/Get: O(1), Operations: O(n) (depending on operation) |
