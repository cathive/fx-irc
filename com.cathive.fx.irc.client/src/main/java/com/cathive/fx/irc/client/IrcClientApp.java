package com.cathive.fx.irc.client;

import com.cathive.fx.cdi.WeldApplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.inject.Inject;
import java.util.ResourceBundle;

/**
 * @author Benjamin P. Jung
 */
public class IrcClientApp extends WeldApplication {

    @Inject
    private RootPane rootPane;

    @Inject
    @IrcClientComponent
    private ResourceBundle messages;


    @Override
    public void start(final Stage primaryStage) throws Exception {

        final Scene scene = new Scene(this.rootPane);

        primaryStage.setScene(scene);
        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(360);
        primaryStage.setTitle(this.messages.getString(Messages.APP_TITLE));

        primaryStage.show();

    }

    public static void main(String... args) {
        Application.launch(IrcClientApp.class, args);
    }

}
