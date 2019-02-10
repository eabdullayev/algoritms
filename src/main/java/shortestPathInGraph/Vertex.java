package shortestPathInGraph;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Getter
public class Vertex implements Comparable<Vertex>{

    private final int id;

    private final List<Edge> adj;

    @Setter private Vertex parent;

    @Setter private int cost = Integer.MAX_VALUE;

    public Vertex(int id) {
        this.id = id;
        this.adj = new LinkedList<>();
    }

    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(this.cost, o.cost);
    }

    @Override
    public String toString() {
        return "ID: " + id;
    }
}
