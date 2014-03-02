package com.cathive.fx.irc.jerklib.events;

import com.cathive.fx.irc.jerklib.Session;

/**
 * Created: Jan 31, 2008 6:31:31 PM
 *
 * @author <a href="mailto:robby.oconnor@gmail.com">Robert O'Connor</a>
 * @see WhoEvent
 */
public class WhoEvent extends IRCEvent
{
    private final String nick, userName, realName, hostName, channel;
    private final String serverName;
    private final boolean isAway;
    private final int hopCount;

    public WhoEvent
    (
    		String channel, 
    		int hopCount, 
    		String hostName,
        boolean away, 
        String nick, 
        String rawEventData,
        String realName, 
        String serverName, 
        Session session, 
        String userName
    )
    {
        super(rawEventData, session, Type.WHO_EVENT);
    		this.channel = channel;
        this.hopCount = hopCount;
        this.hostName = hostName;
        isAway = away;
        this.nick = nick;
        this.realName = realName;
        this.serverName = serverName;
        this.userName = userName;
    }

    /**
     * Get the nick of the user
     *
     * @return the nick of the user.
     */
    public String getNick()
    {
        return nick;
    }

    /**
     * Get the username of the user
     *
     * @return the username
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * Get the hostname of the user
     *
     * @return the hostname
     */
    public String getHostName()
    {
        return hostName;
    }

    /**
     * Get the real name of the user.
     *
     * @return the real name
     */
    public String getRealName()
    {
        return realName;
    }

    /**
     * Retrieve the channel (for when you WHO a channel)
     *
     * @return the channel or an empty String
     */
    public String getChannel()
    {
        return channel.equals("*") ? "" : channel;
    }

    /**
     * Get whether or not the user is away.
     *
     * @return whether or not the user is away.
     */
    public boolean isAway()
    {
        return isAway;
    }


    /**
     * Returns the number of hops between you and the user.
     *
     * @return the hop count
     */
    public int getHopCount()
    {
        return hopCount;
    }


    /**
     * Get the server the user is on.
     *
     * @return the server.
     */
    public String getServerName()
    {
        return serverName;
    }
}
