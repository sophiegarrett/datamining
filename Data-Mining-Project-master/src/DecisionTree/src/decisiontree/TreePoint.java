package decisiontree;
import csvparser.*;
import java.util.ArrayList;

public class TreePoint {
    
    int numAttributes;
    Attribute[] attributes;
    ArrayList<String> values;
    int type;
    
    public TreePoint(Point p) {
        this.numAttributes = p.getDimensions() - 1;
        this.attributes = new Attribute[this.numAttributes];
        this.values = new ArrayList<>();
        for (int i = 0; i < this.numAttributes; i++) {
            this.values.add(p.getIndex(i));
            attributes[i] = new Attribute(i, "number");
        }
        this.type = Integer.parseInt(p.getIndex(this.numAttributes));
    }
    
    public void printTreePoint() {
        for (String y : this.values) {
            System.out.print(y + " ");
        }
        System.out.print("Class: " + this.type);
        System.out.println("");
    }
    
    public int getNumAttributes() {
        return numAttributes;
    }
    
    public ArrayList<String> getValues() {
        return this.values;
    }
    
    public int getType() {
        return this.type;
    }
    
    public String getIndex (int index) {
        String x = this.values.get(index);
        return x;
    }
    
    public Attribute getAttribute(int x) {
        return attributes[x];
    }
}
