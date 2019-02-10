package shortestPathInGraph;

import java.util.*;

public class PathFinderImpl implements PathFinder {

    private Queue<Vertex> queue = new PriorityQueue<>();

    private Vertex source, dest;

    @Override
    public int findShortestPathLength(Vertex source, Vertex destination) {
        this.source = source;
        this.source.setCost(0);
        this.dest = destination;

        queue.add(this.source);

        while (!queue.isEmpty()){
            Vertex current = queue.poll();
            for (Edge e : current.getAdj()) {
                Vertex to = e.getTo();
                int cost = current.getCost() + e.getWeight();
                if (to.getCost() > cost) {
                    to.setCost(cost);
                    to.setParent(current);
                }
                queue.add(to);
            }
        }

        return dest.getCost();
    }

    @Override
    public void printPath() {
        List<Vertex> result = new ArrayList<>();
        Vertex current = dest;
        while (current.getParent() != null) {
            result.add(current);
            current = current.getParent();
        }
        result.add(current);
        Collections.reverse(result);

        System.out.println(result);
    }
}
