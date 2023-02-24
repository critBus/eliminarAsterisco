/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eliminarasterisco;

import com.jfoenix.controls.JFXNodesList;
import com.jfoenix.controls.JFXRippler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Rene
 */
public class FXT extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        System.out.println("a");
        Parent root = FXMLLoader.load(getClass().getResource("Ventana.fxml"));
        JFXRippler ri=new JFXRippler(root);
       
        Scene scene = new Scene(ri);

        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    public static void main(String[] args) {
        launch(args);
    }
}
