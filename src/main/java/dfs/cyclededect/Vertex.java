package dfs.cyclededect;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@RequiredArgsConstructor()
public class Vertex {

    private boolean isVisited;
    private boolean beingVisited;
    @NonNull private String data;
    private List<Vertex> adjacenciesList = new ArrayList<>();

    public Vertex addVertex(Vertex vertex) {
        this.getAdjacenciesList().add(vertex);
        return this;
    }
}
