package hclust;
import csvparser.*;
import java.util.ArrayList;
import java.lang.Math;

public class Clusterer {
    
    String csvFile;
    CSVReader reader;
    ArrayList<ClusterPoint> data;
    
    public Clusterer(ArrayList<ClusterPoint> points) {
        this.data = points;
    }
    
    public ArrayList<ClusterPoint> getData() {
        return data;
    }
    
    public void printData() {
        for (ClusterPoint p : data) {
            p.printPoint();
        }
    }
    
    // Finds the distance between two points a and b.
    public double getDistance(ClusterPoint a, ClusterPoint b) {
        int dx, dy;
        double distance;
        
        dx = Math.abs(a.getX() - b.getX());
        dy = Math.abs(a.getY() - b.getY());
        
        distance = Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
        
        return distance;
    }
    
    // Produces a point that is the average of two points a and b.
    public ClusterPoint merge(ClusterPoint a, ClusterPoint b) {
        int px, py;
        ClusterPoint p;
        
        px = ((a.getX() + b.getX()) / 2);
        py = ((a.getY() + b.getY()) / 2);
        
        p = new ClusterPoint(px, py);
        
        return p;
    }
    
    // Finds the closest point in the dataset to a given point
    public ClusterPoint findClosest(ClusterPoint a) {
        ClusterPoint closestPoint = a;
        double currentDistance;
        double shortestDistance = 1000;
        
        for (ClusterPoint p : data) {
            currentDistance = getDistance(a, p);
            if (currentDistance < shortestDistance && a != p) {
                shortestDistance = currentDistance;
                closestPoint = p;
            }
        }
        return closestPoint;
    }
    
    // Finds the pair of points in the dataset that are the closest
    public ClusterPoint[] findClosestPair() {
        ClusterPoint[] pair = new ClusterPoint[2];
        ClusterPoint closestPoint;
        double currentDistance;
        double shortestDistance = 1000;
        
        for (ClusterPoint p : data) {
            closestPoint = findClosest(p);
            currentDistance = getDistance(p, closestPoint);
            if (currentDistance < shortestDistance && p != closestPoint) {
                shortestDistance = currentDistance;
                pair[0] = p;
                pair[1] = closestPoint;
            }
        }
        
        return pair;
    }
    
    // Produces a tree structure corresponding to an Agglomerative Hierarchal clustering of the dataset.
    public void HClust() {
        
        ClusterPoint[] closestPair;
        ClusterPoint newPoint;
        int numPoints = data.size();
        
        while (numPoints > 1) {
            closestPair = findClosestPair();
            newPoint = merge(closestPair[0], closestPair[1]);
            data.remove(closestPair[0]);
            data.remove(closestPair[1]);
            data.add(newPoint);
            numPoints = data.size();
            
            System.out.println("New iteration!");
            printData();
        }
        
        System.out.println("Done!");
    }
}
