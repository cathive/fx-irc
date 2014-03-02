package com.cathive.fx.irc.jerklib.events;

import com.cathive.fx.irc.jerklib.Session;

/**
 * NickInUseEvent is fired when com.cathive.fx.irc.jerklib is trying to use a nick
 * that is in use on a given server.
 *
 * @author mohadib
 */
public class NickInUseEvent extends IRCEvent
{

	private final String inUseNick;

	public NickInUseEvent(String inUseNick, String rawEventData, Session session)
	{
		super(rawEventData, session, Type.NICK_IN_USE);
		this.inUseNick = inUseNick;
	}

  /**
   * returns nick that is in use
   *
   * @return nick that is in use.
   */
	public String getInUseNick()
	{
		return inUseNick;
	}
}
