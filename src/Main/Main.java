package Main;

import Model.Road;
import Model.Point;
import Model.Map;
import java.io.IOException;
/**
 * @author jpsa4
 * Dijkstra Algorithm Implementation with OOP
 */
public class Main {

    public static void main(String[] args) throws IOException {

        //Test Case 
        Map map = new Map();
        
        Point point1 = new Point(1), point2 = new Point(2), point3 = new Point(3),
              point4 = new Point(4), point5 = new Point(5), point6 = new Point(6);
        Road road;

        road = new Road(1, point1, point2, 4);
        point1.addRoad(road);
        point2.addRoad(road);

        road = new Road(2, point1, point3, 2);
        point1.addRoad(road);
        point3.addRoad(road);

        road = new Road(3, point2, point3, 1);
        point2.addRoad(road);
        point3.addRoad(road);

        road = new Road(4, point2, point4, 5);
        point2.addRoad(road);
        point4.addRoad(road);

        road = new Road(5, point4, point3, 8);
        point4.addRoad(road);
        point3.addRoad(road);

        road = new Road(6, point3, point5, 10);
        point3.addRoad(road);
        point5.addRoad(road);

        road = new Road(7, point4, point5, 2);
        point4.addRoad(road);
        point5.addRoad(road);

        road = new Road(8, point4, point6, 6);
        point4.addRoad(road);
        point6.addRoad(road);

        road = new Road(9, point5, point6, 3);
        point5.addRoad(road);
        point6.addRoad(road);

        map.addPoint(point1);
        map.addPoint(point2);
        map.addPoint(point3);
        map.addPoint(point4);
        map.addPoint(point5);
        map.addPoint(point6);

        System.out.println("Test case: ");
        System.out.println(map.showShortestDistances(point1));
    }
}
