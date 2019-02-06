package dfs.cyclededect;

import java.util.List;

public class CycyleDedect {
    public void dedectCycle(List<Vertex> vertices) {
        for (Vertex vertex : vertices) {
            dfs(vertex);
        }
    }

    private void dfs(Vertex vertex) {
        System.out.print(vertex.getData() + " ");

        vertex.setVisited(false);
        vertex.setBeingVisited(true);

        for (Vertex v : vertex.getAdjacenciesList()) {
            if(v.isBeingVisited()){
                System.out.println("Cycle dedected in vertex: " + v.getData());
                return;
            }
            if(!v.isVisited()){
                dfs(v);
            }
        }

        vertex.setVisited(true);
        vertex.setBeingVisited(false);
    }
}


