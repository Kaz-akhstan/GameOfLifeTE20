package Model;
import View.*;

import java.util.ArrayList;

public class Model {
    int width, height;
    private World world;
    public Model(int width, int height) {
        this.width = width;
        this.height = height;
        world = new World(width, height);
    }

    public void update() {
        Shape[] cells = getShapes();
    }

    public Shape[] getShapes() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(5,5));
        points.add(new Point(6,5));
        points.add(new Point(7,5));
        Point[] p = new Point[points.size()];
        points.toArray(p);
        return (Shape[])p;
    }
}
