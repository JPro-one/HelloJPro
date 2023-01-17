/**
 * Module descriptor.
 *
 * @author Besmir Beqiri
 */
module one.jpro.hellojpro {
    requires javafx.controls;
    requires javafx.fxml;
    requires jpro.webapi;

    exports one.jpro.hellojpro;
    opens one.jpro.hellojpro to javafx.fxml;
}