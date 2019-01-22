package forum.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import forum.entity.Category;
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

}
