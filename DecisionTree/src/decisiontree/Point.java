package decisiontree;
import java.util.ArrayList;

public class Point {
    
    int numDimensions;
    ArrayList<Double> values;
    int type;
    
    public Point(ArrayList<Double> list, int x) {
        values = new ArrayList();
        this.numDimensions = x - 1;
        for (int i = 0; i < this.numDimensions; i++) {
            this.values.add(list.get(i));
        }
        this.type = list.get(this.numDimensions).intValue();
    }
    
    public void printPoint() {
        for (double y : this.values) {
            System.out.print(y + " ");
        }
        System.out.print("Class: " + this.type);
        System.out.println("");
    }
    
    public int getDimensions() {
        return numDimensions;
    }
    
    public double getIndex(int index) {
        double x = this.values.get(index);
        return x;
    }
    
    public ArrayList<Double> getValues() {
        return this.values;
    }
    
    public int getType() {
        return type;
    }
}
