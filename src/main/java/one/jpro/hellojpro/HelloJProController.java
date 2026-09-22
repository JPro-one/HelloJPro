package one.jpro.hellojpro;

import com.jpro.webapi.JProApplication;
import com.jpro.webapi.WebAPI;
import javafx.css.PseudoClass;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/**
 * Controller for HelloJPro.fxml.
 *
 * @author Florian Kirmaier
 */
public class HelloJProController {

    /** Below this width (e.g. on phones) the panels and buttons stack vertically. */
    private static final double COMPACT_WIDTH = 720;
    private static final PseudoClass COMPACT = PseudoClass.getPseudoClass("compact");
    /** Switches the colors to the dark theme defined in HelloJPro.css. */
    private static final PseudoClass DARK = PseudoClass.getPseudoClass("dark");

    @FXML
    private StackPane root;
    @FXML
    private Pane cardBody;
    @FXML
    private Pane mainActions;
    @FXML
    private Pane platformActions;

    private JProApplication application;

    @FXML
    private void initialize() {
        root.widthProperty().addListener((obs, oldWidth, width) -> setCompact(width.doubleValue() < COMPACT_WIDTH));
    }

    void setApplication(JProApplication application) {
        this.application = application;
    }

    /**
     * Opens the URL stored in the clicked button's {@code userData}:
     * in a new browser tab when running in the browser, in the system browser on desktop.
     */
    @FXML
    private void openLink(ActionEvent event) {
        String url = (String) ((Node) event.getSource()).getUserData();
        if (WebAPI.isBrowser()) {
            application.getWebAPI().openURLAsTab(url);
        } else {
            application.getHostServices().showDocument(url);
        }
    }

    @FXML
    private void toggleTheme() {
        root.pseudoClassStateChanged(DARK, !root.getPseudoClassStates().contains(DARK));
    }

    private void setCompact(boolean compact) {
        if (root.getPseudoClassStates().contains(COMPACT) == compact) {
            return;
        }
        root.pseudoClassStateChanged(COMPACT, compact);
        cardBody = reorient(cardBody, compact);
        mainActions = reorient(mainActions, compact);
        platformActions = reorient(platformActions, compact);
    }

    /** Replaces a row with a column (or back), keeping its children and style classes. */
    private static Pane reorient(Pane pane, boolean vertical) {
        Pane replacement = vertical ? new VBox() : new HBox();
        replacement.getStyleClass().setAll(pane.getStyleClass());
        replacement.getChildren().setAll(pane.getChildren());
        Pane parent = (Pane) pane.getParent();
        parent.getChildren().set(parent.getChildren().indexOf(pane), replacement);
        return replacement;
    }
}
