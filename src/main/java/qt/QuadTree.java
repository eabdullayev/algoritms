package qt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QuadTree {
    private final int LIMIT;

    private Boundary boundary;
    private List<Point> points;
    private boolean divided;

    private QuadTree parent, ne, nw, se, sw;

    public QuadTree(QuadTree parent, Boundary boundary, int limit, List<Point> initialPoints) {
        this.parent = parent;
        this.LIMIT = limit;
        this.boundary = boundary;
        this.points = new ArrayList<>(limit / 2);
        if (initialPoints != null && !initialPoints.isEmpty())
            insertAll(initialPoints);
    }

    public void insertAll(List<Point> points) {
        points.stream()
                .forEach(point -> insert(point));
    }

    public boolean insert(Point point) {
        if (!boundary.isPointBelong(point)) {
            return false;
        }
        if (points.size() < LIMIT && !divided) {
            points.add(point);
            return true;
        }

        if (!divided) {
            subdivide();
        }

        if (ne.insert(point) ||
                nw.insert(point) ||
                se.insert(point) ||
                sw.insert(point)) {
            return true;
        }
        return false;
    }

    private void subdivide() {
        double x = this.boundary.getX();
        double y = this.boundary.getY();
        double w = this.boundary.getW() / 2;
        double h = this.boundary.getH() / 2;

        Boundary neBoundary = new Boundary(x + w, y - h, w, h);
        this.ne = new QuadTree(this, neBoundary, LIMIT, this.points);
        Boundary nwBoundary = new Boundary(x - w, y - h, w, h);
        this.nw = new QuadTree(this, nwBoundary, LIMIT, this.points);
        Boundary seBoundary = new Boundary(x + w, y + h, w, h);
        this.se = new QuadTree(this, seBoundary, LIMIT, this.points);
        Boundary swBoundary = new Boundary(x - w, y + h, w, h);
        this.sw = new QuadTree(this, swBoundary, LIMIT, this.points);
        this.points = Collections.EMPTY_LIST;
        this.divided = true;
    }

    public List<Point> queryRange(final Boundary range) {
        List<Point> resultPoints = new ArrayList<>();

        if (!boundary.intersectWith(range)) {
            return resultPoints;
        }

        if (divided) {
            resultPoints.addAll(ne.queryRange(range));
            resultPoints.addAll(nw.queryRange(range));
            resultPoints.addAll(se.queryRange(range));
            resultPoints.addAll(sw.queryRange(range));
            return resultPoints;
        }else {
            return this.points.stream()
                    .filter(point -> range.isPointBelong(point))
                    .collect(Collectors.toList());
        }
    }
}
