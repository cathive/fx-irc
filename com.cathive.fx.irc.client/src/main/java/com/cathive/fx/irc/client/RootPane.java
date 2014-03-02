package com.cathive.fx.irc.client;

import com.cathive.fx.cdi.FXMLLoaderParams;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @author Benjamin P. Jung
 */
@Named
@ManagedBean
public class RootPane extends BorderPane {

    @Inject
    @IrcClientComponent
    private ResourceBundle messages;

    @Inject
    @FXMLLoaderParams(location = "RootPane.fxml")
    private FXMLLoader fxmlLoader;

    @FXML
    private ToolBar toolBar;

    @PostConstruct
    protected void initialize() {

        this.fxmlLoader.setRoot(this);
        this.fxmlLoader.setResources(this.messages);
        try {
            fxmlLoader.load();
        } catch (final IOException e) {
            throw new RuntimeException(e);
        }

    }

}
