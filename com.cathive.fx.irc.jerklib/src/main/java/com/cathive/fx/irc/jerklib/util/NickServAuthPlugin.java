package com.cathive.fx.irc.jerklib.util;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.cathive.fx.irc.jerklib.ModeAdjustment;
import com.cathive.fx.irc.jerklib.Session;
import com.cathive.fx.irc.jerklib.ModeAdjustment.Action;
import com.cathive.fx.irc.jerklib.events.IRCEvent;
import com.cathive.fx.irc.jerklib.events.ModeEvent;
import com.cathive.fx.irc.jerklib.events.IRCEvent.Type;
import com.cathive.fx.irc.jerklib.tasks.TaskImpl;

/**
 * 
 * A Task to identify with NickServ and then join a list of channels names.
 * Once the Task has succsessfully identifed with NickServ
 * TaskCompletion Listeners will be notified with a true Boolean object.
 * <p>
 * If 40 seconds passes and the mode event to indicate ident success has not
 * been received, TaskCompletion Listeners will be notified with a false Boolean object.
 * <p>
 * This plugin assumes Nickserv responds to the following syntax
 * <p>
 * "identify password"
 * <p>
 * To cancel this Task call cancel()
 * <p>
 * Example Code:
 * <p>
<pre> 		
 		final NickServAuthPlugin auth = new NickServAuthPlugin
		(
			"letmein", //password
			'e', //mode char that indicates success
			session, //session
			Arrays.asList("#com.cathive.fx.irc.jerklib" , "##swing") // list of channels to join on success
		);
		
		// task listener is optional 
		auth.addTaskListener(new TaskCompletionListener()
		{
			public void taskComplete(Object result)
			{
				if(result.equals(new Boolean(false)))
				{
					conman.quit();
				}
				else
				{
					System.out.println("Authed!");
				}
			}
		});
</pre>
 * 
 * 
 * @see Session#onEvent(com.cathive.fx.irc.jerklib.tasks.Task, com.cathive.fx.irc.jerklib.events.IRCEvent.Type...)
 * @see Type
 * @author mohadib
 *
 */
public class NickServAuthPlugin extends TaskImpl
{
	private final Session session;
	private final String pass;
	private final char identMode;
	private final List<String> channels;
	private boolean authed;
	
	/**
	 * @param pass - nickserv password
	 * @param identMode - mode that indicates ident success
	 * @param session - Session this Task is attatched to
	 * @param channels - A list of channel names to join on ident success
	 */
	public NickServAuthPlugin
	(
		String pass , 
		char identMode,
		Session session,
		List<String>channels
	)
	{
		super("NickServAuth");
		this.pass = pass;
		this.identMode = identMode;
		this.session = session;
		this.channels = channels;
		
		session.onEvent(this , Type.CONNECT_COMPLETE , Type.MODE_EVENT);
	}
	
	/* (non-Javadoc)
	 * @see com.cathive.fx.irc.jerklib.listeners.IRCEventListener#receiveEvent(com.cathive.fx.irc.jerklib.events.IRCEvent)
	 */
	public void receiveEvent(IRCEvent e)
	{
		if(e.getType() == Type.CONNECT_COMPLETE)connectionComplete(e);
		else if(e.getType() == Type.MODE_EVENT)mode(e);
	}
	
	private void mode(IRCEvent e)
	{
		ModeEvent me = (ModeEvent)e;
		if(me.getModeType() == ModeEvent.ModeType.USER)
		{
			for(ModeAdjustment ma : me.getModeAdjustments())
			{
				if(ma.getMode() == identMode && ma.getAction() == Action.PLUS)
				{
					authed = true;
					joinChannels();
					taskComplete(new Boolean(true));
				}
			}
		}
	}
	
	private void connectionComplete(IRCEvent e)
	{
		authed = false;
		e.getSession().sayPrivate( "nickserv" , "identify " + pass);
		final Timer t = new Timer();
		t.schedule(new TimerTask()
		{
			public void run()
			{
				if(!authed)
				{
					taskComplete(new Boolean(false));
				}
				this.cancel();
				t.cancel();
			}
		}, 40000 );
	}
	
	private void joinChannels()
	{
		for(String name : channels)
		{
			session.join(name);
		}
	}
	
}
