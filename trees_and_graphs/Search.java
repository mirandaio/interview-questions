import java.util.Queue;
import java.util.LinkedList;

public class Search {

    public static void main(String[] args) {
        Vertex v0 = new Vertex(0);
        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);
        Vertex v7 = new Vertex(7);
        Vertex v8 = new Vertex(8);
        Vertex v9 = new Vertex(9);

        v5.adj.add(v2);
        v5.adj.add(v8);
        v2.adj.add(v1);
        v2.adj.add(v4);
        v4.adj.add(v3);
        v8.adj.add(v6);
        v6.adj.add(v7);
        v3.adj.add(v8);

        Graph g = new Graph();
        g.add(v5);
        g.add(v2);
        g.add(v8);
        g.add(v1);
        g.add(v4);
        g.add(v6);
        g.add(v3);
        g.add(v7);

        System.out.println(search(g, v8, v5));

    }

    /* Given a directed graph, design an algorithm to find out whether there
     * is a route between two nodes.
     */
    public static boolean search(Graph g, Vertex start, Vertex end) {
        for(Vertex v : g.vertices)
            v.visited = false;

        Queue<Vertex> q = new LinkedList<Vertex>();
        start.visited = true;
        q.add(start);

        while(!q.isEmpty()) {
            Vertex u = q.remove();
            if(u == end)
                return true;

            for(Vertex v : u.adj) {
                if(!v.visited) {
                    v.visited = true;
                    q.add(v);
                }
            }
        }

        return false;
    }
}
