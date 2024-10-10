module site.luisicj.ejerciciodados {
    requires javafx.controls;
    requires javafx.fxml;

    opens site.luisicj.ejerciciodados to javafx.fxml;
    exports site.luisicj.ejerciciodados;
}