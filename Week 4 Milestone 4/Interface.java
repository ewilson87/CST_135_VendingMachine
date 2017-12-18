import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Interface extends Application {
    
	//declaring variables needed for entire application
	
    TableView<Drink> drinkTableView;
    TableView<Chips> chipsTableView;
    TableView<Candy> candyTableView;
    TableView<Gum> gumTableView;
    TableView<Product> checkoutTableView;
    ArrayList<Product> checkoutArray;
    ObservableList<Product> checkoutTable;
    Button payButton;
    BorderPane checkoutBottom = new BorderPane();
    HBox totalBox = new HBox(25);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Dispenser dispenser = new Dispenser();

        //declare scenes
        Scene home, drinksScene, chipsScene, candyScene, gumScene, checkoutScene;

        //creates root layout for all scenes
        BorderPane homeRoot = new BorderPane();
        BorderPane drinkRoot = new BorderPane();
        BorderPane chipsRoot = new BorderPane();
        BorderPane candyRoot = new BorderPane();
        BorderPane gumRoot = new BorderPane();
        BorderPane checkoutRoot = new BorderPane();

        //creates the scenes
        home = new Scene(homeRoot, 700, 600);
        drinksScene = new Scene(drinkRoot, 700, 600);
        chipsScene = new Scene(chipsRoot, 700, 600);
        candyScene = new Scene(candyRoot, 700, 600);
        gumScene = new Scene(gumRoot, 700, 600);
        checkoutScene = new Scene(checkoutRoot, 700, 600);

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

        //list view for items added to checkout
     
        ListView checkoutList = new ListView();
        checkoutList.setMaxSize(325, 300);

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

        //create checkout buttons for each scene
        //if else statements for checkout - alert box when cart empty, pay button displayed on bottom right with total 
        Button checkoutButton1 = new Button();
        checkoutButton1.setGraphic(checkoutImageView1);
        checkoutButton1.setOnAction(e -> {
            if (checkoutList.getItems().isEmpty()){    
                AlertBox.display("Empty Cart", "NOTHING IS IN THE CART!");}
                else {
                    if (dispenser.total.toString().endsWith("25") || dispenser.total.toString().endsWith("75"))
                        payButton = new Button("$" + dispenser.total.toString());
                else payButton = new Button("$" + dispenser.total.toString() + "0");
                payButton.setGraphic(payImageView);
                payButton.setStyle("-fx-font-size: 20; -fx-font-weight: bold");
                
                //clears listview when clearing cart
                
                if (!totalBox.getChildren().isEmpty())
                    totalBox.getChildren().clear();
                totalBox.getChildren().add(payButton);
                checkoutBottom.setRight(totalBox);
                primaryStage.setScene(checkoutScene);}});

        Button checkoutButton2 = new Button();
        checkoutButton2.setGraphic(checkoutImageView2);
        checkoutButton2.setOnAction(e -> {
            if (checkoutList.getItems().isEmpty()){
                AlertBox.display("Empty Cart", "NOTHING IS IN THE CART!");}
            else {
                if (dispenser.total.toString().endsWith("25") || dispenser.total.toString().endsWith("75"))
                    payButton = new Button("$" + dispenser.total.toString());
                else payButton = new Button("$" + dispenser.total.toString() + "0");
                payButton.setGraphic(payImageView);
                payButton.setStyle("-fx-font-size: 20; -fx-font-weight: bold");
                if (!totalBox.getChildren().isEmpty())
                    totalBox.getChildren().clear();
                totalBox.getChildren().add(payButton);
                checkoutBottom.setRight(totalBox);
                primaryStage.setScene(checkoutScene);}});

        Button checkoutButton3 = new Button();
        checkoutButton3.setGraphic(checkoutImageView3);
        checkoutButton3.setOnAction(e -> {
            if (checkoutList.getItems().isEmpty()){
                AlertBox.display("Empty Cart", "NOTHING IS IN THE CART!");}
            else {
                if (dispenser.total.toString().endsWith("25") || dispenser.total.toString().endsWith("75"))
                    payButton = new Button("$" + dispenser.total.toString());
                else payButton = new Button("$" + dispenser.total.toString() + "0");
                payButton.setGraphic(payImageView);
                payButton.setStyle("-fx-font-size: 20; -fx-font-weight: bold");
                if (!totalBox.getChildren().isEmpty())
                    totalBox.getChildren().clear();
                totalBox.getChildren().add(payButton);
                checkoutBottom.setRight(totalBox);
                primaryStage.setScene(checkoutScene);}});

        Button checkoutButton4 = new Button();
        checkoutButton4.setGraphic(checkoutImageView4);
        checkoutButton4.setOnAction(e -> {
            if (checkoutList.getItems().isEmpty()){
                AlertBox.display("Empty Cart", "NOTHING IS IN THE CART!");}
            else {
                if (dispenser.total.toString().endsWith("25") || dispenser.total.toString().endsWith("75"))
                    payButton = new Button("$" + dispenser.total.toString());
                else payButton = new Button("$" + dispenser.total.toString() + "0");
                payButton.setGraphic(payImageView);
                payButton.setStyle("-fx-font-size: 20; -fx-font-weight: bold");
                if (!totalBox.getChildren().isEmpty())
                    totalBox.getChildren().clear();
                totalBox.getChildren().add(payButton);
                checkoutBottom.setRight(totalBox);
                primaryStage.setScene(checkoutScene);}});

        Button checkoutButton5 = new Button();
        checkoutButton5.setGraphic(checkoutImageView5);
        checkoutButton5.setOnAction(e -> {
            if (checkoutList.getItems().isEmpty()){
                AlertBox.display("Empty Cart", "NOTHING IS IN THE CART!");}
            else {
                if (dispenser.total.toString().endsWith("25") || dispenser.total.toString().endsWith("75"))
                    payButton = new Button("$" + dispenser.total.toString());
                else payButton = new Button("$" + dispenser.total.toString() + "0");
                payButton.setGraphic(payImageView);
                payButton.setStyle("-fx-font-size: 20; -fx-font-weight: bold");
                if (!totalBox.getChildren().isEmpty())
                    totalBox.getChildren().clear();
                totalBox.getChildren().add(payButton);
                checkoutBottom.setRight(totalBox);
                primaryStage.setScene(checkoutScene);}});

        //create pay and delete buttons
        Button deleteButton = new Button("Clear Cart");
        deleteButton.setGraphic(deleteImageView);
        deleteButton.setOnAction(e -> { checkoutList.getItems().clear();
            dispenser.total = 0.0;
            if (checkoutList.getItems().isEmpty()){ AlertBox.display("Empty Cart", "NOTHING IS IN THE CART!");
                primaryStage.setScene(home);} });
        
        // add to cart button for each category.
        // image displayed for specific item clicked. 
        // get attributes from to diplay in cart listview 
        
        Button addDrinksButton = new Button("ADD TO CART");
        addDrinksButton.setMinSize(90,90);
        addDrinksButton.setOnAction(e -> {checkoutList.getItems().add(drinkTableView.getSelectionModel().getSelectedItem().getBrand() +
                " " + drinkTableView.getSelectionModel().getSelectedItem().getName() + ", " +
                drinkTableView.getSelectionModel().getSelectedItem().getSize() + " ounces " +
                "\nPrice:  " + drinkTableView.getSelectionModel().getSelectedItem().getPrice());
            dispenser.total = dispenser.total + drinkTableView.getSelectionModel().getSelectedItem().getPrice();
        });

        Button addChipsButton = new Button("ADD TO CART");
        addChipsButton.setMinSize(90,90);
        addChipsButton.setOnAction(e -> {checkoutList.getItems().add(chipsTableView.getSelectionModel().getSelectedItem().getBrand() +
                " " + chipsTableView.getSelectionModel().getSelectedItem().getFlavor() + " flavored " +
                chipsTableView.getSelectionModel().getSelectedItem().getName() + "\nPrice:  " +
                chipsTableView.getSelectionModel().getSelectedItem().getPrice());
            dispenser.total = dispenser.total + chipsTableView.getSelectionModel().getSelectedItem().getPrice();
        });

        Button addCandyButton = new Button("ADD TO CART");
        addCandyButton.setMinSize(90,90);
        addCandyButton.setOnAction(e -> {checkoutList.getItems().add(candyTableView.getSelectionModel().getSelectedItem().getBrand() +
                " " + candyTableView.getSelectionModel().getSelectedItem().getFlavor() + " flavored " +
                candyTableView.getSelectionModel().getSelectedItem().getName() + "\nPrice:  " +
                candyTableView.getSelectionModel().getSelectedItem().getPrice());
            dispenser.total = dispenser.total + candyTableView.getSelectionModel().getSelectedItem().getPrice();
        });

        Button addGumButton = new Button("ADD TO CART");
        addGumButton.setMinSize(90,90);
        addGumButton.setOnAction(e -> {checkoutList.getItems().add(gumTableView.getSelectionModel().getSelectedItem().getBrand() +
                " " + gumTableView.getSelectionModel().getSelectedItem().getFlavor() + " flavored " +
                gumTableView.getSelectionModel().getSelectedItem().getName() + "\nPrice:  " +
                gumTableView.getSelectionModel().getSelectedItem().getPrice());
            dispenser.total = dispenser.total + gumTableView.getSelectionModel().getSelectedItem().getPrice();
        });

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

	   //create checkout TableColumns to be implemented later
        TableColumn<Product, String> checkoutBrand = new TableColumn<>("Brand");
        checkoutBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Product, String> checkoutName = new TableColumn<>("Name");
        checkoutName.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Product, String> checkoutFlavor = new TableColumn<>("Flavor");
        checkoutFlavor.setCellValueFactory(new PropertyValueFactory<>("flavor"));

        TableColumn<Product, Double> checkoutPrice = new TableColumn<>("Price");
        checkoutPrice.setCellValueFactory(new PropertyValueFactory<>("brand"));

        // table view for items in category panes
        
        drinkTableView = new TableView<>();
        drinkTableView.setMaxSize(600, 300);
        drinkTableView.setItems(dispenser.createDrinks());
        drinkTableView.setOnMouseClicked(e -> {
            Image drinkChangingImage = new Image("image/" + drinkTableView.getSelectionModel().getSelectedItem().getImage());
            ImageView drinkChangingImageView = new ImageView(drinkChangingImage);
            drinkChangingImageView.setFitHeight(80);
            drinkChangingImageView.setFitWidth(80);
            addDrinksButton.setGraphic(drinkChangingImageView);
        });
        drinkTableView.getColumns().addAll(drinkBrand, drinkName, drinkPrice, drinkSize, drinkCalories,
                drinkCaffeine, drinkHealthy);

        chipsTableView = new TableView<>();
        chipsTableView.setMaxSize(600, 300);
        chipsTableView.setItems(dispenser.createChips());
        chipsTableView.setOnMouseClicked(e -> {
                    Image chipsChangingImage = new Image("image/" + chipsTableView.getSelectionModel().getSelectedItem().getImage());
                    ImageView chipsChangingImageView = new ImageView(chipsChangingImage);
                    chipsChangingImageView.setFitHeight(80);
                    chipsChangingImageView.setFitWidth(80);
                    addChipsButton.setGraphic(chipsChangingImageView);
                });
        chipsTableView.getColumns().addAll(chipsBrand, chipsName, chipsPrice, chipsFlavor, chipsType, chipsWeight, chipsCalories);

        candyTableView = new TableView<>();
        candyTableView.setMaxSize(600, 300);
        candyTableView.setItems(dispenser.createCandy());
        candyTableView.setOnMouseClicked(e -> {
                    Image candyChangingImage = new Image("image/" + candyTableView.getSelectionModel().getSelectedItem().getImage());
                    ImageView candyChangingImageView = new ImageView(candyChangingImage);
                    candyChangingImageView.setFitHeight(80);
                    candyChangingImageView.setFitWidth(80);
                    addCandyButton.setGraphic(candyChangingImageView);
                });
        candyTableView.getColumns().addAll(candyBrand, candyName, candyPrice, candyFlavor, candyType, candyWeight, candyCalories,
            candySugar);

        gumTableView = new TableView<>();
        gumTableView.setMaxSize(600, 300);
        gumTableView.setItems(dispenser.createGum());
        gumTableView.setOnMouseClicked(e -> {
                    Image gumChangingImage = new Image("image/" + gumTableView.getSelectionModel().getSelectedItem().getImage());
                    ImageView gumChangingImageView = new ImageView(gumChangingImage);
                    gumChangingImageView.setFitHeight(80);
                    gumChangingImageView.setFitWidth(80);
                    addGumButton.setGraphic(gumChangingImageView);
                });
        gumTableView.getColumns().addAll(gumBrand, gumName, gumPrice, gumFlavor, gumPieces, gumWeight, gumCalories,
                gumSugarFree, gumWhitening);

	   //create checkoutTableView, to be implemented in future
        checkoutTableView = new TableView<>();
        checkoutTableView.setMaxSize(600, 300);
        checkoutTableView.setItems(checkoutTable);
        checkoutTableView.getColumns().addAll(checkoutBrand, checkoutName, checkoutFlavor, checkoutPrice);


        //create GridPane for home scene
        GridPane homeCenter = new GridPane();
        homeCenter.setHgap(20);
        homeCenter.setVgap(20);
        homeCenter.setAlignment(Pos.CENTER);
        homeCenter.add(drinksButton, 0,0);
        homeCenter.add(chipsButton,1,0);
        homeCenter.add(candyButton,0,1);
        homeCenter.add(gumButton,1,1);
        homeRoot.setCenter(homeCenter);

        BorderPane homeBottom = new BorderPane();
        homeBottom.setPadding(new Insets(25,25,25,25));
        homeBottom.setRight(checkoutButton5);
        homeRoot.setBottom(homeBottom);

        VBox drinksVbox = new VBox();
        drinksVbox.setAlignment(Pos.CENTER);
        drinksVbox.setSpacing(20);
        drinksVbox.getChildren().addAll(drinkTableView, addDrinksButton);
        drinkRoot.setCenter(drinksVbox);

        BorderPane drinksBottom = new BorderPane();
        drinksBottom.setPadding(new Insets(25,25,25,25));
        drinksBottom.setRight(checkoutButton1);
        drinksBottom.setLeft(backButton1);
        drinkRoot.setBottom(drinksBottom);

        VBox chipsVbox = new VBox();
        chipsVbox.setAlignment(Pos.CENTER);
        chipsVbox.setSpacing(20);
        chipsVbox.getChildren().addAll(chipsTableView, addChipsButton);
        chipsRoot.setCenter(chipsVbox);

        BorderPane chipsBottom = new BorderPane();
        chipsBottom.setPadding(new Insets(25,25,25,25));
        chipsBottom.setLeft(backButton2);
        chipsBottom.setRight(checkoutButton2);
        chipsRoot.setBottom(chipsBottom);

        VBox candyVbox = new VBox();
        candyVbox.setAlignment(Pos.CENTER);
        candyVbox.setSpacing(20);
        candyVbox.getChildren().addAll(candyTableView, addCandyButton);
        candyRoot.setCenter(candyVbox);

        BorderPane candyBottom = new BorderPane();
        candyBottom.setPadding(new Insets(25,25,25,25));
        candyBottom.setLeft(backButton3);
        candyBottom.setRight(checkoutButton3);
        candyRoot.setBottom(candyBottom);

        VBox gumVbox = new VBox();
        gumVbox.setAlignment(Pos.CENTER);
        gumVbox.setSpacing(20);
        gumVbox.getChildren().addAll(gumTableView, addGumButton);
        gumRoot.setCenter(gumVbox);

        BorderPane gumBottom = new BorderPane();
        gumBottom.setPadding(new Insets(25,25,25,25));
        gumBottom.setLeft(backButton4);
        gumBottom.setRight(checkoutButton4);
        gumRoot.setBottom(gumBottom);

        VBox checkoutBox = new VBox();
        checkoutBox.setAlignment(Pos.CENTER);
        checkoutBox.getChildren().addAll(checkoutList);
        checkoutRoot.setPadding(new Insets(25,25,25,25));
        checkoutRoot.setCenter(checkoutBox);

        totalBox.setAlignment(Pos.CENTER);

        checkoutBottom.setCenter(deleteButton);
        checkoutBottom.setLeft(backButton5);
        checkoutBottom.setRight(payButton);
        //checkoutBottom.setTop(totalBox);
        checkoutRoot.setBottom(checkoutBottom);

        //displays primaryStage
        primaryStage.setTitle("Vending Machine Application");
        primaryStage.setScene(home);
        primaryStage.show();
    }
}
