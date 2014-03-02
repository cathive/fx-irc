package com.cathive.fx.irc.jerklib.events;

import com.cathive.fx.irc.jerklib.ServerInformation;
import com.cathive.fx.irc.jerklib.Session;

/**
 * Event fired when IRC numeric 005 is received - AKA Server Information
 * 
 * @author mohadib
 * 
 */
public class ServerInformationEvent extends IRCEvent
{

	private final ServerInformation serverInfo;

	public ServerInformationEvent(Session session, String rawEventData, ServerInformation serverInfo)
	{
		super(rawEventData, session, Type.SERVER_INFORMATION);
		this.serverInfo = serverInfo;
	}

	/**
	 * Gets the server information object
	 * 
	 * @return the info
	 */
	public ServerInformation getServerInformation()
	{
		return serverInfo;
	}

}
