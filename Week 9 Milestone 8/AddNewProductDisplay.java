import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddNewProductDisplay {

    //all possible variables for all types of products
    private double price, size, sugar, weight;
    private String name, image, productID, brand, flavor, type, productType;
    private int quantity, calories, pieces;
    private Boolean healthy, caffeine, sugarFree, whitening;


    public ObservableList<Product> addNewProduct(ObservableList<Product> inventory, ObservableList<Drink> drinksList,
                                                 ObservableList<Chips> chipsList, ObservableList<Candy> candyList,
                                                 ObservableList<Gum> gumList) {

        //declare stage
        Stage primaryStage = new Stage();

        //declare scenes
        Scene home, drinksScene, chipsScene, candyScene, gumScene, checkoutScene, inventoryScene;

        //creates root layout for all scenes
        VBox homeRoot = new VBox(10);
        homeRoot.setPadding(new Insets(25, 25, 25, 25));
        homeRoot.setAlignment(Pos.BASELINE_LEFT);
        VBox drinkRoot = new VBox(10);
        drinkRoot.setPadding(new Insets(25, 25, 25, 25));
        drinkRoot.setAlignment(Pos.BASELINE_LEFT);
        VBox chipsRoot = new VBox(10);
        chipsRoot.setPadding(new Insets(25, 25, 25, 25));
        chipsRoot.setAlignment(Pos.BASELINE_LEFT);
        VBox candyRoot = new VBox(10);
        candyRoot.setPadding(new Insets(25, 25, 25, 25));
        candyRoot.setAlignment(Pos.BASELINE_LEFT);
        VBox gumRoot = new VBox(10);
        gumRoot.setPadding(new Insets(25, 25, 25, 25));
        gumRoot.setAlignment(Pos.BASELINE_LEFT);

        //sets scenes
        home = new Scene(homeRoot, 800, 600);
        drinksScene = new Scene(drinkRoot, 800, 600);
        chipsScene = new Scene(chipsRoot, 800, 600);
        candyScene = new Scene(candyRoot, 800, 600);
        gumScene = new Scene(gumRoot, 800, 600);

        //choiceBox for selecting type of product to add
        ChoiceBox<String> productTypeChoiceBox = new ChoiceBox<>();
        productTypeChoiceBox.setStyle("-fx-font-size: 26");
        productTypeChoiceBox.getItems().addAll("DRINK", "CHIPS", "CANDY", "GUM");
        productTypeChoiceBox.setValue("DRINK");

        Label productTypeSelectLabel = new Label("SELECT A TYPE OF PRODUCT TO ADD");
        productTypeSelectLabel.setStyle("-fx-font-size: 26");
        Label healthyLabel = new Label("HEALTHY: ");
        Label caffeineLabel = new Label("CAFFEINE: ");
        Label sugarFreeLabel = new Label("SUGAR FREE: ");
        Label whiteningLabel = new Label("WHITENING: ");
        Label imageLabel = new Label("IMPORTANT: MAKE SURE IMAGE NAME MATCHES AN IMAGE IN THE IMAGE FOLDER!");

        Image backImage = new Image("image/back.png");
        ImageView backImageView = new ImageView(backImage);
        backImageView.setFitHeight(40);
        backImageView.setFitWidth(40);
        Button backButton2 = new Button();
        backButton2.setGraphic(backImageView);
        backButton2.setOnAction(e -> primaryStage.close());

        TextField priceTextField = new TextField("PRICE");
        priceTextField.setFocusTraversable(false);
        priceTextField.setOnMouseClicked(e -> {
            if (priceTextField.getText().equals("PRICE"))
                priceTextField.clear();
        });
        TextField nameTextField = new TextField("NAME");
        nameTextField.setFocusTraversable(false);
        nameTextField.setOnMouseClicked(e -> {
            if (nameTextField.getText().equals("NAME"))
                nameTextField.clear();
        });
        TextField imageTextField = new TextField("IMAGE FILE NAME STORED IN IMAGE FOLDER");
        imageTextField.setFocusTraversable(false);
        imageTextField.setOnMouseClicked(e -> {
            if (imageTextField.getText().equals("IMAGE FILE NAME STORED IN IMAGE FOLDER"))
                imageTextField.clear();
        });
        TextField quantityTextField = new TextField("INITIAL QUANTITY");
        quantityTextField.setFocusTraversable(false);
        quantityTextField.setOnMouseClicked(e -> {
            if (quantityTextField.getText().equals("INITIAL QUANTITY"))
                quantityTextField.clear();
        });
        TextField productIDTextField = new TextField("UNIQUE PRODUCT ID");
        productIDTextField.setFocusTraversable(false);
        productIDTextField.setOnMouseClicked(e -> {
            if (productIDTextField.getText().equals("UNIQUE PRODUCT ID"))
                productIDTextField.clear();
        });
        TextField brandTextField = new TextField("BRAND");
        brandTextField.setFocusTraversable(false);
        brandTextField.setOnMouseClicked(e -> {
            if (brandTextField.getText().equals("BRAND"))
                brandTextField.clear();
        });
        TextField caloriesTextField = new TextField("CALORIES");
        caloriesTextField.setFocusTraversable(false);
        caloriesTextField.setOnMouseClicked(e -> {
            if (caloriesTextField.getText().equals("CALORIES"))
                caloriesTextField.clear();
        });
        TextField sizeTextField = new TextField("SIZE");
        sizeTextField.setFocusTraversable(false);
        sizeTextField.setOnMouseClicked(e -> {
            if (sizeTextField.getText().equals("SIZE"))
                sizeTextField.clear();
        });
        TextField sugarTextField = new TextField("SUGAR");
        sugarTextField.setFocusTraversable(false);
        sugarTextField.setOnMouseClicked(e -> {
            if (sugarTextField.getText().equals("SUGAR"))
                sugarTextField.clear();
        });
        TextField weightTextField = new TextField("WEIGHT");
        weightTextField.setFocusTraversable(false);
        weightTextField.setOnMouseClicked(e -> {
            if (weightTextField.getText().equals("WEIGHT"))
                weightTextField.clear();
        });
        TextField flavorTextField = new TextField("FLAVOR");
        flavorTextField.setFocusTraversable(false);
        flavorTextField.setOnMouseClicked(e -> {
            if (flavorTextField.getText().equals("FLAVOR"))
                flavorTextField.clear();
        });
        TextField typeTextField = new TextField("TYPE");
        typeTextField.setFocusTraversable(false);
        typeTextField.setOnMouseClicked(e -> {
            if (typeTextField.getText().equals("TYPE"))
                typeTextField.clear();
        });
        TextField piecesTextField = new TextField("NUMBER OF PIECES");
        piecesTextField.setFocusTraversable(false);
        piecesTextField.setOnMouseClicked(e -> {
            if (piecesTextField.getText().equals("NUMBER OF PIECES"))
                piecesTextField.clear();
        });

        //healthy toggle group
        ToggleGroup healthyToggleGroup = new ToggleGroup();
        RadioButton healthyFalse = new RadioButton("FALSE");
        RadioButton healthyTrue = new RadioButton("TRUE");
        healthyFalse.setToggleGroup(healthyToggleGroup);
        healthyTrue.setToggleGroup(healthyToggleGroup);
        HBox healthyHBox = new HBox(25);
        healthyHBox.getChildren().addAll(healthyLabel, healthyFalse, healthyTrue);

        //caffeine toggle group
        ToggleGroup caffeineToggleGroup = new ToggleGroup();
        RadioButton caffeineFalse = new RadioButton("FALSE");
        RadioButton caffeineTrue = new RadioButton("TRUE");
        caffeineFalse.setToggleGroup(caffeineToggleGroup);
        caffeineTrue.setToggleGroup(caffeineToggleGroup);
        HBox caffeineHBox = new HBox(25);
        caffeineHBox.getChildren().addAll(caffeineLabel, caffeineFalse, caffeineTrue);

        //sugarFree toggle group
        ToggleGroup sugarFreeToggleGroup = new ToggleGroup();
        RadioButton sugarFreeFalse = new RadioButton("FALSE");
        RadioButton sugarFreeTrue = new RadioButton("True");
        sugarFreeFalse.setToggleGroup(sugarFreeToggleGroup);
        sugarFreeTrue.setToggleGroup(sugarFreeToggleGroup);
        HBox sugarFreeHBox = new HBox(25);
        sugarFreeHBox.getChildren().addAll(sugarFreeLabel, sugarFreeFalse, sugarFreeTrue);

        //whitening toggle group
        ToggleGroup whiteningToggleGroup = new ToggleGroup();
        RadioButton whiteningFalse = new RadioButton("FALSE");
        RadioButton whiteningTrue = new RadioButton("True");
        whiteningFalse.setToggleGroup(whiteningToggleGroup);
        whiteningTrue.setToggleGroup(whiteningToggleGroup);
        HBox whiteningHBox = new HBox(25);
        whiteningHBox.getChildren().addAll(whiteningLabel, whiteningFalse, whiteningTrue);

        Button createProductButton = new Button("CREATE");

        Button backButton = new Button("GO BACK");
        backButton.setOnAction(e -> {
            drinkRoot.getChildren().clear();
            chipsRoot.getChildren().clear();
            candyRoot.getChildren().clear();
            gumRoot.getChildren().clear();
            primaryStage.setScene(home);
        });

        Button productTypeButton = new Button("OK");
        productTypeButton.setStyle("-fx-font-size: 26");
        productTypeButton.setOnAction(e -> {
            getChoice(productTypeChoiceBox);
            if (productType.equals("DRINK")) {
                createProductButton.setOnAction(e1 -> {
                    try {
                        name = nameTextField.getText();
                        brand = brandTextField.getText();
                        price = Double.parseDouble(priceTextField.getText());
                        size = Double.parseDouble(sizeTextField.getText());
                        calories = Integer.parseInt(caloriesTextField.getText());
                        sugar = Integer.parseInt(sugarTextField.getText());
                        if (caffeineToggleGroup.getSelectedToggle() == caffeineFalse)
                            caffeine = false;
                        else caffeine = true;
                        if (healthyToggleGroup.getSelectedToggle() == healthyFalse)
                            healthy = false;
                        else healthy = true;
                        image = imageTextField.getText();
                        quantity = Integer.parseInt(quantityTextField.getText());
                        productID = productIDTextField.getText();
                    } catch (Exception e2) {
                        AlertBox.display("ERROR", "ERROR CREATING PRODUCT. \n CHECK INPUT DATA.");
                        productTypeChoiceBox.setValue("DRINK");
                        productTypeButton.fire();
                    }

                    Drink product;
                    product = new Drink(name, brand, price, size, calories, sugar, caffeine, healthy, image, quantity, productID);
                    inventory.add(product);
                    drinksList.add(product);
                    AlertBox.display("Success", "PRODUCT ADDED");
                    primaryStage.close();
                });

                if (drinkRoot.getChildren().isEmpty())
                    drinkRoot.getChildren().addAll(nameTextField, brandTextField, priceTextField, sizeTextField, caloriesTextField,
                            sugarTextField, imageTextField, quantityTextField, productIDTextField, caffeineHBox, healthyHBox,
                            imageLabel, createProductButton, backButton);

                primaryStage.setScene(drinksScene);
            } else if (productType.equals("CHIPS")) {
                createProductButton.setOnAction(e1 -> {
                    drinkRoot.getChildren().clear();
                    chipsRoot.getChildren().clear();
                    candyRoot.getChildren().clear();
                    gumRoot.getChildren().clear();
                    try {
                        name = nameTextField.getText();
                        brand = brandTextField.getText();
                        price = Double.parseDouble(priceTextField.getText());
                        flavor = flavorTextField.getText();
                        type = typeTextField.getText();
                        weight = Integer.parseInt(weightTextField.getText());
                        calories = Integer.parseInt(caloriesTextField.getText());
                        image = imageTextField.getText();
                        quantity = Integer.parseInt(quantityTextField.getText());
                        productID = productIDTextField.getText();
                    } catch (Exception e2) {
                        AlertBox.display("ERROR", "ERROR CREATING PRODUCT. \n CHECK INPUT DATA.");
                    }

                    Chips product;
                    product = new Chips(name, brand, price, flavor, type, weight, calories, image, quantity, productID);
                    inventory.add(product);
                    chipsList.add(product);
                    AlertBox.display("Success", "PRODUCT ADDED");
                    primaryStage.close();
                });

                if (chipsRoot.getChildren().isEmpty())
                    chipsRoot.getChildren().addAll(nameTextField, brandTextField, priceTextField, flavorTextField, typeTextField,
                            weightTextField, caloriesTextField, imageTextField, quantityTextField, productIDTextField,
                            imageLabel, createProductButton, backButton);

                primaryStage.setScene(chipsScene);
            } else if (productType.equals("CANDY")) {
                createProductButton.setOnAction(e1 -> {
                    drinkRoot.getChildren().clear();
                    chipsRoot.getChildren().clear();
                    candyRoot.getChildren().clear();
                    gumRoot.getChildren().clear();
                    try {
                        name = nameTextField.getText();
                        brand = brandTextField.getText();
                        price = Double.parseDouble(priceTextField.getText());
                        flavor = flavorTextField.getText();
                        type = typeTextField.getText();
                        weight = Integer.parseInt(weightTextField.getText());
                        calories = Integer.parseInt(caloriesTextField.getText());
                        image = imageTextField.getText();
                        quantity = Integer.parseInt(quantityTextField.getText());
                        productID = productIDTextField.getText();
                        sugar = Double.parseDouble(sugarTextField.getText());
                    } catch (Exception e2) {
                        AlertBox.display("ERROR", "ERROR CREATING PRODUCT. \n CHECK INPUT DATA.");
                    }

                    Candy product;
                    product = new Candy(name, brand, price, type, flavor, weight, sugar, calories, image, quantity, productID);
                    inventory.add(product);
                    candyList.add(product);
                    AlertBox.display("Success", "PRODUCT ADDED");
                    primaryStage.close();
                });

                if (candyRoot.getChildren().isEmpty())
                    candyRoot.getChildren().addAll(nameTextField, brandTextField, priceTextField, typeTextField, flavorTextField,
                            weightTextField, sugarTextField, caloriesTextField, imageTextField, quantityTextField, productIDTextField,
                            imageLabel, createProductButton, backButton);

                primaryStage.setScene(candyScene);
            } else if (productType.equals("GUM")) {
                createProductButton.setOnAction(e1 -> {
                    drinkRoot.getChildren().clear();
                    chipsRoot.getChildren().clear();
                    candyRoot.getChildren().clear();
                    gumRoot.getChildren().clear();
                    try {
                        name = nameTextField.getText();
                        brand = brandTextField.getText();
                        price = Double.parseDouble(priceTextField.getText());
                        flavor = flavorTextField.getText();
                        weight = Integer.parseInt(weightTextField.getText());
                        pieces = Integer.parseInt(piecesTextField.getText());
                        if (sugarFreeToggleGroup.getSelectedToggle() == sugarFreeFalse)
                            sugarFree = false;
                        else sugarFree = true;
                        calories = Integer.parseInt(caloriesTextField.getText());
                        if (whiteningToggleGroup.getSelectedToggle() == whiteningFalse)
                            whitening = false;
                        else whitening = true;
                        image = imageTextField.getText();
                        quantity = Integer.parseInt(quantityTextField.getText());
                        productID = productIDTextField.getText();
                    } catch (Exception e2) {
                        AlertBox.display("ERROR", "ERROR CREATING PRODUCT. \n CHECK INPUT DATA.");
                    }

                    Gum product;
                    product = new Gum(name, brand, price, flavor, weight, pieces, sugarFree, calories, whitening, image, quantity, productID);
                    inventory.add(product);
                    gumList.add(product);
                    AlertBox.display("Success", "PRODUCT ADDED");
                    primaryStage.close();
                });

                if (gumRoot.getChildren().isEmpty())
                    gumRoot.getChildren().addAll(nameTextField, brandTextField, priceTextField, flavorTextField, weightTextField,
                            piecesTextField, caloriesTextField, imageTextField, quantityTextField,
                            productIDTextField, sugarFreeHBox, whiteningHBox, imageLabel, createProductButton, backButton);

                primaryStage.setScene(gumScene);
            }
        });

        homeRoot.setAlignment(Pos.CENTER);
        homeRoot.getChildren().addAll(productTypeSelectLabel, productTypeChoiceBox, productTypeButton, backButton2);

        //displays primaryStage
        primaryStage.setTitle("Vending Machine Application");
        primaryStage.setScene(home);
        primaryStage.showAndWait();

        return inventory;
    }

    private void getChoice(ChoiceBox<String> productTypeChoiceBox) {
        productType = productTypeChoiceBox.getValue();
    }
}

