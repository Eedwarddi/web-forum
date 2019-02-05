package forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import forum.dao.ThreadDAO;
import forum.entity.Thread;

@Service
public class ThreadServiceImpl implements ThreadService {
	
	@Autowired
	private ThreadDAO threadDAO;

	@Override
	@Transactional
	public Thread saveThread(Thread thread) {
		
		int threadId = threadDAO.saveThread(thread);
		
		Thread savedThread = threadDAO.getThread(threadId);
		
		return savedThread;
	}

	@Override
	@Transactional
	public List<Thread> getThreadsByCategory(int categoryId) {
		
		return threadDAO.getThreadsByCategory(categoryId);
	}

	@Override
	@Transactional
	public Thread getThread(int id) {
		return threadDAO.getThread(id);
	}

}
