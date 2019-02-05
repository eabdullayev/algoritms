package dfs.recursion;

import java.util.HashMap;
import java.util.Map;

public class Island {

    boolean[][] visited;
    private int[] row = new int[]{-1, 0, 0, 1};
    private int[] col = new int[]{0, -1, 1, 0};

    public int findIlands(int[][] array) {
        visited = new boolean[array.length][array[0].length];
        //key: area, value: count
        Map<Integer, Integer> groups = new HashMap<>();
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[0].length; x++) {
                if(array[y][x] == 1 && !visited[y][x]){
                    visited[y][x] = true;

                    int area = dfs(x, y, array);

                    groups.put(area, ((groups.containsKey(area))? groups.get(area)+1 : 1));
                }
            }
        }
        System.out.println(groups);
        return groups.size();
    }

    private int dfs(int x, int y, int[][] array){
        int area = 1;
        for(int i = 0; i < row.length; i++){
            int relativeY = y + row[i];
            int relativeX = x + col[i];
            if(relativeY >= 0 && relativeY < array.length &&
            relativeX >= 0 && relativeX < array[0].length){
                if(!visited[relativeY][relativeX]){
                    if(array[relativeY][relativeX] == 1) {
                        visited[relativeY][relativeX] = true;
                        area += dfs(relativeX, relativeY, array);
                    }
                }
            }
        }
        return area;
    }
}
