package csvparser;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    
    public CSVReader() {
    }
    
    public ArrayList<Point> readCSV(String csvFile) {
        
        BufferedReader br = null;
        String line;
        String csvSplitBy = ",";
        int numDimensions = 0;
        
        ArrayList<Point> data = new ArrayList();
        Point currentPoint;
        
        try {
            FileReader fr = new FileReader(csvFile);
            br = new BufferedReader(fr);
            br.mark(1000);
            
            if ((line = br.readLine()) != null) {
                numDimensions = line.replaceAll("[^,]","").length() + 1;
            }
            
            br.reset();
            
            while ((line = br.readLine()) != null) {
                
                ArrayList<String> values = new ArrayList();
                
                for (int i = 0; i < numDimensions; i++) {
                    String x = line.split(csvSplitBy)[i];
                    values.add(x);
                }
                
                currentPoint = new Point(values, numDimensions);
                data.add(currentPoint);
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return data;
    }       
}
