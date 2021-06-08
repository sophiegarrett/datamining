package csvparser;
import java.util.ArrayList;

public class Point {
    
    int numDimensions;
    ArrayList<String> values;
    
    public Point(ArrayList<String> list, int x) {
        values = new ArrayList();
        this.numDimensions = x;
        for (int i = 0; i < this.numDimensions; i++) {
            this.values.add(list.get(i));
        }
    }
    
    public void printPoint() {
        for (String y : this.values) {
            System.out.print(y + " ");
        }
        System.out.println("");
    }
    
    public int getDimensions() {
        return numDimensions;
    }
    
    public String getIndex(int index) {
        String x = this.values.get(index);
        return x;
    }
    
    public ArrayList<String> getValues() {
        return this.values;
    }
}
