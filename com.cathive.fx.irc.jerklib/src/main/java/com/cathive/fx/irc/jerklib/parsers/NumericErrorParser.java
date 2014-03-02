package com.cathive.fx.irc.jerklib.parsers;

import com.cathive.fx.irc.jerklib.events.IRCEvent;
import com.cathive.fx.irc.jerklib.events.NumericErrorEvent;

public class NumericErrorParser implements CommandParser
{
	public IRCEvent createEvent(IRCEvent event)
	{
		return new NumericErrorEvent
		(
				event.arg(0), 
				event.getRawEventData(), 
				event.getSession()
		); 
	}
}
