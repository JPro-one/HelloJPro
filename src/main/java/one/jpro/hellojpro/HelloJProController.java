package one.jpro.hellojpro;

import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import one.jpro.platform.routing.LinkUtil;

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

    @FXML
    private Node logoLink;
    @FXML
    private Node githubLink;
    @FXML
    private Node docsLink;
    @FXML
    private Node examplesLink;
    @FXML
    private Node platformLink;

    @FXML
    private void initialize() {
        // In the browser these become real links; on desktop they open the system browser
        LinkUtil.setExternalLink(logoLink, "https://www.jpro.one/");
        LinkUtil.setExternalLink(githubLink, "https://github.com/JPro-one/HelloJPro");
        LinkUtil.setExternalLink(docsLink, "https://www.jpro.one/docs/");
        LinkUtil.setExternalLink(examplesLink, "https://www.jpro.one/showcase");
        LinkUtil.setExternalLink(platformLink, "https://www.jpro.one/platform");

        root.widthProperty().addListener((obs, oldWidth, width) -> setCompact(width.doubleValue() < COMPACT_WIDTH));
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
