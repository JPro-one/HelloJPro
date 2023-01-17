package one.jpro.hellojpro;

import com.jpro.webapi.JProApplication;
import com.jpro.webapi.WebAPI;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Hello JPro FXML controller.
 *
 * @author Florian Kirmaier
 */
public class HelloJProFXMLController implements Initializable {

    @FXML
    public Label platformLabel;

    @FXML
    protected StackPane root;

    @FXML
    protected Node logo;

    protected JProApplication jproApplication;
    protected ParallelTransition pt;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        platformLabel.setText(String.format("Platform: %s", WebAPI.isBrowser() ? "Browser" : "Desktop"));
    }

    protected void initLogoAnimation(Node logo) {
        ScaleTransition st = new ScaleTransition(Duration.millis(1000), logo);
        st.setByX(-0.5);
        st.setByY(-0.5);
        st.setAutoReverse(true);
        st.setCycleCount(Animation.INDEFINITE);

        FadeTransition ft = new FadeTransition(Duration.millis(1000), logo);
        ft.setToValue(0.5);
        ft.setAutoReverse(true);
        ft.setCycleCount(Animation.INDEFINITE);
        logo.setOpacity(1);

        pt = new ParallelTransition(st, ft);
        pt.play();

        if (WebAPI.isBrowser()) {
            jproApplication.getWebAPI().addInstanceCloseListener(() -> pt.stop());
        }
    }

    protected void init(JProApplication jproApplication) {
        this.jproApplication = jproApplication;
        initLogoAnimation(this.logo);
    }
}
