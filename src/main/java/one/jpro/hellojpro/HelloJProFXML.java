package one.jpro.hellojpro;

import com.jpro.webapi.JProApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Hello JPro application using FXML.
 *
 * @author Florian Kirmaier
 */
public class HelloJProFXML extends JProApplication {

    @Override
    public void start(Stage stage) throws IOException {
        // load user interface as FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/one/jpro/hellojpro/fxml/HelloJPro.fxml"));
        Parent root = loader.load();
        HelloJProFXMLController controller = loader.getController();
        controller.init(this);

        stage.setTitle("Hello JPro!");
        stage.setScene(new Scene(root, 1280, 768));

        // open JavaFX window
        stage.show();
    }

    /**
     * Application entry point.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
