package forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import forum.dao.ThreadDAO;
import forum.entity.Category;
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
		
		Category tempCategory = categoryController.getCategory(thread.getCategory().getId());
		
		tempCategory.add(thread);
		
		int threadId = threadDAO.saveThread(thread);
		
		Thread savedThread = threadDAO.getThread(threadId);
		
		return savedThread;
	}

	@Override
	@Transactional
	public List<Thread> getThreadsByCategory(int categoryId) {
		return threadDAO.getThreadsByCategory(categoryId);
	}

}
