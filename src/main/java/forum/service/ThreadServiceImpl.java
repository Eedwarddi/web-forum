package forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import forum.dao.ThreadDAO;
import forum.entity.Thread;
import forum.rest.CategoryRestController;

@Service
public class ThreadServiceImpl implements ThreadService {
	
	@Autowired
	private ThreadDAO threadDAO;
	
	@Autowired
	private CategoryRestController categoryController;

	@Override
	@Transactional
	public Thread saveThread(Thread thread) {
		threadDAO.saveThread(thread);
		
		thread.setCategory(categoryController.getCategory(thread.getCategory().getId()));
		
		return thread;
	}

	@Override
	@Transactional
	public List<Thread> getThreads() {
		
		return threadDAO.getThreads();
	}

}
