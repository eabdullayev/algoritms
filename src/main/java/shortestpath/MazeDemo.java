package shortestpath;


public class MazeDemo {
    public static void main(String[] args) {
        int[][] array = {
                {1,1,1,1,1,1,1},
                {1,0,0,0,0,0,1},
                {1,0,1,1,1,0,1},
                {1,0,0,0,1,0,1},
                {1,0,0,0,0,0,1},
                {1,0,0,0,0,0,1},
                {1,1,1,1,1,1,1}
        };

        new MazeSlove().sloveMaze(array, new Vertex(1,1), new Vertex(3, 3));
    }
}
