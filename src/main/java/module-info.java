module at.miriam.wifiproject.mywinecollection {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	requires jakarta.persistence;
	requires org.hibernate.orm.core;

    opens at.miriam.wifiproject.mywinecollection to javafx.fxml;
    exports at.miriam.wifiproject.mywinecollection;
    opens at.miriam.wifiproject.mywinecollection.controller to javafx.fxml;
    exports at.miriam.wifiproject.mywinecollection.controller;
}
