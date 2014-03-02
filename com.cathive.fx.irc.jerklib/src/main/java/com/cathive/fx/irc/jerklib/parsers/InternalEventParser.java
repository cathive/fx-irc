package com.cathive.fx.irc.jerklib.parsers;

import com.cathive.fx.irc.jerklib.events.IRCEvent;

public interface InternalEventParser
{
	public IRCEvent receiveEvent(IRCEvent e);
}
