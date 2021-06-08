package hclust;
import csvparser.*;
public class ClusterPoint {
    
    int x, y;
    
    public ClusterPoint(Point p) {
        this.x = Integer.parseInt(p.getIndex(0));
        this.y = Integer.parseInt(p.getIndex(1));
    }
    
    public ClusterPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void printPoint() {
        System.out.println(x + ", " + y);
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
}
