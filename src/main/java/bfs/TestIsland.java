package bfs;

public class TestIsland {
    public static void main(String[] args) {
        int[][] array = {
                {1,1,0,0,0,1},
                {0,0,0,0,0,1},
                {0,0,0,0,0,0},
                {0,0,0,0,0,0},
                {0,1,1,0,0,0},
                {0,1,1,0,0,0},
                {0,0,0,1,0,0}
        };

        System.out.println(new Island().findIlands(array));
    }
}
