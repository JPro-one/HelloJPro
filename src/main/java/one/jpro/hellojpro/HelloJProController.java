package one.jpro.hellojpro;

import javafx.css.PseudoClass;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
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
    private StackPane page;
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

        page.widthProperty().addListener((obs, oldWidth, width) ->
                page.pseudoClassStateChanged(COMPACT, width.doubleValue() < COMPACT_WIDTH));
    }

    @FXML
    private void toggleTheme() {
        page.pseudoClassStateChanged(DARK, !page.getPseudoClassStates().contains(DARK));
    }
}
