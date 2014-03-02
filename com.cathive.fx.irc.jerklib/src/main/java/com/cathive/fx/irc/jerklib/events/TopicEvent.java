package com.cathive.fx.irc.jerklib.events;

import com.cathive.fx.irc.jerklib.Channel;
import com.cathive.fx.irc.jerklib.Session;

import java.util.Date;

/**
 * 
 * Event fired when topic is received
 * @author mohadib
 * @see Channel
 */
public class TopicEvent extends IRCEvent
{

	private String setBy,hostname;
	private Date setWhen;
	private Channel channel;
	private StringBuffer buff = new StringBuffer();

	public TopicEvent(String rawEventData, Session session, Channel channel, String topic)
	{
		super(rawEventData, session, Type.TOPIC);
		this.channel = channel;
		buff.append(topic);
	}

  /**
   * Gets the topic
   *
   * @return the topic
   */
	public String getTopic() {
		return buff.toString();
	}

	/**
	 * @return hostname
	 */
    @Override
	public String getHostName()
	{
		return hostname;
	}

	/**
	 * @param setWhen
	 */
	public void setSetWhen(String setWhen)
	{
		this.setWhen = new Date(1000L * Long.parseLong(setWhen));
	}

	/**
	 * @param setBy
	 */
	public void setSetBy(String setBy)
	{
		this.setBy = setBy;
	}

  /**
   * Gets who set the topic
   *
   * @return topic setter
   */
	public String getSetBy()
	{
		return this.setBy;
	}

  /**
   * Gets when topic was set
   *
   * @return when
   */
	public Date getSetWhen()
	{
		return this.setWhen;
	}

	/* (non-Javadoc)
	 * @see com.cathive.fx.irc.jerklib.events.TopicEvent#getChannel()
	 */
	public Channel getChannel()
	{
		return this.channel;
	}

	/**
	 * @param topic
	 */
	public void appendToTopic(final String topic)
	{
		this.buff.append(topic);
	}

    @Override
	public int hashCode()
	{
		return channel.hashCode();
	}

    @Override
	public boolean equals(Object o)
	{
		if (o == this) { return true; }
		if (o instanceof TopicEvent && o.hashCode() == hashCode()) { return ((TopicEvent) o).getChannel().equals(getChannel()); }
		return false;
	}

}
