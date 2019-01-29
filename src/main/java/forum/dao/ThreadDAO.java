package forum.dao;

import forum.entity.Thread;

public interface ThreadDAO {

	public List<Thread> getThreadsByCategory(int categoryId);

	public int saveThread(Thread thread);

	public Thread getThread(int id);


}
