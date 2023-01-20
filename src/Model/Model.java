package Model;
import View.*;

import java.sql.Struct;
import java.util.ArrayList;

public class Model {
    int width, height, isolation, overcrowding, revive;
    Point[][] currentGrid, nextGrid;
    ArrayList<Point> cellsToDraw = new ArrayList<>();

    public Model(int width, int height) {
        this.width = width;
        this.height = height;
        currentGrid = new Point[width][height];
        //TEMPORARY
        isolation = 1;
        overcrowding = 4;
        revive = 3;

        currentGrid = createGrid();
        nextGrid = currentGrid;

        reviveCell(15, 15);
        reviveCell(16, 15);
        reviveCell(17, 15);
        reviveCell(15, 16);
        reviveCell(16, 17);

        reviveCell(20, 20);
        reviveCell(21, 20);
        reviveCell(22, 20);
    }

    //FIXA lista över alla positioner, placera celler i varje position, kunna toggla deras livs status,

    public void update() {
        nextGrid = createGrid();
        cellsToDraw.clear();
        checkGrid();
        currentGrid = nextGrid;
    }

    public void checkGrid()
    {
        for (int Y = 0; Y < height; Y++) {
            for (int X = 0; X < width; X++) {
                int neighbours = 0;
                if(currentGrid[X][Y].isAlive())
                {
                    cellsToDraw.add(currentGrid[X][Y]);
                }
                for (int checkX = -1; checkX <= 1; checkX++) {
                    for (int checkY = -1; checkY <= 1; checkY++) {
                        if(X + checkX >= 0 && X + checkX < width && Y + checkY >= 0 && Y + checkY < height)
                        {
                            if(currentGrid[X + checkX][Y + checkY].isAlive())
                            {
                                neighbours++;
                            }
                        }
                    }
                }
                if(currentGrid[X][Y].isAlive())
                {
                    neighbours--;
                    System.out.println(neighbours);
                    //neighbours = 3;
                    nextGrid[X][Y].setAlive(neighbours > isolation && neighbours < overcrowding);
                }
                else {
                    nextGrid[X][Y].setAlive(neighbours == revive);
                }
            }
        }
    }

    public Point[][] createGrid()
    {
        Point[][] p = new Point[width][height];
        for (int Y = 0; Y < height; Y++) {
            for (int X = 0; X < width; X++) {
                p[X][Y] = new Point(X, Y);
            }
        }
        return p;
    }

    public void reviveCell(int x, int y)
    {
        nextGrid[x][y].setAlive(true);
        cellsToDraw.add(nextGrid[x][y]);
    }

    public Shape[] getShapes() {
        Point[] c = new Point[cellsToDraw.size()];
        cellsToDraw.toArray(c);
        return c;
    }
}
