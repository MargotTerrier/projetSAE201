module org.uphf.projetsae201 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires jdk.jfr;

    opens org.uphf.projetsae201 to javafx.fxml;
    exports org.uphf.projetsae201;

}