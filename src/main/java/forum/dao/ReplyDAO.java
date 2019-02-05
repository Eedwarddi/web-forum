package forum.dao;

import java.util.List;

import forum.entity.Reply;

public interface ReplyDAO {
	
	public int saveReply(Reply reply);
	
	public Reply getReply(int id);
	
	public List<Reply> getRepliesForThread(int threadId);

}
