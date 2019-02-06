package dfs.findpath;

public class MazeDemo {
    public static void main(String[] args) {
        int[][] array = {
                {1,1,1,1,1,1,1},
                {1,2,0,0,0,0,1},
                {1,1,1,1,1,0,1},
                {1,0,0,0,1,0,1},
                {1,0,0,0,1,0,1},
                {1,0,0,0,1,3,1},
                {1,1,1,1,1,1,1}
        };

        new MazeSloving().sloveMaze(array);
    }
}
