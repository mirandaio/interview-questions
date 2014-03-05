import java.util.ArrayList;

public class Graph {
    public ArrayList<Vertex> vertices;

    public Graph() {
        vertices = new ArrayList<Vertex>();
    }

    public void add(Vertex v) {
        vertices.add(v);
    }
}
