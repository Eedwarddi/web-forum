package forum.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		
		int result = (int) currentSession.save(reply);
		
		return result;
	}

	@Override
	public Reply getReply(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Reply reply = currentSession.get(Reply.class, id);
		
		return reply;
	}

}
