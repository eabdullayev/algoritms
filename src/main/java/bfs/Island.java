package bfs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Island {
    private Queue<Vertex> queue = new LinkedList<>();
    private boolean[][] visited;

    private int[] row = new int[]{-1, 0, 0, 1};
    private int[] col = new int[]{0, -1, 1, 0};

    public int findIlands(int[][] array) {
        visited = new boolean[array.length][array[0].length];
        //key: area, value: count
        Map<Integer, Integer> groups = new HashMap<>();
        for (int y = 0; y < array.length; y++){
            for(int x = 0; x < array[y].length; x++){
                if(array[y][x] == 1 && !visited[y][x]){
                    visited[y][x] = true;
                    int area = getArea(array, new Vertex(x, y, true));

                    groups.put(area, ((groups.containsKey(area))? groups.get(area)+1 : 1));
                }
            }
        }

        System.out.println(groups);
        return groups.size();
    }

    public int getArea(int[][] array, Vertex vertex) {
        queue.add(vertex);

        int area = 1;

        while (queue.size() > 0) {
            Vertex v = queue.poll();
            for (int i = 0; i < row.length; i++) {
                int relativeX = v.getX() + row[i];
                int relativeY = v.getY() + col[i];
                if (relativeX >= 0 && relativeX < array[0].length
                        && relativeY >= 0 && relativeY < array.length) {
                    if(!visited[relativeY][relativeX]) {
                        int element = array[relativeY][relativeX];
                        if(addQueue(relativeX, relativeY, element)) {
                            area++;
                        }
                    }
                }
            }
        }
        return area;
    }

    private boolean addQueue(int x, int y, int element) {
        if (element == 1) {
            queue.add(new Vertex(x, y, true));
            visited[y][x] = true;
            return true;
        }
        return false;
    }
}

@Data
@AllArgsConstructor
class Vertex {
    private int x;
    private int y;
    private boolean visited;
}
