// Main class
package decisiontree;
import csvparser.*;
import java.util.ArrayList;

public class DecisionTree {

    public static void main(String[] args) {
        
        // First, read the CSV file and create a new Dataset.
        String csvFile = args[0];
        System.out.println(csvFile);
        
        // Creates a new dataset.
        Dataset data = new Dataset(csvFile);
        
        // Next, create the root Node of our decision tree. This Node contains the entire dataset.
        ArrayList<Point> points = data.getData();
        ArrayList<TreePoint> treePoints = new ArrayList<>();
        for (Point p : points) {
            TreePoint tp = new TreePoint(p);
            treePoints.add(tp);
        }
        Node root = new Node(treePoints);
        
        // Next, create our top-level tree.
        Tree theTree = new Tree(root);
        
        // Build the decision tree.
        theTree.build();
        
        // Finally, display the tree.
        theTree.print();
    }
}
