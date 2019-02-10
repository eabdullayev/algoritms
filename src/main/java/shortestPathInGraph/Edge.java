package shortestPathInGraph;

import lombok.Value;

@Value
public class Edge{
    private final Vertex to;
    private final int weight;
}
