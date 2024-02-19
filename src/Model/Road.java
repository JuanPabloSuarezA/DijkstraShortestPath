package Model;

/**
 *
 * @author jpsa4
 */
public class Road {

    protected int id;
    private Point point1, point2;
    protected int weight; //Distance between two points

    public Road(int id, Point point1, Point point2, int weight) {
        this.point1 = point1;
        this.point2 = point2;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Point getNextPoint(Point point) {
        if (point.equals(point1)) {
            return point2;
        }
        return point1;
    }
}
