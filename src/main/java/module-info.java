/**
 * Module descriptor.
 *
 * @author Besmir Beqiri
 */
module one.jpro.hellojpro {
    requires javafx.controls;
    requires javafx.fxml;
    requires jpro.webapi;
    requires fr.brouillard.oss.cssfx;
    requires one.jpro.platform.routing.core;
    requires jpro.platform.jpro.flexbox;
    requires one.jpro.platform.cssgrid;

    exports one.jpro.hellojpro;
    opens one.jpro.hellojpro to javafx.fxml;
}