package alex.buffer.visual;

import java.util.HashMap;
import java.util.Map;

public class KeyStateHandler {
	protected Map<String, Boolean> keyMap = new HashMap<String, Boolean>();
	protected KeyTypeListener listener;
	
	
	public KeyStateHandler(KeyTypeListener listener){
		this.listener = listener;
	}
}
