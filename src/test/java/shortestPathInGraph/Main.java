package shortestPathInGraph;

public class Main {
    public static void main(String[] args) {
        Vertex source = new Vertex(0);
        Vertex destination = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);

        source.getAdj().add(new Edge(destination, 9));
        source.getAdj().add(new Edge(v2, 2));
        v2.getAdj().add(new Edge(v3, 3));
        v3.getAdj().add(new Edge(v4, 4));
        v4.getAdj().add(new Edge(destination, 1));

        PathFinder pathFinder = new PathFinderImpl();
        System.out.println(pathFinder.findShortestPathLength(source, destination));

        pathFinder.printPath();
    }
}
