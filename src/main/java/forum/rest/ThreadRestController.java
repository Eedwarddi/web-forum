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

import forum.entity.Category;
import forum.entity.Thread;
import forum.service.CategoryService;
import forum.service.ThreadService;

@RestController
@RequestMapping("/api")
public class ThreadRestController {

	@Autowired
	private ThreadService threadService;
	
	@Autowired
	private CategoryService categoryService;

	@PostMapping("categories/{categoryId}/threads")
	public Thread addThread(@Valid @RequestBody Thread theThread, @PathVariable int categoryId) {
		
		theThread.setCategory(new Category());
		
		theThread.getCategory().setId(categoryId);
		
		Thread savedThread = threadService.saveThread(theThread);

		return savedThread;
	}
	
	@GetMapping("/categories/{categoryId}/threads")
	public List<Thread> getThreadsByCategory(@PathVariable int categoryId) {
		
		Category category = categoryService.getCategory(categoryId);

		if (category == null) {
			throw new ForumItemNotFoundException("Category id not found - " + categoryId);
		}
		
		return threadService.getThreadsByCategory(categoryId);
	}

}
