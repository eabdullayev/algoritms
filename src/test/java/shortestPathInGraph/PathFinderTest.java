package shortestPathInGraph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PathFinderTest {

    private PathFinder pathFinder;

    private Vertex source;
    private Vertex destination;

    @BeforeEach
    void setUp() {
        source = new Vertex(0);
        destination = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        source.getAdj().add(new Edge(destination, 11));
        source.getAdj().add(new Edge(v2, 2));
        v2.getAdj().add(new Edge(v3, 3));
        v3.getAdj().add(new Edge(v4, 4));
        v4.getAdj().add(new Edge(destination, 1));

        // initialise pathFinder here ...
        // pathFinder = ...
    }

    @Test
    void findShortestPathLength() {
        assertThat(pathFinder.findShortestPathLength(source, destination)).isEqualTo(10);
    }
}