package forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import forum.dao.ReplyDAO;
import forum.entity.Reply;

@Service
public class ReplyServiceImpl implements ReplyService {
	
	@Autowired
	private ReplyDAO replyDAO;

	@Override
	@Transactional
	public Reply saveReply(Reply reply) {
		
		int replyId = replyDAO.saveReply(reply);
		
		Reply savedReply = replyDAO.getReply(replyId);
		
		return savedReply;
	}

	@Override
	@Transactional
	public List<Reply> getRepliesForThread(int threadId) {

		return replyDAO.getRepliesForThread(threadId);
	}

}
