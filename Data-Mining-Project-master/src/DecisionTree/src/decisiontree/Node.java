package decisiontree;
import csvparser.*;
import java.util.ArrayList;
import java.lang.Math;

// Node class.
// A Node contains an array list of Points, a number of attributes, and a number of classes.
public class Node {
    
    ArrayList<TreePoint> data;
    int numAttributes;
    int numClasses;
    
    public Node(ArrayList<TreePoint> points) {
        this.data = points;
        this.numAttributes = points.get(0).getNumAttributes();
        this.numClasses = 2;
    }
    
    public ArrayList<TreePoint> getData() {
        return this.data;
    }
    
    public void printNode() {
        System.out.println(numAttributes);
        for (TreePoint p : data) {
            p.printTreePoint();
        }
        System.out.println("Entropy: " + entropy(this.data));
        System.out.println("Information Gain: " + infoGain(0));
    }
    
    // Splits a data set according to the values of a given attribute.
    // The attribute is delineated by an integer from 0-5. 0 represents the first attribute, 1 represents the second, etc.
    // Returns two new array lists of data points.
    public ArrayList<TreePoint>[] splitData(ArrayList<TreePoint> set, int attribute, double value) {
        ArrayList<TreePoint>[] splitData = new ArrayList[2];
        for (TreePoint p : set) {
            if (p.getAttribute(attribute).getType().equals("number")) {
                double x = Double.parseDouble(p.getIndex(attribute));
                if (x <= value) {
                    splitData[0].add(p);
                }
                else {
                    splitData[1].add(p);
                }
            }
            else {
                
            }
        }
        return splitData;
    }
    
    // Calculates the information gain for a given attribute.
    // The attribute is delineated by an integer from 0-5. 0 represents the first attribute, 1 represents the second, etc.
    public double infoGain(int attribute) {
        // Start with the initial entropy of the data set.
        double infoGain = entropy(this.data);
        
        
        
        return infoGain;
    }
    
    // Calculates the entropy of a data set.
    public double entropy(ArrayList<TreePoint> set) {
        // classCounts = the number of points that belong to each class.
        // classCounts[0] represents class 1 and classCounts[1] represents class 2.
        double[] classCounts = new double[this.numClasses];
        for (TreePoint p : set) {
            int type = p.getType();
            classCounts[type-1]++;
        }
        double entropy = 0;
        // For each class:
        for (int i = 0; i < this.numClasses; i++) {
            // If there is at least one data point in that class:
            if (classCounts[i] > 0) {
                // p = the proportion of the number of elements in the class to the total number of data points
                double p = classCounts[i] / set.size();
                // x = p * log_2(p)
                double x = p * log2(p);
                // subtract x from the total entropy value
                entropy -= x;
            }
        }
        return entropy;
    }
    
    // Calculates the base-2 logarithm of a number.
    public double log2(double x) {
        return Math.log(x) / Math.log(2);
    }
    
    public boolean isLeaf() {
        return true;
    }
}
