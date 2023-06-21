package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import model.Jordan1_Low_Reverse_Mocha;
import javafx.scene.Node;
import javafx.scene.Parent;

public class CheckoutController implements Initializable {

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8, pane9;

    @FXML
    VBox myvbox;

    @FXML
    MenuButton p;
    
    @FXML
    private Stage stage;

    @FXML
    private Scene scene;

    @FXML
    private Parent root = null;

    FXMLLoader loader;

    @FXML
    Label name1, name2, name3, name4, name5, name6, name7, name8, name9, price1, price2, price3, price4, price5, price6, price7, price8, price9, total, total2, shippingfee;

    @FXML
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;
     
    @FXML
    Button checkout;

    @FXML
    private ChoiceBox<String> choicebox1, choicebox2, choicebox3, choicebox4, choicebox5, choicebox6, choicebox7, choicebox8, choicebox9;

    private String[] quantity =  { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        char dollar = '$';

        name1.setText(HomeController.shoe1.getProductName());
        price1.setText(dollar + Double.toString(HomeController.shoe1.getProductPrice()));
        Image AIRFORCE1_FRIENDS_AND_FAMILY = new Image(HomeController.shoe1.getProductImage());
        img1.setImage(AIRFORCE1_FRIENDS_AND_FAMILY);

        name2.setText(HomeController.shoe2.getProductName());
        price2.setText(dollar + Double.toString(HomeController.shoe2.getProductPrice()));
        Image SB_DUNK_LOW_FREDDY_KRUEGER = new Image(HomeController.shoe2.getProductImage());
        img2.setImage(SB_DUNK_LOW_FREDDY_KRUEGER);

        name3.setText(HomeController.shoe3.getProductName());
        price3.setText(dollar + Double.toString(HomeController.shoe3.getProductPrice()));
        Image JORDAN_4_MANILA = new Image(HomeController.shoe3.getProductImage());
        img3.setImage(JORDAN_4_MANILA);

        name4.setText(HomeController.shoe4.getProductName());
        price4.setText(dollar + Double.toString(HomeController.shoe4.getProductPrice()));
        Image Jordan1_High_Dior = new Image(HomeController.shoe4.getProductImage());
        img4.setImage(Jordan1_High_Dior);

        name5.setText(HomeController.shoe5.getProductName());
        price5.setText(dollar + Double.toString(HomeController.shoe5.getProductPrice()));
        Image Jordan1_Low_Travis_Scott_X_Fragment = new Image(HomeController.shoe5.getProductImage());
        img5.setImage(Jordan1_Low_Travis_Scott_X_Fragment);

        name6.setText(HomeController.shoe6.getProductName());
        price6.setText(dollar + Double.toString(HomeController.shoe6.getProductPrice()));
        Image Kobe5_Bruce_Lee = new Image(HomeController.shoe6.getProductImage());
        img6.setImage(Kobe5_Bruce_Lee);

        name7.setText(HomeController.shoe7.getProductName());
        price7.setText(dollar + Double.toString(HomeController.shoe7.getProductPrice()));
        Image Jordan1_Reverse_Mocha = new Image(HomeController.shoe7.getProductImage());
        img7.setImage(Jordan1_Reverse_Mocha);

        name8.setText(HomeController.shoe8.getProductName());
        price8.setText(dollar + Double.toString(HomeController.shoe8.getProductPrice()));
        Image Jordan4_Travis_Purple = new Image(HomeController.shoe8.getProductImage());
        img8.setImage(Jordan4_Travis_Purple);

        name9.setText(HomeController.shoe9.getProductName());
        price9.setText(dollar + Double.toString(HomeController.shoe9.getProductPrice()));
        Image Jordan1_Low_Dior = new Image(HomeController.shoe9.getProductImage());
        img9.setImage(Jordan1_Low_Dior);

        // Set default quantities in choicebox to 1
        choicebox1.setValue("0");
        choicebox2.setValue("0");
        choicebox3.setValue("0");
        choicebox4.setValue("0");
        choicebox5.setValue("0");
        choicebox6.setValue("0");
        choicebox7.setValue("0");
        choicebox8.setValue("0");
        choicebox9.setValue("0");


        // Insert quantity array to choicebox
        choicebox1.getItems().addAll(quantity);
        choicebox2.getItems().addAll(quantity);
        choicebox3.getItems().addAll(quantity);
        choicebox4.getItems().addAll(quantity);
        choicebox5.getItems().addAll(quantity);
        choicebox6.getItems().addAll(quantity);
        choicebox7.getItems().addAll(quantity);
        choicebox8.getItems().addAll(quantity);
        choicebox9.getItems().addAll(quantity);
            
        // Add event handler on all choiceboxes
        choicebox1.setOnAction(this::computeTotal);
        choicebox2.setOnAction(this::computeTotal);
        choicebox3.setOnAction(this::computeTotal);
        choicebox4.setOnAction(this::computeTotal);
        choicebox5.setOnAction(this::computeTotal);
        choicebox6.setOnAction(this::computeTotal);
        choicebox7.setOnAction(this::computeTotal);
        choicebox8.setOnAction(this::computeTotal);
        choicebox9.setOnAction(this::computeTotal);

        // Set total initial amount
        double totalInitialAmount = 0.00;
        if (HomeController.shoe1.getProductStatus() || HomeController.shoe2.getProductStatus() || HomeController.shoe3.getProductStatus() || HomeController.shoe4.getProductStatus() 
            || HomeController.shoe5.getProductStatus() || HomeController.shoe6.getProductStatus() || HomeController.shoe7.getProductStatus() || HomeController.shoe8.getProductStatus() 
            || HomeController.shoe9.getProductStatus()) {
            totalInitialAmount =  Double.parseDouble(choicebox1.getValue()) * HomeController.shoe1.getProductPrice() 
            + Double.parseDouble(choicebox2.getValue()) * HomeController.shoe2.getProductPrice()
            + Double.parseDouble(choicebox3.getValue()) * HomeController.shoe3.getProductPrice()
            + Double.parseDouble(choicebox4.getValue()) * HomeController.shoe4.getProductPrice()
            + Double.parseDouble(choicebox5.getValue()) * HomeController.shoe5.getProductPrice()
            + Double.parseDouble(choicebox6.getValue()) * HomeController.shoe6.getProductPrice()
            + Double.parseDouble(choicebox7.getValue()) * HomeController.shoe7.getProductPrice()
            + Double.parseDouble(choicebox8.getValue()) * HomeController.shoe8.getProductPrice()
            + Double.parseDouble(choicebox9.getValue()) * HomeController.shoe9.getProductPrice();
        }   
     
        // Display total initial amount in total label
        total.setText(Double.toString(totalInitialAmount));
    }

