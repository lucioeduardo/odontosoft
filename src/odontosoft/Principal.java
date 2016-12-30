package odontosoft;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * Classe principal do sistema
 */
public class Principal extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource("view/FXMLTelaLogin.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            scene.getStylesheets().add(getClass().getResource("view/css/bootstrap3.css").toExternalForm());
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        primaryStage.setTitle("OdontoSoft");
        
        primaryStage.setFullScreen(true);
        primaryStage.setResizable(false);
        
        
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
