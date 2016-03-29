package model;

/**
 * Created by mitulmanish on 26/03/2016.
 */
public class Point {

    private int xCoordinate;
    private int yCoordinate;

    public Point(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public boolean equals(Point point){
        return ((point.getxCoordinate() == xCoordinate) && (point.getyCoordinate() == yCoordinate));
    }

    public String toString(){
         return new String("("+xCoordinate+", "+yCoordinate+")");
    }

}
