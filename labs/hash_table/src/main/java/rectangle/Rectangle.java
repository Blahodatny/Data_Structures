package rectangle;

import java.awt.geom.Point2D;

public class Rectangle {
    private Point2D.Double vertex1;
    private Point2D.Double vertex2;
    private int hash;

    public Rectangle(Point2D.Double vertex1, Point2D.Double vertex2) {
        if (vertex1.distance(vertex2) == 0) throw new Error("The coordinates of vertices are equal.");
        if (vertex1.x == vertex2.x || vertex1.y == vertex2.y) throw new Error("Unable to build a rectangle.");

        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.hash = this.hashCode();
    }

    public int hashCode() {
        return hash == 0 ? 31 * vertex1.hashCode() * vertex2.hashCode() : hash;
    }

    public String toString() {
        return String.format("%d | ver1(%g, %g), ver2(%g, %g)", hash, vertex1.getX(), vertex1.getY(),
                vertex2.getX(), vertex2.getY());
    }

    public boolean equals(Rectangle rectangle) {
        return rectangle != null && vertex1.equals(rectangle.vertex1) &&
                vertex2.equals(rectangle.vertex2) &&
                hashCode() == rectangle.hashCode();
    }
}