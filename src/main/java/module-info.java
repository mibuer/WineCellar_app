module at.miriam.wifiproject.mywinecollection {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;

    opens at.miriam.wifiproject.mywinecollection to javafx.fxml;
    exports at.miriam.wifiproject.mywinecollection;
}
