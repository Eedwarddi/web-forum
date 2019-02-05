package forum.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import forum.entity.Reply;
import forum.service.ReplyService;
import forum.service.ThreadService;
import forum.entity.Thread;

@RestController
@RequestMapping("/api")
public class ReplyRestController {
	
	@Autowired
	private ReplyService replyService;
	
	@Autowired
	private ThreadService threadService;
	
	@PostMapping("/threads/{threadId}/replies")
	public Reply addReply(@Valid @RequestBody Reply theReply, @PathVariable int threadId) {
		
		Thread thread = threadService.getThread(threadId);

		if (thread == null) {
			throw new ForumItemNotFoundException("Thread id not found - " + threadId);
		}
		
		theReply.setThread(thread);
		
		Reply savedReply = replyService.saveReply(theReply);
		
		return savedReply;
		
	}
	
	@GetMapping("/threads/{threadId}/replies")
	public List<Reply> getRepliesForThread(@PathVariable int threadId) {
		
		Thread thread = threadService.getThread(threadId);

		if (thread == null) {
			throw new ForumItemNotFoundException("Thread id not found - " + threadId);
		}
		
		return replyService.getRepliesForThread(threadId);
		
	}

}
