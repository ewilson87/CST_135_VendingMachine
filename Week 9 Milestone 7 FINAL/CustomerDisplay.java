import javafx.animation.TranslateTransition;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

public class CustomerDisplay {

    Stage window;

    public void display(ObservableList<Product> inventory) {

        //instantiates ProcessCustomerQueue and returns a LinkedList queue
        ProcessCustomerQueue customerQueue = new ProcessCustomerQueue();
        LinkedList<ProcessCustomerQueue> customerQueueLinkedList = customerQueue.readCustomerQueue();

        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Customer Queue");
        window.setResizable(false);

        //declare animations to be used
        TranslateTransition person1move1 = new TranslateTransition();
        TranslateTransition person1move2 = new TranslateTransition();
        TranslateTransition person2move1 = new TranslateTransition();

        //root pane for scene
        BorderPane rootLayout = new BorderPane();
        rootLayout.setPadding(new Insets(25, 25, 25, 25));

        //images
        Image person = new Image("image/person.png");
        Image actionPerson = new Image("image/person2.png");
        Image vendingMachine = new Image("image/vending.png");

        //ImageViews
        ImageView person1ImageView = new ImageView(person);
        person1ImageView.setFitHeight(135);
        person1ImageView.setFitWidth(135);
        ImageView person2ImageView = new ImageView(person);
        person2ImageView.setFitHeight(135);
        person2ImageView.setFitWidth(135);
        ImageView actionPersonImageView = new ImageView(actionPerson);
        actionPersonImageView.setFitHeight(175);
        actionPersonImageView.setFitWidth(175);
        ImageView vendingImageView = new ImageView(vendingMachine);
        vendingImageView.setFitHeight(175);
        vendingImageView.setFitWidth(175);

        //name labels
        Label person1Label = new Label(customerQueueLinkedList.getFirst().getCustomerName());
        Label actionPersonLabel = new Label(customerQueueLinkedList.getFirst().getCustomerName());
        Label person2Label = new Label("");
        if (customerQueueLinkedList.size() > 1) {
            person2Label.setText(customerQueueLinkedList.get(1).getCustomerName());
        }

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.appendText("Event Log");
        textArea.minHeight(600);
        textArea.minWidth(400);
        textArea.setMaxSize(200, 600);

        //button to process all customers. Button fires it's own action at the end, until the customerQueueLinkedList is empty
        Button actionButton = new Button("Process All Customers");
        actionButton.setMinWidth(200);
        actionButton.setOnAction(e -> {
            if (customerQueueLinkedList.isEmpty()) {
                //do nothing
            } else {
                person1Label.setText(customerQueueLinkedList.getFirst().getCustomerName());
                person1move1.setFromX(0);
                person1move1.setFromY(0);
                person2move1.setFromX(0);
                person2move1.setFromY(0);
                person1ImageView.setImage(person);
                if (customerQueueLinkedList.size() > 1) {
                    person2Label.setText(customerQueueLinkedList.get(1).getCustomerName());
                } else {
                    person2ImageView.setImage(null);
                    person2Label.setText(null);
                }
                person1move1.playFromStart();
                person2move1.playFromStart();
                person1move1.setOnFinished(e1 -> {
                    person1ImageView.setImage(actionPerson);
                    textArea.appendText("\n" + customerQueueLinkedList.getFirst().getCustomerName() + " Purchased: \n");
                    textArea.appendText(customerQueue.processCustomer(inventory, customerQueueLinkedList));
                    if (customerQueueLinkedList.size() == 0) {
                        textArea.appendText("\nLAST CUSTOMER PROCESSED");
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e3) {
                        AlertBox.display("","ERROR WAITING");
                    }
                    person1move2.play();
                    person1move2.setOnFinished(e3 -> actionButton.fire());
                });
            }
        });

        //button to save log file to a document
        Button saveButton = new Button("Save Log");
        saveButton.setMinWidth(200);
        saveButton.setOnAction(e -> {
            FileWriter fileWriter = null;

            try {
                fileWriter = new FileWriter("Customer Log.doc");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();

                fileWriter.append(dtf.format(now));
                fileWriter.append("\n");
                fileWriter.append(textArea.getText());
            } catch (Exception e2) {
                AlertBox.display("", "ERROR WRITING CUSTOMER LOG");
            } finally {
                try {
                    fileWriter.flush();
                    fileWriter.close();
                } catch (IOException e3) {
                    AlertBox.display("Error", "ERROR FLUSHING/CLOSING INVENTORY");
                }
            }
                AlertBox.display("Success", "CUSTOMER LOG SAVED");
            });

        //closes the window to view the inventory
        Button viewInventoryButton = new Button("View Inventory");
        viewInventoryButton.setMinWidth(200);
        viewInventoryButton.setOnAction(e -> {
            closeDisplay();
        });

            VBox person2VBox = new VBox(25);
            person2VBox.setAlignment(Pos.CENTER);
            if (customerQueueLinkedList.size() > 1) {
                person2VBox.getChildren().addAll(person2ImageView, person2Label);
            }

            VBox person1VBox = new VBox(25);
            person1VBox.setAlignment(Pos.CENTER);
            person1VBox.getChildren().addAll(person1ImageView, person1Label);

            VBox actionPersonVBox = new VBox(25);
            actionPersonVBox.setAlignment(Pos.CENTER);
            actionPersonVBox.getChildren().addAll(actionPersonImageView, actionPersonLabel);

            HBox leftHBox = new HBox(10);
            leftHBox.setAlignment(Pos.CENTER_LEFT);
            if (customerQueueLinkedList.size() > 1) {
                leftHBox.getChildren().add(person2VBox);
            }
            leftHBox.getChildren().add(person1VBox);

            VBox textVbox = new VBox(25);
            textVbox.setAlignment(Pos.CENTER);
            textVbox.getChildren().addAll(textArea, actionButton, saveButton, viewInventoryButton);
            HBox rightHBox = new HBox(25);
            rightHBox.setAlignment(Pos.CENTER_RIGHT);
            rightHBox.getChildren().addAll(vendingImageView, textVbox);

            rootLayout.setLeft(leftHBox);
            rootLayout.setRight(rightHBox);

            //sets animation sequences
            person1move1.setDuration(Duration.seconds(3));
            person1move1.setNode(person1VBox);
            person1move1.setToX(450);
            person1move1.setToY(40);

            person1move2.setDuration(Duration.seconds(3));
            person1move2.setNode(person1VBox);
            person1move2.setToY(-400);

            person2move1.setDuration(Duration.seconds(1.5));
            person2move1.setNode(person2VBox);
            person2move1.setToX(145);

            Scene scene = new Scene(rootLayout, 1200, 600);
            window.setScene(scene);
            window.showAndWait();
        }

        public void closeDisplay () {
            window.close();
        }
    }
