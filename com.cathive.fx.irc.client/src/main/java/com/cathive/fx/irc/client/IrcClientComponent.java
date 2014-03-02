package com.cathive.fx.irc.client;

import javax.inject.Qualifier;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation is used to mark IRC client components for use in conjunction with CDI.
 * @author Benjamin P. Jung
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface IrcClientComponent {
}
