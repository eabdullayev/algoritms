package qt;

import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Boundary inital = new Boundary(100, 100, 100, 100);
        QuadTree qTree = new QuadTree(null, inital, 4, null);

        for(int i = 0; i < 100; i++){
            qTree.insert(new Point(i, i));
        }

        Boundary range = new Boundary(120, 120, 50, 50);
        System.out.println(qTree.queryRange(range));
    }
}
