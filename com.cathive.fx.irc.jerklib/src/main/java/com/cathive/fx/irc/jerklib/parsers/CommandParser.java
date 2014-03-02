package com.cathive.fx.irc.jerklib.parsers;

import com.cathive.fx.irc.jerklib.events.IRCEvent;

public interface CommandParser
{
	public IRCEvent createEvent(IRCEvent event);
}
