package apriori;
import csvparser.*;

public class Apriori {

    public static void main(String[] args) {
        
        // First, read the CSV file and create a new Dataset.
        String csvFile = args[0];
        System.out.println(csvFile);
        
        // Creates a new dataset.
        Dataset data = new Dataset(csvFile);
        data.printData();
    }
    
}
