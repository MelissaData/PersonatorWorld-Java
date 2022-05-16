module com.melissadata.personatorworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires com.google.gson;
    requires jdk.crypto.ec;
    requires java.xml;

    opens com.melissadata.personatorworld to javafx.fxml;
    opens com.melissadata.personatorworld.model to javafx.fxml;
    opens com.melissadata.personatorworld.view to javafx.fxml;
    exports com.melissadata.personatorworld;
}
