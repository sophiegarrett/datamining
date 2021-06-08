package decisiontree;
import java.util.ArrayList;

// Tree class.
// A Tree contains one Node and either zero or two sub-trees (referred to as "children").
public class Tree {
    
    ArrayList<Tree> children;
    Node node;
    
    public Tree(Node n) {
        this.node = n;
        children = new ArrayList<>();
    }
    
    // Builds the tree.
    public void build() {
        
    }
    
    // Prints the tree.
    public void print() {
        node.printNode();
        for (Tree child : children) {
            child.print();
        }
    }
    
}
