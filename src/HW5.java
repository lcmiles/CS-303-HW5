import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HW5 {

    /*
    Description: Executable function that is responsible for reading the text file and calling the functions in the Graph class that build, print, and perform BFS on the graph
    Parameters:
    String[] args - Runtime arguments
    Returns: Nothing
    Sources:
    https://stackoverflow.com/questions/26448352/counting-the-number-of-lines-in-a-text-file-java
    https://www.youtube.com/watch?v=X1LdtRW88c0
    */
    public static void main(String[] args) {
        String filename = "mediumG.txt"; //initialize filename string variable
        try {
            long numberOfLines = Files.lines(Paths.get(filename)).count(); //count the number of lines in the text file
            Graph graph = new Graph((int)numberOfLines); //initialize graph object with the number of lines in the text file with the number of nodes
            BufferedReader reader = new BufferedReader(new FileReader(filename)); //initialize reader object
            String line;
            int lineCount = 0; //initialize line count
            while ((line = reader.readLine()) != null) { //iterate through the text file with a while loop
                lineCount++; //iterate the line count variable forward 1 with each loop
                if (lineCount == 1) { //case for first line
                    graph.setVertices(Integer.parseInt(line)); //parse the int value representing the number of vertices and assign it to the graph object
                }
                else if (lineCount == 2) { //case for second line
                    continue; //skip because addEdge() adds edges
                }
                else {
                    String[] nodes = line.split(" "); //split each line at the space using a regex
                    int node1 = Integer.parseInt(nodes[0]); //parse the int value and assign it to node1
                    int node2 = Integer.parseInt(nodes[1]); //parse the int value and assing it to node2 
                    graph.addEdge(node1, node2); //call addEdge() on both nodes to add them to the graph
                }
            }
            reader.close();
            graph.printAdjList(); //call printAdjList() to print the adjacency list representation of the graph
            long timeInit = System.nanoTime(); //records initial system time in nanoseconds
            graph.BFS(100); //call BFS on following nodes
            long timeFinal = System.nanoTime(); // records final system time in nanoseconds
            long time = timeFinal - timeInit; //calculates time taken for BFS algorithm
            System.out.println("Breadth-First Search Time: " + time + " nanoseconds, " + (float)time/1000000 + " milliseconds, or " + (float)time/1000000000 + " seconds");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
