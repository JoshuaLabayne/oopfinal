package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
public class OrderController implements Initializable {
    @FXML
    Label name1, name2, name3, name4, name5, name6, name7, name8, name9, qty1, qty2, qty3, qty4, qty5, 
    qty6, qty7, qty8, qty9, price1, price2, price3, price4, price5, price6, price7, price8, price9, 
    lineTotalAmount1, lineTotalAmount2, lineTotalAmount3, lineTotalAmount4, lineTotalAmount5, lineTotalAmount6,
    lineTotalAmount7, lineTotalAmount8, lineTotalAmount9, finalAmount;
    

    @FXML
    Pane pane1, pane2, pane3, pane4, pane5, pane6, pane7, pane8, pane9;
    
    @FXML
    VBox myvbox2;
    
    @FXML
    ImageView img1, img2, img3, img4, img5, img6, img7, img8, img9;

    double amt1, amt2, amt3, amt4, amt5, amt6, amt7, amt8, amt9, finalamt;
    
   
    public void initialize(URL location, ResourceBundle resources) {

         if (HomeController.shoe1.getProductStatus()){
            name1.setText(HomeController.shoe1.getProductName());
            price1.setText(Double.toString(HomeController.shoe1.getProductPrice()));
            qty1.setText(Double.toString(HomeController.shoe1.getProductQuantity()));
            name1.setVisible(true);
            price1.setVisible(true);
            qty1.setVisible(true);
            amt1 = HomeController.shoe1.getProductPrice() * HomeController.shoe1.getProductQuantity();
            lineTotalAmount1.setText(Double.toString(amt1));
         }
             if (HomeController.shoe2.getProductStatus()){
                name2.setText(HomeController.shoe2.getProductName());
                price2.setText(Double.toString(HomeController.shoe2.getProductPrice()));
                qty2.setText(Double.toString(HomeController.shoe2.getProductQuantity()));
                name2.setVisible(true);
                price2.setVisible(true);
                qty2.setVisible(true);

               amt2 = HomeController.shoe2.getProductPrice() * HomeController.shoe2.getProductQuantity();
               lineTotalAmount2.setText(Double.toString(amt2));
        }
             if (HomeController.shoe3.getProductStatus()){
                name3.setText(HomeController.shoe3.getProductName());
                price3.setText(Double.toString(HomeController.shoe3.getProductPrice()));
                qty3.setText(Double.toString(HomeController.shoe3.getProductQuantity()));
                name3.setVisible(true);
                price3.setVisible(true);
                qty3.setVisible(true);

                amt3 = HomeController.shoe3.getProductPrice() * HomeController.shoe3.getProductQuantity();
                lineTotalAmount3.setText(Double.toString(amt3));
        }
              if (HomeController.shoe4.getProductStatus()){
                name4.setText(HomeController.shoe4.getProductName());
                price4.setText(Double.toString(HomeController.shoe4.getProductPrice()));
                qty4.setText(Double.toString(HomeController.shoe4.getProductQuantity()));
                name4.setVisible(true);
                price4.setVisible(true);
                qty4.setVisible(true);

                amt4 = HomeController.shoe4.getProductPrice() * HomeController.shoe4.getProductQuantity();
                lineTotalAmount4.setText(Double.toString(amt4));
      }

              if (HomeController.shoe5.getProductStatus()){
                name5.setText(HomeController.shoe5.getProductName());
                price5.setText(Double.toString(HomeController.shoe5.getProductPrice()));
                qty5.setText(Double.toString(HomeController.shoe5.getProductQuantity()));
                name5.setVisible(true);
                price5.setVisible(true);
                qty5.setVisible(true);

                amt5 = HomeController.shoe5.getProductPrice() * HomeController.shoe5.getProductQuantity();
                lineTotalAmount5.setText(Double.toString(amt5));
      }

              if (HomeController.shoe6.getProductStatus()){
                name6.setText(HomeController.shoe6.getProductName());
                price6.setText(Double.toString(HomeController.shoe6.getProductPrice()));
                qty6.setText(Double.toString(HomeController.shoe6.getProductQuantity()));
                name6.setVisible(true);
                price6.setVisible(true);
                qty6.setVisible(true);

                amt6 = HomeController.shoe6.getProductPrice() * HomeController.shoe6.getProductQuantity();
                lineTotalAmount6.setText(Double.toString(amt6));
      }

              if (HomeController.shoe7.getProductStatus()){
                name7.setText(HomeController.shoe7.getProductName());
                price7.setText(Double.toString(HomeController.shoe7.getProductPrice()));
                qty7.setText(Double.toString(HomeController.shoe7.getProductQuantity()));
                name7.setVisible(true);
                price7.setVisible(true);
                qty7.setVisible(true);

                amt7 = HomeController.shoe7.getProductPrice() * HomeController.shoe7.getProductQuantity();
                lineTotalAmount7.setText(Double.toString(amt7));

      }

              if (HomeController.shoe8.getProductStatus()){
                name8.setText(HomeController.shoe8.getProductName());
                price8.setText(Double.toString(HomeController.shoe8.getProductPrice()));
                qty8.setText(Double.toString(HomeController.shoe8.getProductQuantity()));
                name8.setVisible(true);
                price8.setVisible(true);
                qty8.setVisible(true);

                amt8 = HomeController.shoe8.getProductPrice() * HomeController.shoe8.getProductQuantity();
                lineTotalAmount8.setText(Double.toString(amt8));
              
      }

              if (HomeController.shoe9.getProductStatus()){
                name9.setText(HomeController.shoe9.getProductName());
                price9.setText(Double.toString(HomeController.shoe9.getProductPrice()));
                qty9.setText(Double.toString(HomeController.shoe9.getProductQuantity()));
                name9.setVisible(true);
                price9.setVisible(true);
                qty9.setVisible(true);
                amt9 = HomeController.shoe9.getProductPrice() * HomeController.shoe9.getProductQuantity();
                lineTotalAmount9.setText(Double.toString(amt9));
        
      }        
        
      
        finalamt = amt1+amt2+amt3+amt4+amt5+amt6+amt7+amt8+amt9;
        finalAmount.setText(Double.toString(finalamt));
      }

      public void addItem(Pane pane) {
        myvbox2.getChildren().add(pane);
    }
}