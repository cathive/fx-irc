package com.cathive.fx.irc.jerklib.parsers;

import com.cathive.fx.irc.jerklib.Channel;
import com.cathive.fx.irc.jerklib.Session;
import com.cathive.fx.irc.jerklib.events.IRCEvent;
import com.cathive.fx.irc.jerklib.events.NickListEvent;

/**
 * @author mohadib
 *
 */
public class NamesParser implements CommandParser
{
	public IRCEvent createEvent(IRCEvent event)
	{

		if (event.command().matches("366"))
		{
			Session session = event.getSession();
			return new NickListEvent
			(
				event.getRawEventData(), 
				session, 
				session.getChannel(event.arg(1)),
				session.getChannel(event.arg(1)).getNicks());
		}

		Channel chan = event.getSession().getChannel(event.arg(2));
		String[] names = event.arg(3).split("\\s+");

		for (String name : names)
		{
			if (name != null && name.length() > 0)
			{
				chan.addNick(name);
			}
		}
		return event;
	}
}
