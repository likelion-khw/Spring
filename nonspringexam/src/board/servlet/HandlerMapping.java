package board.servlet;

import java.util.ArrayList;
import java.util.HashMap;

public class HandlerMapping {

	private HashMap<String, Controller> mappings;
	
	public HandlerMapping(ArrayList<BoardVO> abvo) {
		mappings = new HashMap<String, Controller>();
		mappings.put("list.board", new ListController(abvo));
		mappings.put("insert.board", new InsertController(abvo));
		mappings.put("update.board", new UpdateController(abvo));
		mappings.put("delete.board", new DeleteController(abvo));
		mappings.put("reply.board", new ReplyController(abvo));
	}

	public Controller getController(String key) {
		return mappings.get(key);
	}
	
	

}
