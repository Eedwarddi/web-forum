package forum.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import forum.entity.Thread;

@Repository
public class ThreadDAOImpl implements ThreadDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveThread(Thread thread) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		int result = (int) currentSession.save(thread);
		
		return result;
		
	}
	
	@Override
	public Thread getThread(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Thread thread = currentSession.get(Thread.class, id);
		
		return thread;
	}
<<<<<<< HEAD

	@Override
	public List<Thread> getThreadsByCategory(int categoryId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Thread> theQuery = currentSession.createQuery("from Thread where category_id=:categoryId", Thread.class);
		
		theQuery.setParameter("categoryId", categoryId);
		
		List<Thread> threads = theQuery.getResultList();
		
		return threads;
	}

=======
	
>>>>>>> master
}
