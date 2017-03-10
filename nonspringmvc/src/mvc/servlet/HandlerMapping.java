package mvc.servlet;

import java.util.HashMap;

public class HandlerMapping {

	private HashMap<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("hellow.mvc", new HellowController());
		mappings.put("login.mvc", new LoginController());
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
	
	

}
