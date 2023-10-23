public class Graph {
    
    private int vertices;
    private int edges;
    private int adjMatrix[][];


    public Graph(int nodes) {
        this.vertices = nodes;
        this.edges = 0;
        this.adjMatrix = new int[nodes][nodes];
    }

    public void addEdge(int u, int v) {
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        edges++;
    }

    public String printAdjMatrix() {
        StringBuilder string = new StringBuilder();
        string.append("The graph contains "+ edges + " edges and " + vertices + " vertices.");
        for (int i = 0; i < vertices; i++) {
            string.append(i + " ");
            for (int k : adjMatrix[vertices]) {
                string.append(k);
            }
            string.append("\n");
        }
        return string.toString();
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

	public int[][] getAdjMatrix() {
		return this.adjMatrix;
	}

}
