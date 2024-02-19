
package Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author jpsa4
 */
public class Point implements Comparable {

    protected int id;
    private List<Road> roads; //Links to other points 
    protected Queue<Point> shortestPath; //Contains the points which make the road
    protected int distMinPath;
    protected Boolean visited;

    public Point(int id) {
        this.id = id;
        this.roads = new ArrayList<>();
        this.shortestPath = new LinkedList<>();
        this.distMinPath = Integer.MAX_VALUE;
        this.visited = false;
    }


    public int getDistShortestPath() {
        return distMinPath;
    }

    public void setDistShortestPath(int distMinPath) {
        this.distMinPath = distMinPath;
    }

    public Queue<Point> getShortestPath() {
        return shortestPath;
    }

    public void setShortestPath(Queue<Point> shortestPath) {
        this.shortestPath = new LinkedList<>(shortestPath);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void addRoad(Road road) {
        roads.add(road);
    }

    public void deleteRoad(int idRoad) {
        for (int i = 0; i < roads.size(); i++) {
            Road road = roads.get(i);
            if (road.id == idRoad) { 
                Point nextPoint = road.getNextPoint(this);
                nextPoint.roads.remove(road);
                this.roads.remove(road);
            }
        }
    }

    public String showShortestPath() {
        String cad;
        if (distMinPath == 0) {
            return "Origin point: " + this.id;
        }
        if (distMinPath == Integer.MAX_VALUE) {
            cad = "There's no road to the point " + this.id;
        } else {
            cad = "Total distance to the point " + this.id + ": " 
                    + distMinPath + "(";
            while (!shortestPath.isEmpty()) {
                cad += shortestPath.poll().id + ", ";
            }
            cad += this.id + ")";
        }
        return cad;
    }

    public void resetValues() {
        this.shortestPath = new LinkedList<>();
        this.distMinPath = Integer.MAX_VALUE;
        this.visited = false;
    }

    @Override
    public int compareTo(Object o) {
        Point second = (Point) o;

        if (this.distMinPath == second.distMinPath) {
            return 0;
        } else if (this.distMinPath > second.distMinPath) {
            return 1;
        } else {
            return -1;
        }
    }
}
