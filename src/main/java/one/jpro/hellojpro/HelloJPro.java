package one.jpro.hellojpro;

import com.jpro.webapi.JProApplication;
import com.jpro.webapi.WebAPI;
import fr.brouillard.oss.cssfx.CSSFX;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Hello JPro application.
 *
 * @author Florian Kirmaier
 */
public class HelloJPro extends JProApplication {

    @Override
    public void start(Stage stage) throws IOException {
        // load user interface as FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/one/jpro/hellojpro/fxml/HelloJPro.fxml"));
        Parent root = loader.load();
        HelloJProController controller = loader.getController();
        controller.setApplication(this);

        Scene scene = new Scene(root, 1280, 768);

        if (isDevelopment()) {
            // CSSFX reloads the CSS as soon as you save it
            Runnable stopCssfx = CSSFX.start(scene);
            if (WebAPI.isBrowser()) {
                getWebAPI().addInstanceCloseListener(stopCssfx::run);
            }
        }

        stage.setTitle("Hello JPro!");
        stage.setScene(scene);

        // open JavaFX window
        stage.show();
    }

    /**
     * True on desktop and when started with {@code jproRun},
     * false in a {@code jproRelease} build.
     */
    private static boolean isDevelopment() {
        return !WebAPI.isBrowser() || "dev".equals(System.getProperty("jpro.mode"));
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
