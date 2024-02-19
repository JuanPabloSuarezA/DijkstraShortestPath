package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author jpsa4
 * 
 */
public class Map {
    protected List<Point> points;

    public Map() {
        this.points = new ArrayList<>();
    }

    public List<Point> getPoints() {
        return points;
    }
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void resetAlgorithm() {
        for (int i = 0; i < points.size(); i++) {
            points.get(i).resetValues();
        }
    }

    public Point calcShortestRoute(Point originPoint) {

        resetAlgorithm();
        Point actualPoint = null, nextPoint;
        int newDistance, oldDistance;
        PriorityQueue<Point> neighboringPoints = new PriorityQueue<>();
        List<Road> pointRoads;
        Road actualRoad;

        originPoint.distMinPath = 0;
        neighboringPoints.add(originPoint);

        while (!neighboringPoints.isEmpty()) {

            actualPoint = neighboringPoints.poll();
            actualPoint.visited = true;
            pointRoads = actualPoint.getRoads();

            for (int i = 0; i < pointRoads.size(); i++) {
                actualRoad = pointRoads.get(i);
                nextPoint = actualRoad.getNextPoint(actualPoint);
                oldDistance = nextPoint.getDistShortestPath();

                if (nextPoint.visited) {
                    continue;
                }
                newDistance = actualPoint.distMinPath + actualRoad.weight;

                if (newDistance < oldDistance) {

                    nextPoint.distMinPath = newDistance;
                    nextPoint.setShortestPath(actualPoint.getShortestPath());
                    nextPoint.shortestPath.add(actualPoint);

                    if (oldDistance == Integer.MAX_VALUE) {
                        neighboringPoints.add(nextPoint);
                    }
                }
            }
        }
        return actualPoint;
    }

    public String showShortestDistances(Point originPoint) {
        String output = "Origin point: " + originPoint.id + "\n";
        calcShortestRoute(originPoint);

        for (int i = 0; i < points.size(); i++) {

            if (points.get(i).equals(originPoint)) {
                continue;
            }
            output += points.get(i).showShortestPath() + "\n";
        }
        return output;
    }
}
