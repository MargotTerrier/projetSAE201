module org.uphf.projetsae201 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires jdk.jfr;

    opens org.uphf.projetsae201 to javafx.fxml;
    exports org.uphf.projetsae201;
    exports org.uphf.projetsae201.Model;
    opens org.uphf.projetsae201.Model to javafx.fxml;
    exports org.uphf.projetsae201.View;
    opens org.uphf.projetsae201.View to javafx.fxml;
    exports org.uphf.projetsae201.Controller;
    opens org.uphf.projetsae201.Controller to javafx.fxml;

}