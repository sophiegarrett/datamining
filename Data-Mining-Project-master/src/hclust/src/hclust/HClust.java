package hclust;
import csvparser.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class HClust {
    
    public static void main(String[] args) {
        
        // First, read the CSV file and create a new Dataset.
        String csvFile = "data\\Mall_customers_edit_csv.csv";
        System.out.println(csvFile);
        
        // Creates a new dataset.
        Dataset data = new Dataset(csvFile);
        data.printData();
        
        // Convert all data points to ClusterPoints.
        ArrayList<ClusterPoint> points = new ArrayList<>();
        for (Point p : data.getData()) {
            ClusterPoint cp = new ClusterPoint(p);
            points.add(cp);
        }
        
        Clusterer clusterer = new Clusterer(points);
        
        clusterer.printData();
        
        clusterer.HClust();
    }
}
