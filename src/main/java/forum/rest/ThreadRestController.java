package forum.rest;

<<<<<<< HEAD
import java.util.List;
=======
import javax.validation.Valid;
>>>>>>> master

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import forum.entity.Thread;
import forum.service.ThreadService;

@RestController
@RequestMapping("/api")
public class ThreadRestController {

	@Autowired
	private ThreadService threadService;

	@PostMapping("/threads")
	public Thread addThread(@Valid @RequestBody Thread theThread) {

		Thread savedThread = threadService.saveThread(theThread);

		return savedThread;
	}
	
	@GetMapping("/categories/{categoryId}/threads")
	public List<Thread> getThreadsByCategory(@PathVariable int categoryId) {
		return threadService.getThreadsByCategory(categoryId);
	}

}
