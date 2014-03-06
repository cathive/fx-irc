package com.cathive.fx.irc.client;

import com.cathive.fx.cdi.FXMLComponent;
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
@FXMLComponent(location = "RootPane.fxml", resources = "com.cathive.fx.irc.client.Messages")
public class RootPane extends BorderPane {

    @FXML
    private ToolBar toolBar;

}
