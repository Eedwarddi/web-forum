package forum.service;

import java.util.List;

import forum.entity.Thread;

public interface ThreadService {
	
	public List<Thread> getThreads();
	
	public void saveThread(Thread thread);

}
