package com.cathive.fx.irc.jerklib.events;

import com.cathive.fx.irc.jerklib.Session;

/**
 * 
 * Event fired for most all numeric error replies
 * 
 * @author Mohadib
 */
public class NumericErrorEvent extends ErrorEvent
{
	private final String errMsg;

	public NumericErrorEvent(String errMsg, String rawEventData,Session session)
	{
		super(rawEventData, session, ErrorType.NUMERIC_ERROR);
		this.errMsg = errMsg;
	}

	/* (non-Javadoc)
	 * @see com.cathive.fx.irc.jerklib.events.NumericErrorEvent#getErrorMsg()
	 */
	public String getErrorMsg()
	{
		return errMsg;
	}

}
