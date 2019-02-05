package forum.service;

import java.util.List;

import forum.entity.Thread;

public interface ThreadService {

	public List<Thread> getThreadsByCategory(int categoryId);

	public Thread saveThread(Thread thread);
	
	public Thread getThread(int id);

}
