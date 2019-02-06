package dfs.findpath;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class MazeSloving {
    private int startY, startX;
    private int endY, endX;

    private boolean start, end;
    private boolean[][] visited;

    private Vertex root;

    public void sloveMaze(int[][] array) {
        visited = new boolean[array.length][array[0].length];
        for (int y = 0; y < array.length; y++) {
            for (int x = 0; x < array[0].length; x++) {
                if (array[y][x] == 2) {
                    startY = y;
                    startX = x;
                    start = true;
                } else if (array[y][x] == 3) {
                    endY = y;
                    endX = x;
                    end = true;
                }
                if (start && end) {
                    break;
                }
            }
        }

        root = dfs(startY, startX, array);
        if (root == null) {
            System.out.println("no path found");
        }else{
            System.out.print("Coordinates[y:x]: ");
            do{
                System.out.print("[" + root.getY() + ":" + root.getX() + "]");
                root = root.getNext();
            }while (root.getNext() != null);
            System.out.print("[" + root.getY() + ":" + root.getX() + "]");
        }
    }

    private Vertex dfs(int y, int x, int[][] array) {
        if (visited[y][x]) {
            return null;
        }

        visited[y][x] = true;

        if (y < 0 || y >= array.length) {
            return null;
        }
        if (x < 0 || x >= array[0].length) {
            return null;
        }
        if (array[y][x] == 1) {
            return null;
        }
        if (array[y][x] == 3) {
            return new Vertex(x, y);
        }
        Vertex v = new Vertex(x, y);
        Vertex res1 = dfs(y,x-1, array);
        Vertex res2 = dfs(y - 1, x, array);
        Vertex res3 = dfs(y, x + 1, array);
        Vertex res4 = dfs(y + 1, x, array);
        if (res1 != null) {
            v.setNext(res1);
            return v;
        } else if (res2 != null) {
            v.setNext(res2);
            return v;
        } else if (res3 != null) {
            v.setNext(res3);
            return v;
        } else if (res4 != null) {
            v.setNext(res4);
            return v;
        }
        return null;
    }
}

@Data
@RequiredArgsConstructor
class Vertex{
    @NonNull private int x;
    @NonNull private int y;
    private Vertex next;
}
