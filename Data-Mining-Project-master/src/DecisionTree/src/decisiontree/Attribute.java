package decisiontree;

// Attribute class. Type is either "number" or "category".
public class Attribute {
    
    int id;
    String type;
    
    public Attribute(int x, String t) {
        this.id = x;
        this.type = t;
    }
    
    public int getID() {
        return this.id;
    }
    
    public String getType() {
        return this.type;
    }
}
