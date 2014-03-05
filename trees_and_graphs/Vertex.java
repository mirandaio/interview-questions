import java.util.ArrayList;

public class Vertex {
    public int value;
    public ArrayList<Vertex> adj;
    public String color;
    public Vertex predecessor; // parent of the vertex in the breath-first tree
    public int d; // distance from the source s computed by BFS
    public int f; // used only by DFS
    boolean visited;

    public Vertex(int value) {
        this.value = value;
        adj = new ArrayList<Vertex>();
    }
}
