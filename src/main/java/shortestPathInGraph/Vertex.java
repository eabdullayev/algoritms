package shortestPathInGraph;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Vertex {

    private final int id;

    private final List<Edge> adj;

    @Setter private int cost = Integer.MAX_VALUE;

    public Vertex(int id) {
        this.id = id;
        this.adj = new LinkedList<>();
    }
}
