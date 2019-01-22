package forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import forum.entity.Thread;

@Repository
public class ThreadDAOImpl implements ThreadDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveThread(Thread thread) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(thread);
		
	}

	@Override
	public List<Thread> getThreads() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Thread> theQuery = currentSession.createQuery("from Thread", Thread.class);
		
		List<Thread> threads = theQuery.getResultList();
		
		return threads;
	}

}
