package tw.yuan.tutor;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.json.JSONObject;

@ServerEndpoint(value = "/myserver")
public class MyServer {
	private static HashSet<Session> sessions;
	private static HashMap<String, Session> users;
	private static HashMap<String, String> userNames;

	public MyServer() {
		System.out.println("MyServer()");
		if (sessions == null) {
			sessions = new HashSet<>();
			users = new HashMap<>();
			userNames = new HashMap<>();
		}
	}

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("onOpen(): " + session.getId());
		session.setMaxIdleTimeout(1000 * 60 * 2);// 這裡的單位是毫秒
		if (sessions.add(session)) {
			// sessions.add(session)會return布林判斷有沒有add進去
			users.put(session.getId(), session);
		}
		System.out.println("count: " + sessions.size());
	}// 事件觸發時自動呼叫

	@OnMessage
	public void onMessage(String message, Session session) {
		System.out.println(session.getId() + ":" + message);

		JSONObject root = new JSONObject(message);
		if (root.getInt("mode") == 1) {
			userNames.put(session.getId(), root.getString("user")) ;
		} else if (root.getInt("mode") == 2) {
			String mesg = root.getString("message");
			
			JSONObject jsonobj = new JSONObject();
			jsonobj.put("user", userNames.get(session.getId()));
			jsonobj.put("message", mesg);
			
			for(Session userSession : sessions) {
				try {
					userSession.getBasicRemote()
					.sendText(jsonobj.toString());
					//送到JS端的onmessage的event物件(data屬性)
				} catch (IOException e) {
					System.out.println(e);
				}
			}
		}
	}// 事件觸發時自動呼叫

	@OnClose
	public void onClose(Session session) {
		System.out.println("onClose(): " + session.getId());
		users.remove(session.getId());
		userNames.remove(session.getId());
		sessions.remove(session);
		System.out.println("count: " + sessions.size());
	}// 閒置時呼叫、主動呼叫

	@OnError
	public void onError(Session session, Throwable t) {
		System.out.println("onError(): " + session.getId());
		users.remove(session.getId());
		userNames.remove(session.getId());
		sessions.remove(session);
		System.out.println("count: " + sessions.size());
	}// 事件觸發時自動呼叫
}
