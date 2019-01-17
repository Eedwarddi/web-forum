package forum.rest;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import forum.entity.Category;
import forum.service.ForumService;

@RestController
@RequestMapping("/api")
public class CategoryRestController {
	
	@Autowired
	private ForumService forumService;
	
	private List<Category> categories;
	
	@PostConstruct
	public void loadData() {
		
		categories = forumService.getCategories();
	}
	
	@GetMapping("/categories")
	public List<Category> getCategories() {
		return categories;
	}
	
	@GetMapping("/categories/{categoryId}")
	public Category getCategory(@PathVariable int categoryId) {
		
		Category category = forumService.getCategory(categoryId);
		
		if(category == null) {
			throw new ForumItemNotFoundException("Category id not found - " + categoryId);
		}
		
		return category;
		
	}

}
