package com.cathive.fx.irc.jerklib.events;

import com.cathive.fx.irc.jerklib.Channel;
import com.cathive.fx.irc.jerklib.Session;

/**
 * Event fired for generic CTCP events
 * 
 * @author mohadib
 *
 */
public class CtcpEvent extends MessageEvent
{

	private String ctcpString, message;
	private Channel channel;

	public CtcpEvent
	(
		String ctcpString, 
		String message, 
		String rawEventData, 
		Channel channel, 
		Session session
	)
	{
		super(channel, message, rawEventData, session, Type.CTCP_EVENT);
		this.ctcpString = ctcpString;
		this.message = message;
		this.channel = channel;
	}

  /**
   * Returns the CTCP query
   * @return ctcp query
   */
	public String getCtcpString()
	{
		return ctcpString;
	}

	/* (non-Javadoc)
	 * @see com.cathive.fx.irc.jerklib.events.MessageEvent#getChannel()
	 */
	public Channel getChannel()
	{
		return channel;
	}


	/* (non-Javadoc)
	 * @see com.cathive.fx.irc.jerklib.events.MessageEvent#getMessage()
	 */
	public String getMessage()
	{
		return message;
	}
}
