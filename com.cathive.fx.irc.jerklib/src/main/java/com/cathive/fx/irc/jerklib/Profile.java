package com.cathive.fx.irc.jerklib;

/**
 * A class to hold information about Username, Realname, Nick,RealName,AltNic etc.
 * 
 * @see ConnectionManager#ConnectionManager(Profile)
 * @see ConnectionManager#requestConnection(String, int, Profile)
 * @author mohadib 
 */
public class Profile {

	private String name, realName , actualNick, firstNick, secondNick, thirdNick;

	/**
	 * Create a new Profile
	 * 
	 * @param name Username
     * @param realName real name
     * @param nick Nick
	 * @param secondNick Alt nick 1
	 * @param thirdNick Alt nick 2
	 */
	public Profile(String name, String realName, String nick, String secondNick, String thirdNick)
	{
		this.realName = realName == null ? name : realName;
        this.name = name == null ? "" : name;
		this.firstNick = nick == null ? "" : nick;
		this.secondNick = secondNick == null ? "" : secondNick;
		this.thirdNick = thirdNick == null ? "" : thirdNick;
		actualNick = firstNick;
	}

    /**
	 * Create a new Profile
	 *
	 * @param name Username
	 * @param nick Nick     
	 * @param secondNick Alt nick 1
	 * @param thirdNick Alt nick 2
	 */
    public Profile(String name, String nick,String secondNick, String thirdNick) 
    {
        this.realName = name;
        this.name = name == null ? "" : name;
		this.firstNick = nick == null ? "" : nick;
		this.secondNick = secondNick == null ? "" : secondNick;
		this.thirdNick = thirdNick == null ? "" : thirdNick;
		actualNick = firstNick;
    }

	
	/**
	 * Create a new Profile.
	 * Alt. nicks will be generated by adding the number 1 or 2 to the end of the nick.
	 * 
	 * @param name username
     * @param realName 
	 * @param nick
	 */
	public Profile(String name, String realName, String nick)
	{
		this(name, realName, nick, nick + "1", nick + "2");
	}

	/**
	 * Create a new Profile.
	 * Name is set to nick.
	 * Alt. nicks will be generated by adding the number 1 or 2 to the end of the nick.
	 * 
	 * @param nick
	 */
	public Profile(String nick)
	{
		this(nick, nick, nick, nick + "1", nick + "2");
	}


	/**
	 * return the name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Rreturn the first nick
	 * @return first nick
	 */
	public String getFirstNick()
	{
		return firstNick;
	}

	/**
	 * Get the second nick
	 * 
	 * @return second nick
	 */
	public String getSecondNick()
	{
		return secondNick;
	}

	/**
	 * Get the third nick
	 * @return third nick
	 */
	public String getThirdNick()
	{
		return thirdNick;
	}

	/**
	 * Get the nick currently being used.
	 * 
	 * @return current actual nick
	 */
	public String getActualNick()
	{
		return actualNick;
	}

	/**
	 * Set current nick
	 * @param aNick
	 */
	void setActualNick(String aNick)
	{
		actualNick = aNick;
	}

	/**
	 * Set first nick
	 * @param nick
	 */
	void setFirstNick(String nick)
	{
		firstNick = nick;
	}

    /**
     * get the rewal name
     *  @return real name
     */
    public String getRealName()
    {
        return realName;
    }

    /**
     * Set the real name
     * @param realName
     */
    public void setRealName(String realName)
    {
        this.realName = realName;
    }

    @Override
	public boolean equals(Object o)
	{
		if (this == o) { return true; }
		if (o == null || getClass() != o.getClass()) { return false; }

		Profile profile = (Profile) o;

		if (actualNick != null ? !actualNick.equals(profile.getActualNick()) : profile.getActualNick() != null) { return false; }
		if (name != null ? !name.equals(profile.getName()) : profile.getName() != null) { return false; }

		return true;
	}

    @Override
	public int hashCode()
	{
		int result;
		result = (name != null ? name.hashCode() : 0);
		result = 31 * result + (actualNick != null ? actualNick.hashCode() : 0);
		return result;
	}

    @Override
	public Profile clone()
	{
		Profile impl = new Profile(name, realName, firstNick, secondNick, thirdNick);
		impl.setActualNick(actualNick);
		return impl;
	}

}
