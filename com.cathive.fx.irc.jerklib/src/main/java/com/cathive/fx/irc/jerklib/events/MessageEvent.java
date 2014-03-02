package com.cathive.fx.irc.jerklib.events;

import com.cathive.fx.irc.jerklib.Channel;
import com.cathive.fx.irc.jerklib.Session;

/**
 * @author mohadib
 * @see MessageEvent
 * 
 */
public class MessageEvent extends IRCEvent
{

	private final String message;
	private final Channel channel;

	public MessageEvent
	(
		Channel channel, 
		String message, 
		String rawEventData, 
		Session session, 
		Type type 
	)
	{
		super(rawEventData,session,type);
		this.channel = channel;
		this.message = message;
	}

  /**
   * returns IRCChannel object the PrivMsg occured in
   *
   * @return the Channel object
   */
	public Channel getChannel()
	{
		return channel;
	}

  /**
   * getMessage() returns the message part of the event
   *
   * @return the message
   */
	public String getMessage()
	{
		return message;
	}

	/**
	 * indicates if this message is private
	 * 
	 * @return true if type == Type.PRIVATE_MESSAGE
	 */
	public boolean isPrivate()
	{
		return getType() == Type.PRIVATE_MESSAGE;
	}
}
