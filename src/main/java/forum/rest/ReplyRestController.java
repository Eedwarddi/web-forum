package forum.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import forum.entity.Reply;
import forum.service.ReplyService;
import forum.entity.Thread;

@RestController
@RequestMapping("/api")
public class ReplyRestController {
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/threads/{threadId}/replies")
	public Reply addReply(@Valid @RequestBody Reply theReply, @PathVariable int threadId) {
		
		theReply.setThread(new Thread());
		
		theReply.getThread().setId(threadId);
		
		Reply savedReply = replyService.saveReply(theReply);
		
		return savedReply;
		
	}
	

}
