package com.cathive.fx.irc.jerklib.parsers;

import com.cathive.fx.irc.jerklib.events.IRCEvent;
import com.cathive.fx.irc.jerklib.events.InviteEvent;

public class InviteParser implements CommandParser
{
	/* :r0bby!n=wakawaka@guifications/user/r0bby INVITE scripy1 :#jerklib2 */
	/* :yaloki!~yaloki@localhost INVITE SuSEmeet #test */
	public IRCEvent createEvent(IRCEvent event)
	{
		return new InviteEvent
		(
			event.arg(0), 
			event.getRawEventData(), 
			event.getSession()
		); 
	}
}
