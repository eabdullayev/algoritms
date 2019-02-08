package shortestpath;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MazeSlove {
    private Queue<Vertex> heap = new PriorityQueue<>();
    private Vertex[][] vertices;
    private int[] row = new int[]{-1, 0, 0, 1};
    private int[] col = new int[]{0, -1, 1, 0};

    public void sloveMaze(int[][] array, Vertex start, Vertex end) {
        vertices = new Vertex[array.length][array[0].length];
        heap.add(start);
        while (!heap.isEmpty()) {
            Vertex current = heap.poll();
            int y = current.getY();
            int x = current.getX();
            for(int i = 0; i < row.length; i++) {
                int relativeY = y + row[i];
                int relativeX = x + col[i];
                Vertex vertex = getVertex(array, relativeY, relativeX, current);
                if (vertex != null) {
                    heap.add(vertex);
                }
            }
        }
        printPath(end);
    }

    private void printPath(Vertex end) {
        Vertex start = vertices[end.getY()][end.getX()];
        Stack<Vertex> result = new Stack<>();
        while (start.getParent() != null) {
            result.push(start);
            start = start.getParent();
        }
        result.push(start);
        while (!result.empty()) {
            start = result.pop();
            System.out.print(" Coordinates[y:x]: " + start.getY() + ":" + start.getX());
        }
    }

    private Vertex getVertex(int[][] array, int y, int x, Vertex current){
        if(array[y][x] == 0){
            Integer relativeWeight = (current.getWeight() + 1);
            if(vertices[y][x] != null){
                Vertex adjacent = vertices[y][x];
                if ( relativeWeight < adjacent.getWeight()) {
                    adjacent.setWeight(relativeWeight);
                    adjacent.setParent(current);
                }
            }else{
                Vertex vertex = new Vertex(x, y);
                vertex.setWeight(relativeWeight);
                vertex.setParent(current);
                vertices[y][x] = vertex;
                return vertex;
            }
        }
        return null;
    }

}

@Data
@RequiredArgsConstructor
class Vertex implements Comparable<Vertex>{
    @NonNull private int x;
    @NonNull private int y;
    private Vertex parent;
    private Integer weight = Integer.MAX_VALUE;

    @Override
    public int compareTo(Vertex o) {
        return this.weight.compareTo(o.weight);
    }
}