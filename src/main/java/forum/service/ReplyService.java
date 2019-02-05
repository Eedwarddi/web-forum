package forum.service;

import java.util.List;

import forum.entity.Reply;

public interface ReplyService {
	
	public Reply saveReply(Reply reply);
	
	public List<Reply> getRepliesForThread(int threadId);

}
