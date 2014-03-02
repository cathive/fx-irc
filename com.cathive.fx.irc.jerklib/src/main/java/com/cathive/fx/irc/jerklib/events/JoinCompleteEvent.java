package com.cathive.fx.irc.jerklib.events;

import com.cathive.fx.irc.jerklib.Channel;
import com.cathive.fx.irc.jerklib.Session;

/**
 * Event that occurs when a join to a channel is complete
 * 
 * @author mohadib
 */
public class JoinCompleteEvent extends IRCEvent
{
	private final Channel channel;

	public JoinCompleteEvent(String rawEventData, Session session, Channel channel)
	{
		super(rawEventData, session, Type.JOIN_COMPLETE);
		this.channel = channel;
	}

	/**
	 * getChannel() returns Channel object for event
	 * 
	 * @return <code>Channel</code>
	 * @see Channel
	 */
	public final Channel getChannel()
	{
		return channel;
	}

}
