package csvparser;
import java.util.ArrayList;

public class Dataset {
    
    String csvFile;
    CSVReader reader;
    ArrayList<Point> data;
    
    public Dataset(String csv) {
        reader = new CSVReader();
        this.csvFile = csv;
        data = new ArrayList();
        data = reader.readCSV(csvFile);
    }
    
    public ArrayList<Point> getData() {
        return data;
    }
    
    public void printData() {
        for (Point p : data) {
            p.printPoint();
        }
    }
}
