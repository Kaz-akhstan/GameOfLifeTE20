package Model;
import View.*;

import java.util.ArrayList;

public class Model {
    int width, height, isolation, overcrowding;
    Point[] currentCells;
    public Model(int width, int height) {
        currentCells = setCells();
        this.width = width;
        this.height = height;
        isolation = 1;
        overcrowding = 4;
    }

    //FIXA lista över alla positioner, placera celler i varje position, kunna toggla deras livs status,

    public void update() {
        Point[] cells = (Point[])getShapes();
        checkNeighbours(cells);
    }

    public void checkNeighbours(Point[] cells)
    {
        for (int i = 0; i < cells.length; i++) {
            //cells[i].setX(cells[i].getX() + 1);
            int count = 0;
            for (int Y = -1; Y < 1; Y++) {
                for (int X = -1; X < 1; X++) {
                    for (int j = 0; j < cells.length; j++) {
                        if(cells[i].getX() + X == cells[j].getX() && cells[i].getY() + Y == cells[j].getY())
                            if(X != 0 && Y != 0)
                            {
                                count++;
                            }
                    }
                }
            }
            if(count > isolation && count < overcrowding)
            {

            }
            else {

            }
        }
    }

    public void toggleStatus(Point cell)
    {
        cell.setAlive(!cell.isAlive());
    }

    public Point[] setCells()
    {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(5,5));
        points.add(new Point(6,5));
        points.add(new Point(7,5));
        points.add(new Point(5,6));
        points.add(new Point(6,7));
        Point[] p = new Point[points.size()];
        points.toArray(p);
        return p;
    }

    public Shape[] getShapes() {
        return currentCells;
    }
}
