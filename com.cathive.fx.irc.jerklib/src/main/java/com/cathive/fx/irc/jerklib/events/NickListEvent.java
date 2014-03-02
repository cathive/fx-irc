package com.cathive.fx.irc.jerklib.events;

import com.cathive.fx.irc.jerklib.Channel;
import com.cathive.fx.irc.jerklib.Session;

import java.util.List;

/**
 * 
 * Event fired when nick list event comes from server
 * @author mohadib
 *         
 */
public class NickListEvent extends IRCEvent
{
	private final List<String> nicks;
	private final Channel channel;

	public NickListEvent(String rawEventData, Session session, Channel channel, List<String> nicks)
	{
		super(rawEventData, session, Type.NICK_LIST_EVENT);
		this.channel = channel;
		this.nicks = nicks;

	}

  /**
   * Gets the channel the nick list came from
   *
   * @return Channel
   * @see Channel
   */
	public Channel getChannel()
	{
		return channel;
	}

  /**
   * Gets the nick list for the Channel
   *
   * @return List of nicks in channel
   */
	public List<String> getNicks()
	{
		return nicks;
	}
}
