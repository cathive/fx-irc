package com.cathive.fx.irc.jerklib.events;

import com.cathive.fx.irc.jerklib.Session;

public class GenericErrorEvent extends ErrorEvent
{
	private final Exception ex;
	
	public GenericErrorEvent(String data, Session session, Exception exception)
	{
		super(data, session, ErrorType.GENERIC);
		ex = exception;
	}
	
	public Exception getException()
	{
		return ex;
	}
	
}
