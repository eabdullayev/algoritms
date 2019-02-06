package dfs.cyclededect;

import java.util.ArrayList;
import java.util.List;

public class CDDemo {
    public static void main(String[] args) {
        Vertex a = new Vertex("a");
        Vertex b = new Vertex("b");
        Vertex c = new Vertex("c");
        Vertex d = new Vertex("d");
        Vertex e = new Vertex("e");
        Vertex f = new Vertex("f");
        Vertex g = new Vertex("g");

        a.addVertex(b).addVertex(c);
        b.addVertex(f);
        c.addVertex(d).addVertex(e);
        d.addVertex(g).addVertex(c);

        List<Vertex> vertices = new ArrayList<>();
        vertices.add(a);

        new CycyleDedect().dedectCycle(vertices);
    }
}
