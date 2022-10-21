module com.games.spacaderthegame {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
                requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
                requires com.almasb.fxgl.all;
    
    opens com.games.spacaderthegame to javafx.fxml;
    exports com.games.spacaderthegame;
}