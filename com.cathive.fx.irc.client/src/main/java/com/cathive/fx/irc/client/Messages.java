package com.cathive.fx.irc.client;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import java.util.ResourceBundle;

/**
 * @author Benjamin P. Jung
 */
@Singleton
@ManagedBean
public class Messages {

    public static final String APP_NAME = "app.name";
    public static final String APP_TITLE = "app.title";
    public static final String APP_DESCRIPTION = "app.description";

    public static final String BUTTON_SEND_TEXT = "button.send.text";


    private ResourceBundle resourceBundle;

    private Messages() {
        super();
        this.resourceBundle = ResourceBundle.getBundle(Messages.class.getName());
    }

    @Produces
    @IrcClientComponent
    public ResourceBundle getBundle() {
        return this.resourceBundle;
    }

    public String getString(final String key) {
        return this.resourceBundle.getString(key);
    }

}
