package qt;

import java.util.List;

// Axis-aligned bounding box with half dimension and center
public class Boundary {
    private double x;
    private double y;
    private double w;
    private double h;

    public Boundary(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public boolean isPointBelong(Point point) {
        return (point.getX() >= this.x - this.w &&
                point.getX() <= this.x + this.w &&
                point.getY() >= this.y - this.h &&
                point.getY() <= this.y + this.h);
    }

    public boolean intersectWith(Boundary range) {
        return !(range.x - range.w > this.x + this.w ||
                range.x + range.w < this.x - this.w ||
                range.y - range.h > this.y + this.h ||
                range.y + range.h < this.y - this.h);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getW() {
        return w;
    }

    public void setW(double w) {
        this.w = w;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }
}
