import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HW6 {
    static Graph graph = new Graph(0); //initialize graph object with 0 nodes

    

    public static void main(String[] args) throws Exception {
        buildGraph("mediumG.txt");
        // buildGraph("largeG.txt");
        graph.printAdjMatrix();
    }

    public static void buildGraph(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename)); //initialize reader object
            String line;
            int lineCount = 0; //initialize line count
            while ((line = reader.readLine()) != null) {
                lineCount++;
                if (lineCount == 1) {
                    graph.setVertices(Integer.parseInt(line));
                }
                else if (lineCount == 2) {
                    graph.setEdges(Integer.parseInt(line));
                }
                else {
                    String[] nodes = line.split(" ");
                    int node1 = Integer.parseInt(nodes[0]);
                    int node2 = Integer.parseInt(nodes[1]);
                    graph.addEdge(node1, node2);
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
