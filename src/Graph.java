import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    
    private int vertices; //number of vertices in the graph
    private int edges; //number
    private List<List<Integer>> adjList;

    /*
    Description: This is the constructor for the graph object
    Parameters:
    int nodes - The number of nodes the graph will contain
    Returns: Nothing
    Sources:
    https://chat.openai.com/share/8b4c2e60-b4e3-4b2a-909b-4a3300ec4287
    https://www.youtube.com/watch?v=X1LdtRW88c0
    */
    public Graph(int nodes) { //constructor for Graph object
        this.vertices = nodes; //initializes the number of vertices as the number of nodes
        this.edges = 0; //initializes the number of edges to 0
        this.adjList = new ArrayList<>(); //initilizes ArrayList for adjacency lists for each node
        for (int i = 0; i < nodes; i++) { //for each node within the graph a new adjacency list is created
            adjList.add(new ArrayList<>()); //adds the list for each node to adjList
        }
    }

    /*
    Description: This function adds undirected edges to the graph represented as a 1 in the adjacency matrix both ways
    Parameters:
    int node1 - A node read from the text file to be connected to node2 via an edge
    int node2 - A node read from the text file to be connected to node1 via an edge
    Returns: Nothing
    Sources:
    https://chat.openai.com/share/8b4c2e60-b4e3-4b2a-909b-4a3300ec4287
    https://www.youtube.com/watch?v=X1LdtRW88c0
    */
    public void addEdge(int node1, int node2) {
        adjList.get(node1).add(node2); //gets the adjacency list for node1 and adds node2 to that list
        adjList.get(node2).add(node1); //gets the adjacency list for node2 and adds node1 to that list
        edges++;
    }

    
    /*
    Description: This function iterates through the list of adjacency lists for each node, appending each element to a string and printing each of them to form an adjacency list for the graph
    Parameters: None
    Returns: Nothing
    Sources:
    https://www.youtube.com/watch?v=X1LdtRW88c0
    */
    public void printAdjList() {
        StringBuilder string = new StringBuilder(); //initialize StringBuilder object
        string.append("The graph contains "+ edges + " edges and " + vertices + " vertices. \n"); 
        for (int i = 0; i < vertices; i++) { //iterates through the list of adjacency lists using using a for loop stopping at the number of vertices
            string.append("Adjacency list for node " + i + ": ");
            for (int neighbor : adjList.get(i)) { //for each neighbor contained in the nested adjacency list 
                string.append(neighbor + " "); 
            }
            string.append("\n");
        }
        System.out.println(string);
    }

    public int getVertices() { //getter for vertices
		return this.vertices;
	}

	public void setVertices(int vertices) { //setter for vertices
		this.vertices = vertices;
	}

	public int getEdges() { //getter for edges
		return this.edges;
	}

	public void setEdges(int edges) { //setter for edges
		this.edges = edges;
	}

	public List<Integer> getAdjList(int node) { //getter for adjList of a certain node
        return adjList.get(node);
    }

    /*
    Description: This function uses breadth-first search to traverse the graph and print each node
    Parameters: None
    Returns: Nothing
    Sources:
    https://chat.openai.com/share/3615b67f-45b3-411b-80d5-4ac6984224e1
    https://stackoverflow.com/questions/5262308/how-do-implement-a-breadth-first-traversal
    */
    public void BFS(int startNode) {
        boolean[] visited = new boolean[vertices]; //matrix containing boolean values for each node; 1 means visited, 0 means unvisited
        Queue<Integer> queue = new LinkedList<>(); //creates a queue of integers using a LinkedList as the underlying data structure to queue neighbors 

        visited[startNode] = true; //set the startNode variable to visited in the boolean matrix as it is the starting node
        queue.add(startNode); //add starting node to the queue

        System.out.print("Breadth-First Search starting from node " + startNode + ": ");
        while (!queue.isEmpty()) { //while the queue is not empty
            int node = queue.poll(); //dequeues the front node and assigns it to the node variable
            System.out.print(node + " "); //prints node to indicate which node is currently being processed

            for (int neighbor : adjList.get(node)) { //iterates through neighbors of the current node 
                if (!visited[neighbor]) { //if the neighbor has not been visited yet
                    visited[neighbor] = true; //set visited to true in matrix
                    queue.add(neighbor); //add neighbor to que for printing
                }
            }
        }

        boolean hasUnvisitedNodes = false; //unvisited nodes flag
        for (int i = 0; i < vertices; i++) { //iterates through vertices to check if any node remained unvisited
            if (!visited[i]) { //if the current node is unvisited
                hasUnvisitedNodes = true; //set flag to true
                break;
            }
        }

        if (hasUnvisitedNodes) { //case for there being no path to some nodes
            System.out.println("\nThere is no path to some nodes.");
        } else {
            System.out.println(); //move to the next line after printing the BFS traversal
        }
    }
}
