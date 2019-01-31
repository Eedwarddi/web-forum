package forum.dao;

import forum.entity.Thread;

public interface ThreadDAO {
	
	public int saveThread(Thread thread);
	
	public Thread getThread(int id);

}
