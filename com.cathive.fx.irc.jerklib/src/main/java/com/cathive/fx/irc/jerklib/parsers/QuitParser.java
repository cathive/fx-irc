package com.cathive.fx.irc.jerklib.parsers;

import java.util.List;

import com.cathive.fx.irc.jerklib.Channel;
import com.cathive.fx.irc.jerklib.Session;
import com.cathive.fx.irc.jerklib.events.IRCEvent;
import com.cathive.fx.irc.jerklib.events.QuitEvent;

public class QuitParser implements CommandParser
{
	public QuitEvent createEvent(IRCEvent event)
	{
		Session session = event.getSession();
		String nick = event.getNick();
		List<Channel> chanList = event.getSession().removeNickFromAllChannels(nick);
		return new QuitEvent
		(
			event.getRawEventData(), 
			session, 
			event.arg(0), // message
			chanList
		);
	}
}
