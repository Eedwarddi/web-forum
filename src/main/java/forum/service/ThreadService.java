package forum.service;

import forum.entity.Thread;

public interface ThreadService {

	public List<Thread> getThreadsByCategory(int categoryId);

	public Thread saveThread(Thread thread);

}
