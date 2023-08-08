package tw.yuan.tutor;

import java.util.HashMap;
import java.util.HashSet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/myserver")
public class MyServer {
	private static HashSet<Session> sessions;
	private static HashMap<String, Session> users;
	private static HashMap<String, String> userNames;
	
	public MyServer() {
		System.out.println("MyServer()");
		if(sessions == null) {
			sessions = new HashSet<>();
			users = new HashMap<>();
			userNames = new HashMap<>();
		}
	}
	
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("onOpen(): " + session.getId());
		session.setMaxIdleTimeout(1000*60*10);//這裡的單位是毫秒
		if(sessions.add(session)) {
			//sessions.add(session)會return布林判斷有沒有add進去
			users.put(session.getId(), session);
		}
		System.out.println("count: " + sessions.size());
	}//事件觸發時自動呼叫
	
	@OnMessage
	public void onMessage(String message , Session session) {
		
	}//事件觸發時自動呼叫
	
	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose(): " + session.getId());
		users.remove(session.getId());
		userNames.remove(session.getId());
		sessions.remove(session);
		System.out.println("count: " + sessions.size());
	}//閒置時呼叫、主動呼叫
	
	@OnError
	public void onError(Session session , Throwable t) {
		System.out.println("onError(): " + session.getId());
		users.remove(session.getId());
		userNames.remove(session.getId());
		sessions.remove(session);
		System.out.println("count: " + sessions.size());
	}//事件觸發時自動呼叫
}
