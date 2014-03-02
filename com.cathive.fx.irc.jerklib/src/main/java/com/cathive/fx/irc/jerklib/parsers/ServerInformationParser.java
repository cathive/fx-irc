package com.cathive.fx.irc.jerklib.parsers;

import com.cathive.fx.irc.jerklib.Session;
import com.cathive.fx.irc.jerklib.events.IRCEvent;
import com.cathive.fx.irc.jerklib.events.ServerInformationEvent;

public class ServerInformationParser implements CommandParser
{
	public IRCEvent createEvent(IRCEvent event)
	{
		Session session = event.getSession();
		session.getServerInformation().parseServerInfo(event.getRawEventData());
		return new ServerInformationEvent(session, event.getRawEventData(), session.getServerInformation());
	}
}
