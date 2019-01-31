package forum.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import forum.entity.Reply;
import forum.service.ReplyService;

@RestController
@RequestMapping("/api")
public class ReplyRestController {
	
	@Autowired
	private ReplyService replyService;
	
	@PostMapping("/replies")
	public Reply addReply(@Valid @RequestBody Reply theReply) {
		
		Reply savedReply = replyService.saveReply(theReply);
		
		return savedReply;
		
	}
	

}
