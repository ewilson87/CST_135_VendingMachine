import javafx.collections.ObservableList;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class CsvWriter {

    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    //CSV file header
    private static final String FILE_HEADER = "Name,Price,Quantity,ProductID";

    public static void writeCsvFile(ObservableList<Product> inventory) {
        FileWriter fileWriter = null;

        try {
            //deletes existing inventory file before writing new contents
            try {
                File file = new File("Blue Group Inventory.csv");
                file.delete();
            } catch (Exception e) {
            }

            fileWriter = new FileWriter("Blue Group Inventory.csv");

            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());

            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);

            //Write a new product object list to the CSV file
            for (Product product : inventory) {
                fileWriter.append(String.valueOf(product.getName()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(product.getPrice()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(product.getQuantity()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(product.getProductID()));
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
        } catch (Exception e) {
            AlertBox.display("Error", "ERROR WRITING INVENTORY FILE");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                AlertBox.display("Error", "ERROR FLUSHING/CLOSING INVENTORY");
            }
        }
    }
}
