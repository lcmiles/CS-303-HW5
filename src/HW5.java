import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HW5 {

    public static void main(String[] args) {
        String filename = "mediumG.txt";
        try {
            long numberOfLines = Files.lines(Paths.get(filename)).count();
            Graph graph = new Graph((int)numberOfLines); //initialize graph object
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
            graph.printAdjList();
            graph.BFS(169);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
