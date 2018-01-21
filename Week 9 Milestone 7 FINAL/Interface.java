import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Interface extends Application {

    //declaring variables needed for entire class
    TableView<Drink> drinkTableView;
    TableView<Chips> chipsTableView;
    TableView<Candy> candyTableView;
    TableView<Gum> gumTableView;
    TableView<Product> checkoutTableView;
    TableView<Product> inventoryTableView;
    ObservableList<Product> checkoutObservableList = FXCollections.observableArrayList();
    ObservableList<Product> globalInventoryObservableList = FXCollections.observableArrayList();
    Button payButton;
    BorderPane checkoutBottom = new BorderPane();
    HBox totalBox = new HBox(25);

    ImageView changingImageView2;
    Button addDrinksButton;
    Button addChipsButton;
    Button addCandyButton;
    Button addGumButton;

    //declare animations to be used from multiple scenes
    TranslateTransition translate = new TranslateTransition();
    ScaleTransition scaleTransition = new ScaleTransition();

    //declare stack panes for Animations
    StackPane drinksStack = new StackPane();
    StackPane chipsStack = new StackPane();
    StackPane gumStack = new StackPane();
    StackPane candyStack = new StackPane();

    Dispenser dispenser;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        dispenser = new Dispenser();

        //testing code
        GLOBAL_INVENTORY_MANAGEMENT globalInventoryManagement = new GLOBAL_INVENTORY_MANAGEMENT();
        globalInventoryObservableList = globalInventoryManagement.GlobalInventoryManagement();

        //declare scenes
        Scene home, drinksScene, chipsScene, candyScene, gumScene, checkoutScene, inventoryScene;

        //creates root layout for all scenes
        BorderPane homeRoot = new BorderPane();
        BorderPane drinkRoot = new BorderPane();
        BorderPane chipsRoot = new BorderPane();
        BorderPane candyRoot = new BorderPane();
        BorderPane gumRoot = new BorderPane();
        BorderPane checkoutRoot = new BorderPane();
        BorderPane inventoryRoot = new BorderPane();

        //creates the scenes
        home = new Scene(homeRoot, 800, 600);
        drinksScene = new Scene(drinkRoot, 800, 600);
        chipsScene = new Scene(chipsRoot, 800, 600);
        candyScene = new Scene(candyRoot, 800, 600);
        gumScene = new Scene(gumRoot, 800, 600);
        checkoutScene = new Scene(checkoutRoot, 800, 600);
        inventoryScene = new Scene(inventoryRoot, 800, 600);

        //Display images on home border pane.
        Image drinksImage = new Image("image/drinks.png");
        ImageView drinksImageView = new ImageView(drinksImage);
        drinksImageView.setFitHeight(200);
        drinksImageView.setFitWidth(200);

        Image chipsImage = new Image("image/chips.png");
        ImageView chipsImageView = new ImageView(chipsImage);
        chipsImageView.setFitHeight(200);
        chipsImageView.setFitWidth(200);

        Image candyImage = new Image("image/candy.jpg");
        ImageView candyImageView = new ImageView(candyImage);
        candyImageView.setFitHeight(200);
        candyImageView.setFitWidth(200);

        Image gumImage = new Image("image/gum.png");
        ImageView gumImageView = new ImageView(gumImage);
        gumImageView.setFitHeight(200);
        gumImageView.setFitWidth(200);

        Image backImage = new Image("image/back.png");
        ImageView backImageView1 = new ImageView(backImage);
        backImageView1.setFitHeight(40);
        backImageView1.setFitWidth(40);

        ImageView backImageView2 = new ImageView(backImage);
        backImageView2.setFitHeight(40);
        backImageView2.setFitWidth(40);

        ImageView backImageView3 = new ImageView(backImage);
        backImageView3.setFitHeight(40);
        backImageView3.setFitWidth(40);

        ImageView backImageView4 = new ImageView(backImage);
        backImageView4.setFitHeight(40);
        backImageView4.setFitWidth(40);

        ImageView backImageView5 = new ImageView(backImage);
        backImageView5.setFitHeight(40);
        backImageView5.setFitWidth(40);

        ImageView backImageView6 = new ImageView(backImage);
        backImageView6.setFitHeight(40);
        backImageView6.setFitWidth(40);

        Image checkoutImage = new Image("image/checkout.png");
        ImageView checkoutImageView1 = new ImageView(checkoutImage);
        checkoutImageView1.setFitHeight(40);
        checkoutImageView1.setFitWidth(40);

        ImageView checkoutImageView2 = new ImageView(checkoutImage);
        checkoutImageView2.setFitHeight(40);
        checkoutImageView2.setFitWidth(40);

        ImageView checkoutImageView3 = new ImageView(checkoutImage);
        checkoutImageView3.setFitHeight(40);
        checkoutImageView3.setFitWidth(40);

        ImageView checkoutImageView4 = new ImageView(checkoutImage);
        checkoutImageView4.setFitHeight(40);
        checkoutImageView4.setFitWidth(40);

        ImageView checkoutImageView5 = new ImageView(checkoutImage);
        checkoutImageView5.setFitHeight(40);
        checkoutImageView5.setFitWidth(40);

        Image payImage = new Image("image/pay.png");
        ImageView payImageView = new ImageView(payImage);
        payImageView.setFitHeight(40);
        payImageView.setFitWidth(40);

        Image deleteImage = new Image("image/delete.png");
        ImageView deleteImageView = new ImageView(deleteImage);
        deleteImageView.setFitHeight(40);
        deleteImageView.setFitWidth(40);

        Image inventoryImage = new Image("image/inventory.png");
        ImageView inventoryImageView = new ImageView(inventoryImage);
        inventoryImageView.setFitHeight(40);
        inventoryImageView.setFitWidth(40);

        //sets translate animation functions
        translate.setDuration(Duration.seconds(2));
        translate.setToX(350);
        translate.setToY(120);

        //sets scale transition for animation to reduce the size by half
        scaleTransition.setDuration(Duration.seconds(2));
        scaleTransition.setToX(.5);
        scaleTransition.setToY(.5);

        //labels for each product scene
        Label drinkSelectionLabel = new Label("PLEASE MAKE A SELECTION BETWEEN EACH CLICK");
        Label chipSelectionLabel = new Label("PLEASE MAKE A SELECTION BETWEEN EACH CLICK");
        Label gumSelectionLabel = new Label("PLEASE MAKE A SELECTION BETWEEN EACH CLICK");
        Label candySelectionLabel = new Label("PLEASE MAKE A SELECTION BETWEEN EACH CLICK");
        Label inventoryLabel = new Label("CURRENT INVENTORY LIST");


        //create buttons on home screen
        Button drinksButton = new Button("DRINKS");
        drinksButton.setGraphic(drinksImageView);
        drinksButton.setOnAction(e -> primaryStage.setScene(drinksScene));

        Button chipsButton = new Button("CHIPS");
        chipsButton.setGraphic(chipsImageView);
        chipsButton.setOnAction(e -> primaryStage.setScene(chipsScene));

        Button candyButton = new Button("CANDY");
        candyButton.setGraphic(candyImageView);
        candyButton.setOnAction(e -> primaryStage.setScene(candyScene));

        Button gumButton = new Button("GUM");
        gumButton.setGraphic(gumImageView);
        gumButton.setOnAction(e -> primaryStage.setScene(gumScene));

        //create back buttons for each scene
        Button backButton1 = new Button();
        backButton1.setGraphic(backImageView1);
        backButton1.setOnAction(e -> primaryStage.setScene(home));

        Button backButton2 = new Button();
        backButton2.setGraphic(backImageView2);
        backButton2.setOnAction(e -> primaryStage.setScene(home));

        Button backButton3 = new Button();
        backButton3.setGraphic(backImageView3);
        backButton3.setOnAction(e -> primaryStage.setScene(home));

        Button backButton4 = new Button();
        backButton4.setGraphic(backImageView4);
        backButton4.setOnAction(e -> primaryStage.setScene(home));

        Button backButton5 = new Button();
        backButton5.setGraphic(backImageView5);
        backButton5.setOnAction(e -> primaryStage.setScene(home));

        Button backButton6 = new Button();
        backButton6.setGraphic(backImageView6);
        backButton6.setOnAction(e -> primaryStage.setScene(home));

        //add inventory screen for management
        Button inventoryButton = new Button();
        inventoryButton.setGraphic(inventoryImageView);
        inventoryButton.setOnAction(e -> {
            AlertBox.display("MANAGEMENT", "FOR MANAGEMENT USE ONLY");

            Stage window = new Stage();

            //Block events to other windows
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Management Interface");
            window.setResizable(false);

            Label label = new Label();
            label.setStyle("-fx-font-size: 14");
            label.setText("Enter Password:  ");

            String passwordMaster = "admin";

            Button passwordButton = new Button("ENTER");

            TextField passwordTextField = new TextField();
            passwordTextField.setPromptText("Enter Password:  ");
            passwordTextField.setOnAction(e2 -> {
                passwordButton.fire();
            });

            passwordButton.setStyle("-fx-font-size: 14");
            passwordButton.setOnAction(e1 -> {
                if (passwordTextField.getText().equals(passwordMaster)) {
                    AlertBox.display("Correct Password", "CORRECT!");
                    primaryStage.setScene(inventoryScene);
                    window.close();
                }
                else {
                    AlertBox.display("Wrong Password", "WRONG PASSWORD!");
                    passwordTextField.clear();
                }
            });

            HBox hBox = new HBox(25);
            HBox hBox2 = new HBox(25);
            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(25, 25, 25, 25));

            hBox.getChildren().addAll(label, passwordTextField);
            hBox.setAlignment(Pos.CENTER);

            hBox2.getChildren().add(passwordButton);
            hBox2.setAlignment(Pos.CENTER);

            borderPane.setCenter(hBox);
            borderPane.setBottom(hBox2);

            //Display window and wait for it to be closed before returning
            Scene scene = new Scene(borderPane, 450, 125);
            window.setScene(scene);
            window.showAndWait();
        });

        //add button to write CSV file from current inventory
        Button inventoryCSV = new Button("Write Current Inventory File");
        inventoryCSV.setMinWidth(200);
        inventoryCSV.setOnAction(e -> {
            CsvWriter.writeCsvFile(dispenser.inventory);
            AlertBox.display("CSV Writer", "INVENTORY FILE SAVED");
        });

        //button to write purchase order of low inventory
        Button lowInventoryPurchase = new Button("Create Purchase Order");
        lowInventoryPurchase.setMinWidth(200);
        lowInventoryPurchase.setOnAction(e -> {
            //checks current inventory on each run to check for low product quantity
            Restock restock = new Restock();
            restock.purchaseLowProducts(dispenser.inventory);
            AlertBox.display("Purchase Order", "PURCHASE ORDER SAVED");
        });

        //button to restock machine from purchase order
        Button restockInventory = new Button("Restock from Purchase Order");
        restockInventory.setMinWidth(200);
        restockInventory.setOnAction(e -> {
            Restock restock = new Restock();
            restock.restockProducts(dispenser.inventory);
            inventoryTableView.refresh();
            drinkTableView.refresh();
            candyTableView.refresh();
            chipsTableView.refresh();
            gumTableView.refresh();
            CsvWriter.writeCsvFile(dispenser.inventory);
            restock.purchaseLowProducts(dispenser.inventory);
            AlertBox.display("Success", "RESTOCK COMPLETE");
        });

        //create search button and actions
        Button searchButton = new Button("Search Inventory List");
        searchButton.setMinWidth(200);
        searchButton.setOnAction(e -> {
            Stage window = new Stage();

            //Block events to other windows
            window.initModality(Modality.APPLICATION_MODAL);
            window.setTitle("Search");
            window.setResizable(false);

            Label label = new Label();
            label.setStyle("-fx-font-size: 14");
            label.setText("Enter product name to search: ");

            Button searchButton2 = new Button("SEARCH");
            TextField textField = new TextField();
            textField.setPromptText("Enter product name to search: ");
            textField.setOnAction(e2 -> {
                searchButton2.fire();
            });

            searchButton2.setStyle("-fx-font-size: 14");
            searchButton2.setMinWidth(200);
            searchButton2.setOnAction(e1 -> {
                RecursiveSearch recursiveSearch = new RecursiveSearch();
                if (recursiveSearch.recursiveSearch(dispenser.inventory, textField.getText()) == -1) {
                    AlertBox.display("Not Found", "Product Not Found");
                } else {
                    AlertBox.display("Product Found", "PRODUCT FOUND! \n File Row: " +
                            (recursiveSearch.recursiveSearch(dispenser.inventory, textField.getText()) + 2) + "\nQuantity: " +
                    dispenser.inventory.get(recursiveSearch.recursiveSearch(dispenser.inventory, textField.getText())).getQuantity());
                    try {
                        if (Desktop.isDesktopSupported()) {
                            Desktop.getDesktop().open(new File("Blue Group Inventory.csv"));
                        }
                    }
                    catch (IOException ioe) {
                    }
                    inventoryTableView.getSelectionModel().select(recursiveSearch.recursiveSearch(dispenser.inventory, textField.getText()));
                    window.close();
                }
            });

            HBox hBox = new HBox(25);
            HBox hBox2 = new HBox(25);
            BorderPane borderPane = new BorderPane();
            borderPane.setPadding(new Insets(25, 25, 25, 25));

            hBox.getChildren().addAll(label, textField);
            hBox.setAlignment(Pos.CENTER);

            hBox2.getChildren().add(searchButton2);
            hBox2.setAlignment(Pos.CENTER);

            borderPane.setCenter(hBox);
            borderPane.setBottom(hBox2);

            //Display window and wait for it to be closed before returning
            Scene scene = new Scene(borderPane, 450, 125);
            window.setScene(scene);
            window.showAndWait();

        });

        //button to view the customer queue
        Button customerQueue = new Button("Customer Queue");
        customerQueue.setMinWidth(200);
        customerQueue.setOnAction(e -> {
            CustomerDisplay customerDisplay = new CustomerDisplay();
            customerDisplay.display(dispenser.inventory);

        });

        //create checkout buttons for each scene
        Button checkoutButton1 = new Button();
        checkoutButton1.setGraphic(checkoutImageView1);
        checkoutButtons(primaryStage, dispenser, checkoutScene, payImageView, checkoutButton1);

        Button checkoutButton2 = new Button();
        checkoutButton2.setGraphic(checkoutImageView2);
        checkoutButtons(primaryStage, dispenser, checkoutScene, payImageView, checkoutButton2);

        Button checkoutButton3 = new Button();
        checkoutButton3.setGraphic(checkoutImageView3);
        checkoutButtons(primaryStage, dispenser, checkoutScene, payImageView, checkoutButton3);

        Button checkoutButton4 = new Button();
        checkoutButton4.setGraphic(checkoutImageView4);
        checkoutButtons(primaryStage, dispenser, checkoutScene, payImageView, checkoutButton4);

        Button checkoutButton5 = new Button();
        checkoutButton5.setGraphic(checkoutImageView5);
        checkoutButtons(primaryStage, dispenser, checkoutScene, payImageView, checkoutButton5);

        //create pay and delete buttons
        Button deleteButton = new Button("Clear Selection");
        deleteButton.setGraphic(deleteImageView);
        deleteButton.setOnAction(e -> {
            try {
                dispenser.total = dispenser.total - checkoutTableView.getSelectionModel().getSelectedItem().getPrice();
                checkoutTableView.getSelectionModel().getSelectedItem().changeQuantity(1);
                checkoutObservableList.remove(checkoutTableView.getSelectionModel().getSelectedItem());
                checkoutTableView.refresh();
                drinkTableView.refresh();
                chipsTableView.refresh();
                candyTableView.refresh();
                gumTableView.refresh();
                inventoryTableView.refresh();
                totalBox.getChildren().remove(payButton);
                if (dispenser.total.toString().endsWith("25") || dispenser.total.toString().endsWith("75"))
                    payButton = new Button("$" + dispenser.total.toString());
                else payButton = new Button("$" + dispenser.total.toString() + "0");
                payButton.setGraphic(payImageView);
                payButton.setStyle("-fx-font-size: 20; -fx-font-weight: bold");
                totalBox.getChildren().add(payButton);

                if (checkoutObservableList.isEmpty()) {
                    AlertBox.display("Empty Cart", "NOTHING IS IN THE CART!");
                    primaryStage.setScene(home);
                }
            } catch (Exception e1) {
                AlertBox.display("Nothing Selected", "SELECT AN ITEM TO CLEAR");
            }
        });

        //payButton permanently removes items in cart from inventory, and writes updated inventory file
        payButton = new Button();
        payButton.setGraphic(payImageView);
        payButton.setStyle("-fx-font-size: 20; -fx-font-weight: bold");
        payButton.setOnAction(e -> {
            AlertBox.display("Success", "SUCCESS! THANK YOU!");
            CsvWriter.writeCsvFile(dispenser.inventory);
            checkoutObservableList.clear();
            checkoutTableView.refresh();
            primaryStage.setScene(home);
        });

        // add to cart button for each category.
        addDrinksButton = new Button("ADD TO CART");
        addDrinksButton.setMinSize(90, 90);
        addDrinksButton.setOnAction(e -> addButtonAction(drinkTableView, addDrinksButton));

        addChipsButton = new Button("ADD TO CART");
        addChipsButton.setMinSize(90, 90);
        addChipsButton.setOnAction(e -> addButtonAction(chipsTableView, addChipsButton));

        addCandyButton = new Button("ADD TO CART");
        addCandyButton.setMinSize(90, 90);
        addCandyButton.setOnAction(e -> addButtonAction(candyTableView, addCandyButton));

        addGumButton = new Button("ADD TO CART");
        addGumButton.setMinSize(90, 90);
        addGumButton.setOnAction(e -> addButtonAction(gumTableView, addGumButton));

        //drinks table setup
        TableColumn<Drink, String> drinkBrand = new TableColumn<>("Brand");
        drinkBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Drink, String> drinkName = new TableColumn<>("Name");
        drinkName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Drink, Double> drinkPrice = new TableColumn<>("Price");
        drinkPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Drink, Double> drinkSize = new TableColumn<>("Ounces");
        drinkSize.setCellValueFactory(new PropertyValueFactory<>("size"));

        TableColumn<Drink, String> drinkCalories = new TableColumn<>("Calories");
        drinkCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));

        TableColumn<Drink, Double> drinkSugar = new TableColumn<>("Sugar");
        drinkSugar.setCellValueFactory(new PropertyValueFactory<>("sugar"));

        TableColumn<Drink, Boolean> drinkCaffeine = new TableColumn<>("Caffeine");
        drinkCaffeine.setCellValueFactory(new PropertyValueFactory<>("caffeine"));

        TableColumn<Drink, Boolean> drinkHealthy = new TableColumn<>("Healthy");
        drinkHealthy.setCellValueFactory(new PropertyValueFactory<>("healthy"));

        TableColumn<Drink, Integer> drinkQuantity = new TableColumn<>("Quantity");
        drinkQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //sets chips columns
        TableColumn<Chips, String> chipsBrand = new TableColumn<>("Brand");
        chipsBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Chips, String> chipsName = new TableColumn<>("Name");
        chipsName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Chips, Double> chipsPrice = new TableColumn<>("Price");
        chipsPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Chips, Double> chipsWeight = new TableColumn<>("Weight");
        chipsWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn<Chips, String> chipsFlavor = new TableColumn<>("Flavor");
        chipsFlavor.setCellValueFactory(new PropertyValueFactory<>("flavor"));

        TableColumn<Chips, String> chipsType = new TableColumn<>("Type");
        chipsType.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Chips, Integer> chipsCalories = new TableColumn<>("Calories");
        chipsCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));

        TableColumn<Chips, Integer> chipsQuantity = new TableColumn<>("Quantity");
        chipsQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //sets candy columns
        TableColumn<Candy, String> candyBrand = new TableColumn<>("Brand");
        candyBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Candy, String> candyName = new TableColumn<>("Name");
        candyName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Candy, Double> candyPrice = new TableColumn<>("Price");
        candyPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Candy, Double> candyWeight = new TableColumn<>("Weight");
        candyWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn<Candy, String> candyFlavor = new TableColumn<>("Flavor");
        candyFlavor.setCellValueFactory(new PropertyValueFactory<>("flavor"));

        TableColumn<Candy, String> candyType = new TableColumn<>("Type");
        candyType.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Candy, Integer> candyCalories = new TableColumn<>("Calories");
        candyCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));

        TableColumn<Candy, Double> candySugar = new TableColumn<>("Sugar");
        candySugar.setCellValueFactory(new PropertyValueFactory<>("sugar"));

        TableColumn<Candy, Integer> candyQuantity = new TableColumn<>("Quantity");
        candyQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //sets gum columns
        TableColumn<Gum, String> gumBrand = new TableColumn<>("Brand");
        gumBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Gum, String> gumName = new TableColumn<>("Name");
        gumName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Gum, Double> gumPrice = new TableColumn<>("Price");
        gumPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Gum, Double> gumWeight = new TableColumn<>("Weight");
        gumWeight.setCellValueFactory(new PropertyValueFactory<>("weight"));

        TableColumn<Gum, String> gumFlavor = new TableColumn<>("Flavor");
        gumFlavor.setCellValueFactory(new PropertyValueFactory<>("flavor"));

        TableColumn<Gum, Integer> gumPieces = new TableColumn<>("Pieces");
        gumPieces.setCellValueFactory(new PropertyValueFactory<>("pieces"));

        TableColumn<Gum, Boolean> gumSugarFree = new TableColumn<>("Sugar Free");
        gumSugarFree.setCellValueFactory(new PropertyValueFactory<>("sugarFree"));

        TableColumn<Gum, Boolean> gumWhitening = new TableColumn<>("Whitening");
        gumWhitening.setCellValueFactory(new PropertyValueFactory<>("whitening"));

        TableColumn<Gum, Integer> gumCalories = new TableColumn<>("Calories");
        gumCalories.setCellValueFactory(new PropertyValueFactory<>("calories"));

        TableColumn<Gum, Integer> gumQuantity = new TableColumn<>("Quantity");
        gumQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //create checkout TableColumn
        TableColumn<Product, String> checkoutBrand = new TableColumn<>("Brand");
        checkoutBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Product, String> checkoutName = new TableColumn<>("Name");
        checkoutName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> checkoutPrice = new TableColumn<>("Price");
        checkoutPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        //create inventory TableColumn
        TableColumn<Product, String> inventoryBrand = new TableColumn<>("Brand");
        inventoryBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Product, String> inventoryName = new TableColumn<>("Name");
        inventoryName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> inventoryPrice = new TableColumn<>("Price");
        inventoryPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> inventoryQuantity = new TableColumn<>("Quantity");
        inventoryQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        // table view for items in category panes
        drinkTableView = new TableView<>();
        drinkTableView.setMaxSize(700, 300);
        drinkTableView.setItems(dispenser.createDrinks());
        drinkTableView.setOnMouseClicked(e -> tableViewAction(drinkTableView, addDrinksButton, drinksStack));
        drinkTableView.setOnKeyPressed(e -> tableViewAction(drinkTableView, addDrinksButton, drinksStack));
        drinkTableView.getColumns().addAll(drinkBrand, drinkName, drinkPrice, drinkSize, drinkCalories,
                drinkCaffeine, drinkHealthy, drinkQuantity);

        chipsTableView = new TableView<>();
        chipsTableView.setMaxSize(700, 300);
        chipsTableView.setItems(dispenser.createChips());
        chipsTableView.setOnMouseClicked(e -> tableViewAction(chipsTableView, addChipsButton, chipsStack));
        chipsTableView.setOnKeyPressed(e -> tableViewAction(chipsTableView, addChipsButton, chipsStack));
        chipsTableView.getColumns().addAll(chipsBrand, chipsName, chipsPrice, chipsFlavor, chipsType, chipsWeight,
                chipsCalories, chipsQuantity);

        candyTableView = new TableView<>();
        candyTableView.setMaxSize(700, 300);
        candyTableView.setItems(dispenser.createCandy());
        candyTableView.setOnMouseClicked(e -> tableViewAction(candyTableView, addCandyButton, candyStack));
        candyTableView.setOnKeyPressed(e -> tableViewAction(candyTableView, addCandyButton, candyStack));
        candyTableView.getColumns().addAll(candyBrand, candyName, candyPrice, candyFlavor, candyType, candyWeight, candyCalories,
                candySugar, candyQuantity);

        gumTableView = new TableView<>();
        gumTableView.setMaxSize(700, 300);
        gumTableView.setItems(dispenser.createGum());
        gumTableView.setOnMouseClicked(e -> tableViewAction(gumTableView, addGumButton, gumStack));
        gumTableView.setOnKeyPressed(e -> tableViewAction(gumTableView, addGumButton, gumStack));
        gumTableView.getColumns().addAll(gumBrand, gumName, gumPrice, gumFlavor, gumPieces, gumWeight, gumCalories,
                gumSugarFree, gumWhitening, gumQuantity);

        //create checkoutTableView
        checkoutTableView = new TableView<>();
        checkoutTableView.setMaxSize(300, 300);
        checkoutTableView.setItems(checkoutObservableList);
        checkoutTableView.getColumns().addAll(checkoutBrand, checkoutName, checkoutPrice);

        //create inventory tableview
        inventoryTableView = new TableView<>();
        inventoryTableView.setMaxSize(300, 500);
        inventoryTableView.setItems(globalInventoryManagement.readCurrentInventory(dispenser.inventory));
        inventoryTableView.getColumns().addAll(inventoryBrand, inventoryName, inventoryPrice, inventoryQuantity);

        //create GridPane for home scene
        GridPane homeCenter = new GridPane();
        homeCenter.setHgap(20);
        homeCenter.setVgap(20);
        homeCenter.setAlignment(Pos.CENTER);
        homeCenter.add(drinksButton, 0, 0);
        homeCenter.add(chipsButton, 1, 0);
        homeCenter.add(candyButton, 0, 1);
        homeCenter.add(gumButton, 1, 1);
        homeRoot.setCenter(homeCenter);

        BorderPane homeBottom = new BorderPane();
        homeBottom.setPadding(new Insets(25, 25, 25, 25));
        homeBottom.setRight(checkoutButton5);
        homeBottom.setLeft(inventoryButton);
        homeRoot.setBottom(homeBottom);

        drinksStack.getChildren().add(addDrinksButton);
        VBox drinksVbox = new VBox();
        drinksVbox.setAlignment(Pos.CENTER);
        drinksVbox.setSpacing(20);
        drinksVbox.getChildren().addAll(drinkTableView, drinkSelectionLabel, drinksStack);
        drinkRoot.setCenter(drinksVbox);

        BorderPane drinksBottom = new BorderPane();
        drinksBottom.setPadding(new Insets(25, 25, 25, 25));
        drinksBottom.setRight(checkoutButton1);
        drinksBottom.setLeft(backButton1);
        drinkRoot.setBottom(drinksBottom);

        chipsStack.getChildren().add(addChipsButton);
        VBox chipsVbox = new VBox();
        chipsVbox.setAlignment(Pos.CENTER);
        chipsVbox.setSpacing(20);
        chipsVbox.getChildren().addAll(chipsTableView, chipSelectionLabel, chipsStack);
        chipsRoot.setCenter(chipsVbox);

        BorderPane chipsBottom = new BorderPane();
        chipsBottom.setPadding(new Insets(25, 25, 25, 25));
        chipsBottom.setLeft(backButton2);
        chipsBottom.setRight(checkoutButton2);
        chipsRoot.setBottom(chipsBottom);

        candyStack.getChildren().add(addCandyButton);
        VBox candyVbox = new VBox();
        candyVbox.setAlignment(Pos.CENTER);
        candyVbox.setSpacing(20);
        candyVbox.getChildren().addAll(candyTableView, candySelectionLabel, candyStack);
        candyRoot.setCenter(candyVbox);

        BorderPane candyBottom = new BorderPane();
        candyBottom.setPadding(new Insets(25, 25, 25, 25));
        candyBottom.setLeft(backButton3);
        candyBottom.setRight(checkoutButton3);
        candyRoot.setBottom(candyBottom);

        gumStack.getChildren().add(addGumButton);
        VBox gumVbox = new VBox();
        gumVbox.setAlignment(Pos.CENTER);
        gumVbox.setSpacing(20);
        gumVbox.getChildren().addAll(gumTableView, gumSelectionLabel, gumStack);
        gumRoot.setCenter(gumVbox);

        BorderPane gumBottom = new BorderPane();
        gumBottom.setPadding(new Insets(25, 25, 25, 25));
        gumBottom.setLeft(backButton4);
        gumBottom.setRight(checkoutButton4);
        gumRoot.setBottom(gumBottom);

        VBox checkoutBox = new VBox();
        checkoutBox.setAlignment(Pos.CENTER);
        checkoutBox.getChildren().addAll(checkoutTableView);
        checkoutRoot.setPadding(new Insets(25, 25, 25, 25));
        checkoutRoot.setCenter(checkoutBox);

        VBox inventoryVBox2 = new VBox(25);
        HBox inventoryHBox = new HBox(25);
        VBox inventoryVBox = new VBox(25);

        BorderPane inventoryBottom = new BorderPane();
        inventoryVBox.setAlignment(Pos.CENTER);
        inventoryVBox.getChildren().addAll(searchButton, lowInventoryPurchase, restockInventory, inventoryCSV, customerQueue);
        inventoryVBox2.setAlignment(Pos.CENTER);
        inventoryVBox2.getChildren().addAll(inventoryLabel, inventoryTableView);
        inventoryHBox.setAlignment(Pos.CENTER);
        inventoryHBox.getChildren().addAll(inventoryVBox2, inventoryVBox);
        inventoryBottom.setLeft(backButton6);
        inventoryRoot.setPadding(new Insets(25, 25, 25, 25));
        inventoryRoot.setCenter(inventoryHBox);
        inventoryRoot.setBottom(inventoryBottom);

        totalBox.setAlignment(Pos.CENTER);

        checkoutBottom.setCenter(deleteButton);
        checkoutBottom.setLeft(backButton5);
        checkoutBottom.setRight(payButton);
        checkoutRoot.setBottom(checkoutBottom);

        //displays primaryStage
        primaryStage.setTitle("Vending Machine Application");
        primaryStage.setScene(home);
        primaryStage.show();
    }

    //method to handle checkoutButtons action
    private void checkoutButtons(Stage primaryStage, Dispenser dispenser, Scene checkoutScene, ImageView payImageView, Button checkoutButton1) {
        checkoutButton1.setOnAction(e -> {
            if (checkoutObservableList.isEmpty()) {
                AlertBox.display("Empty Cart", "NOTHING IS IN THE CART!");
            } else {
                //formatting code to properly display total price on button
                if (dispenser.total.toString().endsWith("25") || dispenser.total.toString().endsWith("75"))
                    payButton.setText("$" + dispenser.total.toString());
                else payButton.setText("$" + dispenser.total.toString() + "0");

                //refreshes total button with current total price
                if (!totalBox.getChildren().isEmpty())
                    totalBox.getChildren().clear();
                totalBox.getChildren().add(payButton);
                checkoutBottom.setRight(totalBox);
                primaryStage.setScene(checkoutScene);
            }
        });
    }

    //method to handle tableView actions
    private void tableViewAction(TableView tableView, Button addButton, StackPane stackPane) {
        try {
            Product product = (Product) tableView.getSelectionModel().getSelectedItem();
            Image changingImage = new Image("image/" + product.getImage());
            ImageView changingImageView = new ImageView(changingImage);
            changingImageView.setFitHeight(80);
            changingImageView.setFitWidth(80);
            addButton.setGraphic(changingImageView);

            changingImageView2 = new ImageView(changingImage);
            changingImageView2.setFitHeight(80);
            changingImageView2.setFitWidth(80);
            stackPane.getChildren().clear();
            stackPane.getChildren().addAll(changingImageView2, addButton);
        } catch (Exception e) {
            //does nothing when clicking on nothing in the tableView
        }
    }

    //method to handle addButton action
    private void addButtonAction(TableView tableView, Button addButton) {
        Product product = (Product) tableView.getSelectionModel().getSelectedItem();
        try {
            if (product.getQuantity() == 0)
                AlertBox.display("THERE ARE NO MORE", "THERE ARE NO MORE");
            else {
                checkoutObservableList.add(product);
                dispenser.total = dispenser.total + product.getPrice();
                product.changeQuantity(-1);

                tableView.refresh();
                inventoryTableView.refresh();

                translate.setNode(changingImageView2);
                translate.play();
                scaleTransition.setNode(changingImageView2);
                scaleTransition.play();
                tableView.getSelectionModel().clearSelection();
                addButton.setGraphic(null);
            }
        } catch (Exception e) {
            AlertBox.display("No Selection", "NOTHING SELECTED!");
        }
    }
}
