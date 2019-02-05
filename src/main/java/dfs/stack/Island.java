package dfs.stack;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Island {

    boolean[][] visited;
    private int[] row = new int[]{-1, 0, 0, 1};
    private int[] col = new int[]{0, -1, 1, 0};

    private Stack<Vertex> stack = new Stack<>();

    public int findIlands(int[][] array) {
        visited = new boolean[array.length][array[0].length];
        //key: area, value: count
        Map<Integer, Integer> groups = new HashMap<>();
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[0].length; x++) {
                if (array[y][x] == 1 && !visited[y][x]) {
                    visited[y][x] = true;
                    stack.push(new Vertex(x, y));
                    int area = dfs(array);

                    groups.put(area, ((groups.containsKey(area))? groups.get(area)+1 : 1));
                }
            }
        }
        System.out.println(groups);
        return groups.size();
    }

    private int dfs(int[][] array) {
        int area = 1;
        while (!stack.empty()) {
            Vertex vertex = stack.pop();
            int x = vertex.getX();
            int y = vertex.getY();
            for (int i = 0; i < row.length; i++) {
                int relativeY = y + row[i];
                int relativeX = x + col[i];
                if(relativeY >= 0 && relativeY < array.length &&
                        relativeX >= 0 && relativeX < array[0].length){
                    if(!visited[relativeY][relativeX] && array[relativeY][relativeX] == 1){
                        visited[relativeY][relativeX] = true;
                        stack.push(new Vertex(relativeX, relativeY));
                        area ++;
                    }
                }
            }
        }
        return area;
    }
}
@Data
@AllArgsConstructor
class Vertex{
    private int x;
    private int y;
}
