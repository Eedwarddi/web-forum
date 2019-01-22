package forum.rest;

import java.util.List;

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

	@Autowired
	private CategoryRestController categoryController;

	@PostMapping("/threads")
	public Thread addThread(@RequestBody Thread theThread) {

		theThread.setId(0);

		threadService.saveThread(theThread);

		theThread.setCategory(categoryController.getCategory(theThread.getCategory().getId()));

		return theThread;
	}
	
	@GetMapping("/categories/{categoryId}/threads")
	public List<Thread> getThreadsByCategory(@PathVariable int categoryId) {
		return threadService.getThreadsByCategory(categoryId);
	}

}