    public void addItem(Pane pane) {
        myvbox.getChildren().add(pane);
    }

    public void computeTotal(ActionEvent event) {

        double totalAmount = 0;
        double totalAmount2 = 0;
        double item1Amount = 0;
        double item2Amount = 0;
        double item3Amount = 0;
        double item4Amount = 0;
        double item5Amount = 0;
        double item6Amount = 0;
        double item7Amount = 0;
        double item8Amount = 0;
        double item9Amount = 0;
        char dollar = '$';

        ChoiceBox source = (ChoiceBox) event.getSource();

        // If product is chosen, compute item amount
        if (HomeController.shoe1.getProductStatus()) {

            double qty = Double.parseDouble(choicebox1.getValue());
            HomeController.shoe1.setProductQuantity(qty);
            item1Amount = HomeController.shoe1.getProductPrice() * qty;

            if (source == choicebox1) {
                item1Amount = HomeController.shoe1.getProductPrice() * qty;
            }
        }

        if (HomeController.shoe2.getProductStatus()) {

            double qty = Double.parseDouble(choicebox2.getValue());
            HomeController.shoe2.setProductQuantity(qty);
            item2Amount = HomeController.shoe2.getProductPrice() * qty;

            if (source == choicebox2) {
                item2Amount = HomeController.shoe2.getProductPrice() * qty;
            }
        }

        if (HomeController.shoe3.getProductStatus()) {

            double qty = Double.parseDouble(choicebox3.getValue());
            HomeController.shoe3.setProductQuantity(qty);
            item3Amount = HomeController.shoe3.getProductPrice() * qty;

            if (source == choicebox3) {
                item3Amount = HomeController.shoe3.getProductPrice() * qty;
            }
        }
     
        if (HomeController.shoe4.getProductStatus()) {

            double qty = Double.parseDouble(choicebox4.getValue());
            HomeController.shoe4.setProductQuantity(qty);
            item4Amount = HomeController.shoe4.getProductPrice() * qty;

            if (source == choicebox4) {
                    item4Amount = HomeController.shoe4.getProductPrice() * qty;
            }
        }
     
     
        if (HomeController.shoe5.getProductStatus()) {

            double qty = Double.parseDouble(choicebox5.getValue());
            HomeController.shoe5.setProductQuantity(qty);
            item5Amount = HomeController.shoe5.getProductPrice() * qty;

            if (source == choicebox5) {
                item5Amount = HomeController.shoe5.getProductPrice() * qty;
            }
        }

        if (HomeController.shoe6.getProductStatus()) {

            double qty = Double.parseDouble(choicebox6.getValue());
            HomeController.shoe6.setProductQuantity(qty);
            item6Amount = HomeController.shoe6.getProductPrice() * qty;

            if (source == choicebox6) {
                item6Amount = HomeController.shoe6.getProductPrice() * qty;
            }
        }

        if (HomeController.shoe7.getProductStatus()) {

            double qty = Double.parseDouble(choicebox7.getValue());
            HomeController.shoe7.setProductQuantity(qty);
            item7Amount = HomeController.shoe7.getProductPrice() * qty;

            if (source == choicebox7) {
                item7Amount = HomeController.shoe7.getProductPrice() * qty;
            }
        }
        
        if (HomeController.shoe8.getProductStatus()) {

            double qty = Double.parseDouble(choicebox8.getValue());
            HomeController.shoe8.setProductQuantity(qty);
            item8Amount = HomeController.shoe8.getProductPrice() * qty;

            if (source == choicebox8) {
                item8Amount = HomeController.shoe8.getProductPrice() * qty;
            }
        }

        if (HomeController.shoe9.getProductStatus()) {

            double qty = Double.parseDouble(choicebox9.getValue());
            HomeController.shoe9.setProductQuantity(qty);
            item9Amount = HomeController.shoe9.getProductPrice() * qty;

            if (source == choicebox9) {
                item9Amount = HomeController.shoe9.getProductPrice() * qty;
            }
        }

        // Compute total amount for all items chosen
        totalAmount = item1Amount + item2Amount + item3Amount + item4Amount + item5Amount + item6Amount + item7Amount + item8Amount + item9Amount;
        totalAmount2 = item1Amount + item2Amount + item3Amount + item4Amount + item5Amount + item6Amount + item7Amount + item8Amount + item9Amount;
        dollar = '$';
        // Display total amount in total label
        total.setText(dollar + Double.toString(totalAmount));       
        total2.setText(dollar + Double.toString(totalAmount));

    }

    public void gotoOrder(ActionEvent event) throws IOException {

        loader = new FXMLLoader(getClass().getResource("/view/Order.fxml"));
        root = loader.load();
        Scene scene = new Scene(root);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
}
}