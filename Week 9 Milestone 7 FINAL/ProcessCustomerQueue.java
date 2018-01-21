import javafx.collections.ObservableList;
import java.io.File;
import java.util.*;

public class ProcessCustomerQueue {

    private String customerName;
    private String productName;
    private String productType;
    private static Scanner sc;
    //Since Queue is abstract, using LinkedList since LinkedList implements Queue
    LinkedList<ProcessCustomerQueue> customerQueue = new LinkedList<>();

    public void createCustomer(String customerName, String productName, String productType) {
        this.customerName = customerName;
        this.productName = productName;
        this.productType = productType;
    }

    public LinkedList<ProcessCustomerQueue> readCustomerQueue() {
        //name of file where Customer Queue is saved
        String customerQueueFile = "Customer Queue.csv";

        try {
            sc = new Scanner(new File(customerQueueFile));
            sc.useDelimiter("[,\n]");

            //skips header line
            String header = sc.nextLine();

            while (sc.hasNextLine()) {
                String nextLine = sc.nextLine();
                String[] lineArray = nextLine.split(",");
                String customerName = lineArray[0];
                String productName = lineArray[1];
                String productType = lineArray[2];

                ProcessCustomerQueue customer = new ProcessCustomerQueue();
                customer.createCustomer(customerName, productName, productType);
                customerQueue.offer(customer);
            }
        } catch (Exception e) {
            AlertBox.display("", "ERROR READING CUSTOMER QUEUE");
        }
        return customerQueue;
    }

    public String processCustomer(ObservableList<Product> productObservableList, LinkedList<ProcessCustomerQueue> customerQueueLinkedList) {
        RecursiveSearch recursiveSearch = new RecursiveSearch();
        CsvWriter csvWriter = new CsvWriter();
        Random random = new Random();
        String textArea;

        int i;
        //searches inventory for what customer wants, if not available will assign a new available item of same type for customer
        if (recursiveSearch.recursiveSearch(productObservableList, customerQueueLinkedList.getFirst().productName) == -1
                || productObservableList.get(recursiveSearch.recursiveSearch(productObservableList, customerQueueLinkedList.getFirst().productName))
                .getQuantity() == 0) {
            i = random.nextInt(productObservableList.size());
            String productType = customerQueueLinkedList.getFirst().productType;
            while (productObservableList.get(i).getQuantity() == 0 ||
                    !productType.equalsIgnoreCase(productObservableList.get(i).productID.substring(0, productObservableList.get(i).productID.length() - 1))) {
                i = random.nextInt(productObservableList.size());
            }
            textArea = customerQueueLinkedList.getFirst().productName + " not available!" + "\nNew Product: " + productObservableList.get(i).getName() + " Price: " + productObservableList.get(i).getPrice();
            productObservableList.get(i).changeQuantity(-1);
        }

        //when search of inventory matches what customer wants, process sale of that product
        else {
            textArea = "Product: " + productObservableList.get(recursiveSearch.recursiveSearch(productObservableList,
                    customerQueueLinkedList.getFirst().productName)).getName() + " Price: " +
                    productObservableList.get(recursiveSearch.recursiveSearch(productObservableList,
                            customerQueueLinkedList.getFirst().productName)).getPrice();
            productObservableList.get(recursiveSearch.recursiveSearch(productObservableList, customerQueueLinkedList.getFirst().productName))
                    .changeQuantity(-1);
        }

        //removes first customer after being processed
        customerQueueLinkedList.poll();

        //writes to inventory file after dispensing item for each customer
        csvWriter.writeCsvFile(productObservableList);

        //returns String data to use in textArea log
        return textArea;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-10s", customerName, productName);
    }
}
