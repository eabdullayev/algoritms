package shortestPathInGraph;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
    private int id;
    private int cost = Integer.MAX_VALUE;
    private List<Edge> adj = new LinkedList<>();

    Vertex(int id) {
        this.id = id;
    }
}
