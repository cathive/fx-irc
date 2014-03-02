package com.cathive.fx.irc.jerklib.parsers;

import com.cathive.fx.irc.jerklib.Session;
import com.cathive.fx.irc.jerklib.events.IRCEvent;
import com.cathive.fx.irc.jerklib.events.NickChangeEvent;

public class NickParser implements CommandParser
{
	public IRCEvent createEvent(IRCEvent event)
	{
		Session session = event.getSession();
		return new NickChangeEvent
		(
				event.getRawEventData(), 
				session, 
				event.getNick(), // old
				event.arg(0)// new nick
		); 
	}
}
