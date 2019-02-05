package forum.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import forum.entity.Reply;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public int saveReply(Reply reply) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		int replyId = (int) currentSession.save(reply);
		
		return replyId;
	}

	@Override
	public Reply getReply(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Reply reply = currentSession.get(Reply.class, id);
		
		return reply;
	}

	@Override
	public List<Reply> getRepliesForThread(int threadId) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Reply> theQuery = currentSession.createQuery("from Reply where thread_id=:threadId", Reply.class);
		
		theQuery.setParameter("threadId", threadId);
		
		List<Reply> replies = theQuery.getResultList();

		return replies;
	}
	
}
