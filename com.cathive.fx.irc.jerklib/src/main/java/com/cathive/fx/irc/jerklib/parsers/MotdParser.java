package com.cathive.fx.irc.jerklib.parsers;

import com.cathive.fx.irc.jerklib.events.IRCEvent;
import com.cathive.fx.irc.jerklib.events.MotdEvent;

public class MotdParser implements CommandParser
{
	public IRCEvent createEvent(IRCEvent event)
	{
		return new MotdEvent
		(
			event.getRawEventData(), 
			event.getSession(), 
			event.arg(1), 
			event.prefix()
		);
	}
}
