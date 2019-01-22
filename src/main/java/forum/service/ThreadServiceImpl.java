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
	public void saveThread(Thread thread) {
		threadDAO.saveThread(thread);
	}

	@Override
	@Transactional
	public List<Thread> getThreads() {
		
		return threadDAO.getThreads();
	}

	@Override
	@Transactional
	public List<Thread> getThreadsByCategory(int categoryId) {
		return threadDAO.getThreadsByCategory(categoryId);
	}

}
