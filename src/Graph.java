import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    
    private int vertices;
    private int edges;
    private int adjMatrix[][];
    private List<List<Integer>> adjList;


    public Graph(int nodes) {
        this.vertices = nodes;
        this.edges = 0;
        this.adjMatrix = new int[nodes][nodes];
        this.adjList = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        adjList.get(u).add(v);
        adjList.get(v).add(u);
        edges++;
    }

    public void printAdjList() {
        StringBuilder string = new StringBuilder();
        string.append("The graph contains "+ edges + " edges and " + vertices + " vertices.");
        for (int i = 0; i < vertices; i++) {
            string.append("Adjacency list for node " + i + ": ");
            for (int neighbor : adjList.get(i)) {
                string.append(neighbor + " ");
            }
            string.append("\n");
        }
        System.out.println(string);
    }

    public int getVertices() {
		return this.vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public int getEdges() {
		return this.edges;
	}

	public void setEdges(int edges) {
		this.edges = edges;
	}

	public List<Integer> getAdjList(int node) {
        return adjList.get(node);
    }

    public void BFS(int startNode) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startNode] = true;
        queue.add(startNode);

        System.out.print("Breadth-First Search starting from node " + startNode + ": ");
        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int neighbor : adjList.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        // Check if any node remained unvisited
        boolean hasUnvisitedNodes = false;
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                hasUnvisitedNodes = true;
                break;
            }
        }

        if (hasUnvisitedNodes) {
            System.out.println("\nThere is no path to some nodes.");
        } else {
            System.out.println(); // Move to the next line after printing the BFS traversal.
        }
    }
}
