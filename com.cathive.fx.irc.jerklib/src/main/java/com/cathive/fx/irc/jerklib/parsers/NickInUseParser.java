package com.cathive.fx.irc.jerklib.parsers;

import com.cathive.fx.irc.jerklib.events.IRCEvent;
import com.cathive.fx.irc.jerklib.events.NickInUseEvent;

public class NickInUseParser implements CommandParser
{
	public IRCEvent createEvent(IRCEvent event)
	{
		return new NickInUseEvent
		(
				event.arg(1),
				event.getRawEventData(), 
				event.getSession()
		); 
	}
}
