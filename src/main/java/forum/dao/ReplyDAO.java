package forum.dao;

import forum.entity.Reply;

public interface ReplyDAO {
	
	public int saveReply(Reply reply);
	
	public Reply getReply(int id);

}
